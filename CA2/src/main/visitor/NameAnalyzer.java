package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declarator.pointer.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.declarator.*;
import main.ast.nodes.expression.operator.BinaryOperator;
import main.ast.nodes.expression.operator.UnaryOperator;
import main.ast.nodes.specifier.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.type.*;
import main.ast.nodes.expression.initializer.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FunctionItem;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.item.VariableItem;
import main.symbolTable.utils.DeclaratorUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NameAnalyzer extends Visitor<Void> {
    private boolean isInFunctionCallContext = false;
    private int argCount = 0;

    private static final List<String> BUILT_INS = List.of("printf", "scanf");

    private boolean isBuiltIn(String name) {
        return name != null && BUILT_INS.contains(name.trim());
    }


    @Override
    public Void visit(Program program) {
        SymbolTable.root = new SymbolTable(null);
        SymbolTable.push(SymbolTable.root);

        program.setSymbolTable(SymbolTable.top);

        for (Declaration declaration : program.getDeclarations()) {
            declaration.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FuncDec funcDec) {
        Declarator declarator = funcDec.getDeclarator();
        String funcName = DeclaratorUtils.extractName(declarator);
        List<SymbolTableItem> params = DeclaratorUtils.extractFunctionParamItems(declarator);

        try {
            SymbolTable.top.put(new FunctionItem(funcName , DeclaratorUtils.extractTypes(funcDec.getSpecifiers()),params));
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Line:" + funcDec.getLine() + "-> function " + funcName + " already declared");
        }

        SymbolTable funcScope = new SymbolTable(SymbolTable.top);
        SymbolTable.push(funcScope);
        funcDec.set_symbol_table(funcScope);

        if (declarator != null)
            declarator.accept(this);

        if (funcDec.getStatement() != null)
            funcDec.getStatement().accept(this);

        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
        SymbolTable newScope = new SymbolTable(SymbolTable.top);
        SymbolTable.push(newScope);
        compoundStatement.set_symbol_table(newScope);
        for (BlockItem item : compoundStatement.getSelfItems()) {
            item.accept(this);
        }

        SymbolTable.pop();
        return null;
    }


    @Override
    public Void visit(DoWhileStatement doWhileStatement) {
        Expression condition = doWhileStatement.getCondition();
        Statement body = doWhileStatement.getBody();
        if(condition != null) {
            condition.accept(this);
        }
        if(body != null) {
            body.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(WhileStatement whileStatement) {
        Expression condition = whileStatement.getCondition();
        Statement body = whileStatement.getBody();
        if(condition != null) {
            condition.accept(this);
        }
        if(body != null) {
            body.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForStatement forStatement) {
        ForCondStatement condition = forStatement.getCondition();
        Statement body = forStatement.getBody();
        if(condition != null) {
            condition.accept(this);
        }
        if(body != null){
            body.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForCondStatement forCondStatement){
        if (forCondStatement.getInitDeclaration() != null)
            forCondStatement.getInitDeclaration().accept(this);

        if (forCondStatement.getInitExpression() != null)
            forCondStatement.getInitExpression().accept(this);

        if (forCondStatement.getConditions() != null) {
            for (Expression condition : forCondStatement.getConditions()) {
                condition.accept(this);
            }
        }

        if (forCondStatement.getUpdateExpressions() != null) {
            for (Expression update : forCondStatement.getUpdateExpressions()) {
                update.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(IfStatement ifStatement) {
        Expression condition = ifStatement.getCondition();
        Statement thenBody = ifStatement.getThenStatement();
        Statement elseBody = ifStatement.getElseStatement();
        if (condition != null) {
            condition.accept(this);
        }
        if (thenBody != null) {
            thenBody.accept(this);
        }
        if (elseBody != null) {
            elseBody.accept(this);
        }
        return null;
    }


    @Override
    public Void visit(VarDec varDec) {
        List<InitDeclarator> declarators = varDec.getInitDeclarators();
        List<Type> types = DeclaratorUtils.extractTypes(varDec.getSpecifiers());

        if (declarators != null && !declarators.isEmpty()) {
            for (InitDeclarator init : declarators) {
                Declarator declarator = init.getDeclarator();
                String name = DeclaratorUtils.extractName(declarator);

                try {
                    SymbolTable.top.put(new VariableItem(name, types));
                } catch (ItemAlreadyExistsException e) {
                    System.out.println("Line:" + varDec.getLine() + "-> " + name + " already declared");
                }
            }
        } else {
            String s_name = DeclaratorUtils.extractVarName(varDec.getSpecifiers());
            if (s_name != null) {
                try {
                    SymbolTable.top.put(new VariableItem(s_name, types));
                } catch (ItemAlreadyExistsException e) {
                    System.out.println("Line:" + varDec.getLine() + "-> " + s_name + " already declared");
                }
            }
        }

        return null;
    }


    @Override
    public Void visit(ParamDec paramDec) {
        List<Specifier> specs = paramDec.getSpecifiers();
        List<Type> types = DeclaratorUtils.extractTypes(specs);

        String name = null;

        if (paramDec.getDeclarator() != null) {
            name = DeclaratorUtils.extractName(paramDec.getDeclarator());
        }

        if (name == null) {
            name = DeclaratorUtils.extractVarName(specs);
        }

        if (name != null) {
            try {
                SymbolTable.top.put(new VariableItem(name, types));
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line:" + paramDec.getLine() + "-> " + name + " already declared");
            }
        }

        return null;
    }

    @Override
    public Void visit(Declarator declarator) { return null; }

    @Override
    public Void visit(ArrayDeclarator arrayDeclarator) { return null; }

    @Override
    public Void visit(FunctionDeclarator functionDeclarator) {
        List<ParamDec> params = functionDeclarator.getParameters();

        for (ParamDec param : params) {
            param.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IdentifierDeclarator identifierDeclarator) { return null; }

    @Override
    public Void visit(InitDeclarator initDeclarator) { return null; }

    @Override
    public Void visit(PointerDeclarator pointerDeclarator) {
        if(pointerDeclarator.getDeclarator() != null)
            pointerDeclarator.getDeclarator().accept(this);
        return null;
    }

    @Override
    public Void visit(StarPointer starPointer) { return null; }

    @Override
    public Void visit(Expression expression) { return null; }

    @Override
    public Void visit(ArrayExpression arrayExpression) {
        if (arrayExpression.getAssigned() != null)
            arrayExpression.getAssigned().accept(this);
        if (arrayExpression.getIndex() != null)
            arrayExpression.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        if (binaryExpression.getLeftOperand() != null)
            binaryExpression.getLeftOperand().accept(this);
        if (binaryExpression.getRightOperand() != null)
            binaryExpression.getRightOperand().accept(this);
        return null;
    }


    @Override
    public Void visit(CastExpression castExpression) {
        if (castExpression.getTargetType() != null)
            castExpression.getTargetType().accept(this);
        if (castExpression.getExpression() != null)
            castExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(CommaExpression commaExpression) {
        for (Expression expr : commaExpression.getExpressions()) {
            expr.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(CompoundLiteralExpression compoundLiteralExpression) {
        if (compoundLiteralExpression.getType() != null)
            compoundLiteralExpression.getType().accept(this);
        if (compoundLiteralExpression.getInitializers() != null) {
            for (InitializerEntry entry : compoundLiteralExpression.getInitializers()) {
                entry.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ConditionalExpression conditionalExpression) {
        if (conditionalExpression.getCondition() != null)
            conditionalExpression.getCondition().accept(this);
        if (conditionalExpression.getTrueExpression() != null)
            conditionalExpression.getTrueExpression().accept(this);
        if (conditionalExpression.getFalseExpression() != null)
            conditionalExpression.getFalseExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ConstExpression constExpression) { return null; }

    @Override
    public Void visit(DigitSequenceExpression digitSequenceExpression) { return null; }

    @Override
    public Void visit(FunctionCallExpression functionCallExpression) {
        Expression functionExpr = functionCallExpression.getFunction();
        isInFunctionCallContext = true;
        argCount = countFunctionArguments(functionCallExpression);
        functionExpr.accept(this);
        isInFunctionCallContext = false;

        for (Expression arg : functionCallExpression.getArguments()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IdExpression idExpression) {
        String name = idExpression.getValue();
        if (isInFunctionCallContext) {
            if (name == null || isBuiltIn(name))
                return null;

            try {
                SymbolTable.top.findFunctionByName(name , argCount);
                argCount = 0; // Reset argCount after visiting a function call
            } catch (ItemNotFoundException e) {
                System.out.println("Line:" + idExpression.getLine() + "-> " + name + " not declared");
            }
            return null;
        }

        try {
            SymbolTable.top.getItem(name);
        } catch (ItemNotFoundException e) {
            System.out.println("Line:" + idExpression.getLine() + "-> " + name + " not declared");
        }
        return null;
    }

    @Override
    public Void visit(SizeofExpression sizeofExpression) {
        if (sizeofExpression.getTypeName() != null)
            sizeofExpression.getTypeName().accept(this);
        return null;
    }
    @Override
    public Void visit(StringExpression stringExpression) { return null; }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        if (unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(Initializer initializer) {
        if (initializer.getExpression() != null) {
            initializer.getExpression().accept(this);
        }

        for (InitializerEntry entry : initializer.getInitializerList()) {
            entry.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(InitializerEntry initializerEntry) {
        for (Designator designator : initializerEntry.getDisignators()) {
            designator.accept(this);
        }

        if (initializerEntry.getInitializer() != null) {
            initializerEntry.getInitializer().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FieldDesignator fieldDesignator) { return null; }

    @Override
    public Void visit(ArrayDesignator arrayDesignator) {
        if (arrayDesignator.getIndex() != null)
            arrayDesignator.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(Designator designator) {
        if (designator instanceof FieldDesignator)
            designator.accept(this);
        else if (designator instanceof ArrayDesignator)
            designator.accept(this);
        return null;
    }
    @Override
    public Void visit(Specifier specifier) { return null; }

    @Override
    public Void visit(ConstSpecifier constSpecifier) { return null; }

    @Override
    public Void visit(TypedefSpecifier typedefSpecifier) { return null; }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        Expression expression = expressionStatement.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BreakStatement breakStatement) {
        return null;
    }

    @Override
    public Void visit(ContinueStatement continueStatement) {
        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement) {
        Expression expression = returnStatement.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Type type) { return null; }

    @Override
    public Void visit(BoolType boolType) { return null; }

    @Override
    public Void visit(CharType charType) { return null; }

    @Override
    public Void visit(DoubleType doubleType) { return null; }

    @Override
    public Void visit(FloatType floatType) { return null; }

    @Override
    public Void visit(IdType idType) { return null; }

    @Override
    public Void visit(IntType intType) { return null; }

    @Override
    public Void visit(LongType longType) { return null; }

    @Override
    public Void visit(ShortType shortType) { return null; }

    @Override
    public Void visit(SignedType signedType) { return null; }

    @Override
    public Void visit(UnsignedType unsignedType) { return null; }

    @Override
    public Void visit(VoidType voidType) { return null; }

    private int countFunctionArguments(FunctionCallExpression callExpr) {
        int count = 0;
        for (Expression arg : callExpr.getArguments()) {
            count += countArgsRecursive(arg);
        }
        return count;
    }

    private int countArgsRecursive(Expression expr) {
        if (expr instanceof CommaExpression comma) {
            int sum = 0;
            for (Expression subExpr : comma.getExpressions()) {
                sum += countArgsRecursive(subExpr);
            }
            return sum;
        }
        return 1;
    }
}

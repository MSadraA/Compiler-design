package main.optimizer;

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
import main.visitor.Visitor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static main.symbolTable.utils.DeclaratorUtils.extractName;

public class UnusedVarVisitor extends Visitor<Void> {
    private SymbolTable functionArg = null;
    private boolean isInFunction = false;

    @Override
    public Void visit(Program program) {
        List<Declaration> org_declarations = program.getDeclarations();
        List<Declaration> new_declarations = new ArrayList<>();
        SymbolTable scope = program.getSymbolTable();

        for(Declaration declaration : org_declarations){
            if ((declaration instanceof FuncDec)) {
                new_declarations.add(declaration);
                continue;
            }

            for (SymbolTableItem item : scope.items.values()) {
                if (item instanceof VariableItem variableItem) {
                    if (variableItem.getDeclaration() == declaration && variableItem.getUsed()) {
                        new_declarations.add(declaration);
                        break;
                    }
                }
            }
        }

        program.setDeclarations(new_declarations);

        for (Declaration declaration : program.getDeclarations()) {
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FuncDec funcDec) {
        Declarator declarator = funcDec.getDeclarator();
        functionArg = funcDec.getSymbolTable();

        // Optimize function args
        if ((declarator != null ) && functionArg != null ){
            isInFunction = true;
            declarator.accept(this);
            isInFunction = false;
        }
        functionArg = null;

        // Optimize body
        if (funcDec.getStatement() != null)
            funcDec.getStatement().accept(this);

        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
        SymbolTable scope = compoundStatement.getSymbolTable();
        List<BlockItem> org_items = new ArrayList<>(compoundStatement.getSelfItems());

        List<BlockItem> new_items = new ArrayList<>();
        List<Declaration> new_declarations = new ArrayList<>();
        List<Statement> new_statements = new ArrayList<>();

        for (BlockItem item : org_items) {
            if (item instanceof Statement statement) {
                new_statements.add(statement);
                new_items.add(item);
            } else if (item instanceof Declaration declaration) {
                for (SymbolTableItem s_item : scope.items.values()) {
                    if (s_item instanceof FunctionItem) continue;
                    if (s_item instanceof VariableItem variableItem && variableItem.getUsed()
                            && variableItem.getDeclaration() == declaration) {
                        new_declarations.add(declaration);
                        new_items.add(item);
                        break;
                    }
                }
            }
        }

        compoundStatement.setStatements(new_statements);
        compoundStatement.setDeclarations(new_declarations);
        compoundStatement.setItems(new_items);

        for (BlockItem item : new_items) {
            item.accept(this);
        }

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
        return null;
    }


    @Override
    public Void visit(ParamDec paramDec) {
        return null;
    }

    @Override
    public Void visit(Declarator declarator) { return null; }

    @Override
    public Void visit(ArrayDeclarator arrayDeclarator) { return null; }

    @Override
    public Void visit(FunctionDeclarator functionDeclarator) {
        List<ParamDec> params = functionDeclarator.getParameters();
        List<ParamDec> new_params = new ArrayList<>();

        if(isInFunction){
            for (ParamDec param : params) {
                for(SymbolTableItem item : functionArg.items.values()){
                    if(item instanceof VariableItem && item.getUsed()){
                        if(((VariableItem) item).getDeclaration() == param)
                            new_params.add(param);
                    }
                }
            }
            functionDeclarator.setParameters(new_params);
        }

        for (ParamDec param : functionDeclarator.getParameters()) {
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
        functionExpr.accept(this);

        for (Expression arg : functionCallExpression.getArguments()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IdExpression idExpression) {
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

}

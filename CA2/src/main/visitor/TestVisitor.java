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


import java.util.ArrayList;
import java.util.List;

public class TestVisitor extends Visitor<Integer> {

    private String currentFuncName;
    private boolean inFunctionDeclarator = false;
    private List<String> logs = new ArrayList<>();


    @Override
    public Integer visit(FuncDec funcDec){
        SymbolTable scope = funcDec.getSymbolTable();
        this.currentFuncName = "";
        CompoundStatement statement = funcDec.getStatement();
        Declarator declarator = funcDec.getDeclarator();
        int count = 0;
        int argsCount = 0;
        if (declarator != null){
            inFunctionDeclarator = true;
            argsCount = declarator.accept(this);
        }
        inFunctionDeclarator = false;

        if(statement != null){
            count = statement.accept(this);
            logs.add("Line " + statement.getLine() + ": Stmt function " + currentFuncName + " = " + count + ' ' + argsCount);
        }

        for (int i = (logs.size() - 1) ; i >= 0 ; i--){
            System.out.println(logs.get(i));
        }

        logs.clear();
        currentFuncName = "";
        return 0;
    }

    @Override
    public Integer visit(CompoundStatement compoundStatement){
        int counter = 0;
        List<BlockItem> items = compoundStatement.getSelfItems();
        for (int i = items.size() - 1; i >= 0; i--) {
            counter++;
            items.get(i).accept(this);
        }
        return counter;
    }

    @Override
    public Integer visit(Program program) {
        List<Declaration> declarations = program.getDeclarations();
        for(Declaration declaration : declarations){
            declaration.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(Declaration declaration) {
        return 0;
    }

    @Override
    public Integer visit(ParamDec paramDec) {
        return 0;
    }

    @Override
    public Integer visit(VarDec varDec) {
        List<InitDeclarator> initDeclarators = varDec.getInitDeclarators();
        if(initDeclarators != null) {
            for (int i = initDeclarators.size() - 1; i >= 0; i--) {
                InitDeclarator initDeclarator = initDeclarators.get(i);
                initDeclarator.accept(this);
            }
        }
        return 0;
    }

    @Override
    public Integer visit(ArrayDeclarator arrayDeclarator) {
        Declarator declarator = arrayDeclarator.getDeclarator();
        if (declarator != null){
            declarator.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(FunctionDeclarator functionDeclarator) {
        Declarator declarator = functionDeclarator.getDeclarator();
        if (declarator != null){
            declarator.accept(this);
        }
        List<ParamDec> parameters = functionDeclarator.getParameters();
        if(parameters != null){
            return parameters.size();
        }
        return 0;
    }

    @Override
    public Integer visit(IdentifierDeclarator identifierDeclarator) {
        String name = identifierDeclarator.getName();
        if (name != null && inFunctionDeclarator){
            currentFuncName = name;
        }
        return 0;
    }

    @Override
    public Integer visit(InitDeclarator initDeclarator) {
        Declarator declarator = initDeclarator.getDeclarator();
        Initializer initializer = initDeclarator.getInitializer();
        if(initializer != null){
            initializer.accept(this);
        }
        if(declarator != null){
            declarator.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(PointerDeclarator pointerDeclarator) {
        Declarator declarator = pointerDeclarator.getDeclarator();
        int count = 0;
        if(declarator != null){
            count = declarator.accept(this);
        }
        return count;
    }

    @Override
    public Integer visit(StarPointer starPointer) {
        return 0;
    }

    @Override
    public Integer visit(ArrayExpression arrayExpression) {
        Expression assigned = arrayExpression.getAssigned();
        Expression index = arrayExpression.getIndex();
        if(assigned != null){
            assigned.accept(this);
            return 0;
        }
        if(index != null){
            index.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(BinaryExpression binaryExpression) {
        BinaryOperator operator = binaryExpression.getOperator();

//        logs.add("Line " + binaryExpression.getLine() + ": Expr " + operator.getSymbol());
        return 0;
    }

    @Override
    public Integer visit(CastExpression castExpression) {
        Expression expression = castExpression.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(CommaExpression commaExpression) {
        List<Expression> expressions = commaExpression.getExpressions();
//        logs.add("Line " + commaExpression.getLine() + ": Expr ,");
        return 0;
    }

    @Override
    public Integer visit(CompoundLiteralExpression compoundLiteralExpression) {
        return 0;
    }

    @Override
    public Integer visit(ConditionalExpression conditionalExpression) {
        Expression condition = conditionalExpression.getCondition();
        Expression trueExpression = conditionalExpression.getTrueExpression();
        Expression falseExpression = conditionalExpression.getFalseExpression();
        if(condition != null){
            condition.accept(this);
            return 0;
        }
        if(trueExpression != null){
            trueExpression.accept(this);
            return 0;
        }
        if(falseExpression != null){
            falseExpression.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(ConstExpression constExpression) {
//        logs.add("Line " + constExpression.getLine() + ": Expr " + constExpression.getValue());
        return 0;
    }

    @Override
    public Integer visit(DigitSequenceExpression digitSequenceExpression) {
//        logs.add("Line " + digitSequenceExpression.getLine() + ": Expr " + digitSequenceExpression.getValue());
        return 0;
    }

    @Override
    public Integer visit(FunctionCallExpression functionCallExpression) {
        Expression function = functionCallExpression.getFunction();
        List<Expression> argument = functionCallExpression.getArguments();
        if(function != null){
            function.accept(this);
            return 0;
        }
        if(argument != null){
            argument.get(0).accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(IdExpression idExpression) {
//        String expressionVal = "Line " + idExpression.getLine() + ": Expr " + idExpression.getValue();
//        logs.add(expressionVal);
        return 0;
    }

    @Override
    public Integer visit(SizeofExpression sizeofExpression) {
        return 0;
    }

    @Override
    public Integer visit(StringExpression stringExpression) {
        String value = String.join(" " , stringExpression.getValue());
//        String expressionVal = "Line " + stringExpression.getLine() + ": Expr " + value;
//        logs.add(expressionVal);

        return 0;
    }

    @Override
    public Integer visit(UnaryExpression unaryExpression) {
        Expression expression = unaryExpression.getOperand();
        UnaryOperator operator = unaryExpression.getOperator();
//        logs.add("Line " + unaryExpression.getLine() + ": Expr " + operator.getSymbol());
        return 0;
    }

    @Override
    public Integer visit(Initializer initializer) {
        Expression expression = initializer.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visit(InitializerEntry initializerEntry) {
        return 0;
    }

    @Override
    public Integer visit(FieldDesignator fieldDesignator) {
        return 0;
    }

    @Override
    public Integer visit(ArrayDesignator arrayDesignator) {
        return 0;
    }

    @Override
    public Integer visit(Designator designator) {
        return 0;
    }

    @Override
    public Integer visit(Specifier specifier) {
        return 0;
    }

    @Override
    public Integer visit(ConstSpecifier constSpecifier) {
        return 0;
    }

    @Override
    public Integer visit(TypedefSpecifier typedefSpecifier) {
        return 0;
    }

    @Override
    public Integer visit(BreakStatement breakStatement) {
        return 1;
    }

    @Override
    public Integer visit(ContinueStatement continueStatement) {
        return 1;
    }

    @Override
    public Integer visit(DoWhileStatement doWhileStatement) {
        Statement body = doWhileStatement.getBody();
        if (body != null){
            body.accept(this);
        }
        return 1;
    }

    @Override
    public Integer visit(ExpressionStatement expressionStatement) {
        Expression expression = expressionStatement.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return 1;
    }

    @Override
    public Integer visit(ForCondStatement forCondStatement) {
        return 0;
    }

    @Override
    public Integer visit(ForStatement forStatement) {
        Statement body = forStatement.getBody();
        if (body != null){
            int count = body.accept(this);
            logs.add("Line " + forStatement.getLine() + ": Stmt for = " + (count));
        }
        return 1;
    }

    @Override
    public Integer visit(IfStatement ifStatement) {
        Expression condition = ifStatement.getCondition();
        Statement thenStatement = ifStatement.getThenStatement();
        Statement elseStatement = ifStatement.getElseStatement();

        if(elseStatement != null){
            int count = elseStatement.accept(this);
            if (!(elseStatement instanceof IfStatement))
                logs.add("Line " + elseStatement.getLine() + ": Stmt selection = " + count);
        }

        if(thenStatement != null){
            int count = thenStatement.accept(this);
            logs.add("Line " + thenStatement.getLine() + ": Stmt selection = " + count);
        }

        if(condition != null){
            condition.accept(this);
        }

        return 1;
    }


    @Override
    public Integer visit(ReturnStatement returnStatement) {
        Expression expression = returnStatement.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return 1;
    }

    @Override
    public Integer visit(WhileStatement whileStatement) {
        Statement body = whileStatement.getBody();
        Expression condition = whileStatement.getCondition();

        if(body != null){
            int count = body.accept(this);
            logs.add("Line " + whileStatement.getLine() + ": Stmt while = " + count);
        }

        if (condition != null){
            condition.accept(this);
        }
        return 1;
    }

    @Override
    public Integer visit(Type type) {
        return 0;
    }

    @Override
    public Integer visit(BoolType boolType) {
        return 0;
    }

    @Override
    public Integer visit(CharType charType) {
        return 0;
    }

    @Override
    public Integer visit(DoubleType doubleType) {
        return 0;
    }

    @Override
    public Integer visit(FloatType floatType) {
        return 0;
    }

    @Override
    public Integer visit(IdType idType) {
        return 0;
    }

    @Override
    public Integer visit(IntType intType) {
        return 0;
    }

    @Override
    public Integer visit(LongType longType) {
        return 0;
    }

    @Override
    public Integer visit(ShortType shortType) {
        return 0;
    }

    @Override
    public Integer visit(SignedType signedType) {
        return 0;
    }

    @Override
    public Integer visit(UnsignedType unsignedType) {
        return 0;
    }

    @Override
    public Integer visit(VoidType voidType) {
        return 0;
    }

}

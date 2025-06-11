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

public class NoSideEffects extends Visitor<Void> {
    private boolean isPure = true;

    private boolean isPureBin(BinaryOperator op) {
        return switch (op) {
            case ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN, MUL_ASSIGN, DIV_ASSIGN,
                 MOD_ASSIGN, LEFT_SHIFT_ASSIGN, RIGHT_SHIFT_ASSIGN,
                 AND_ASSIGN, XOR_ASSIGN, OR_ASSIGN -> false;

            default -> true;
        };
    }

    private boolean isPureUnary(UnaryOperator op) {
        return switch (op) {
            case INCREMENT , DECREMENT -> false;

            default -> true;
        };
    }



    @Override
    public Void visit(Program program) {

        for (Declaration declaration : program.getDeclarations()) {
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FuncDec funcDec) {
        Declarator declarator = funcDec.getDeclarator();

        if ((declarator != null ) ){
            declarator.accept(this);
        }

        if (funcDec.getStatement() != null)
            funcDec.getStatement().accept(this);

        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
        List<BlockItem> new_items = new ArrayList<>();
        List<Statement> new_statements = new ArrayList<>();
        for (BlockItem item : compoundStatement.getSelfItems()) {
            isPure = true;
            item.accept(this);
            if(item instanceof Declaration)
                new_items.add(item);
            else{
                if(!isPure){
                    new_statements.add((Statement) item);
                    new_items.add(item);
                }
            }
        }

        compoundStatement.setStatements(new_statements);
        compoundStatement.setItems(new_items);
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

        for (ParamDec param : functionDeclarator.getParameters()) {
            param.accept(this);
        }

        if (functionDeclarator.getDeclarator() != null) {
            functionDeclarator.getDeclarator().accept(this);
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
        BinaryOperator operator = binaryExpression.getOperator();
        if(!isPureBin(operator)) {
            isPure = false;
        }

        if (binaryExpression.getLeftOperand() != null)
            binaryExpression.getLeftOperand().accept(this);
        if (binaryExpression.getRightOperand() != null)
            binaryExpression.getRightOperand().accept(this);
        return null;
    }


    @Override
    public Void visit(CastExpression castExpression) {
        isPure = false; // Cast expressions are not pure by definition
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
        isPure = false;
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
        UnaryOperator operator = unaryExpression.getOperator();
        if(!isPureUnary(operator)) {
            isPure = false;
        }
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
        isPure = false; // Return statements are not pure by definition
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

}

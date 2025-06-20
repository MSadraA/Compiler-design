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

import java.util.*;

import static main.symbolTable.utils.DeclaratorUtils.extractName;

public class MarkMainAccess extends Visitor<Void> {
    private List<FuncDec> visitedFunctions = new ArrayList<>();
    SymbolTable currScope = null;
    boolean isInMain = false;

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
        String name = extractName(declarator);
        if(Objects.equals(name, "main")){
            isInMain = true;
            funcDec.setReachable();
            currScope = funcDec.getSymbolTable();
            if (funcDec.getStatement() != null)
                funcDec.getStatement().accept(this);
            isInMain = false;
            return null;
        }
        if(isInMain && !visitedFunctions.contains(funcDec)) {
            visitedFunctions.add(funcDec);
            funcDec.setReachable();
            currScope = funcDec.getSymbolTable();
            if (funcDec.getStatement() != null)
                funcDec.getStatement().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
        currScope = compoundStatement.getSymbolTable();
        for(BlockItem item : compoundStatement.getItems()){
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
        int argCount = countFunctionArguments(functionCallExpression);
        String name = (functionExpr instanceof IdExpression idExpr)? idExpr.getValue() : null;
        if(name == null)
            return null;

        try {
            FunctionItem functionItem = currScope.findFunctionByName(name , argCount);
            FuncDec funcDec = functionItem.getDeclaration();
            if(funcDec != null)
                funcDec.accept(this);

        } catch (ItemNotFoundException e) {
            return null;
        }
        for (Expression arg : functionCallExpression.getSelfArguments()) {
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


}



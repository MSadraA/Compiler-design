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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CpyVisitor extends Visitor<Void> {
    private Deque<Node> nodeStack = new ArrayDeque<>();
    private Deque<Node> callStack = new ArrayDeque<>();
    private Program rootProgram = null;


    private int currentIndentLevel = 0;
    private boolean not_in_chain = true;

    @Override
    public Void visit(Program program) {
        rootProgram = program;
        callStack.push(program);
        for (Declaration declaration : program.getDeclarations()) {
            currentIndentLevel = 0;
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FuncDec funcDec) {
        callStack.push(funcDec);
        CompoundStatement body = funcDec.getStatement();
        body.accept(this);
        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
        List<BlockItem> items = compoundStatement.getItems();

        boolean isRedundantCompound =
                !callStack.isEmpty() &&
                        callStack.peek() instanceof CompoundStatement &&
                        ((CompoundStatement) callStack.peek()).getIndentLevel() == compoundStatement.getIndentLevel();

        compoundStatement.setIndentLevel(currentIndentLevel);

        if (isRedundantCompound) {
            for (BlockItem item : items) {
                not_in_chain = true;
                item.accept(this);
            }
            return null;
        }

        currentIndentLevel += 1;
        compoundStatement.setIndentLevel(currentIndentLevel);
        nodeStack.push(compoundStatement);
        callStack.push(compoundStatement);

        for (BlockItem item : items) {
            item.accept(this);
        }

        callStack.pop();
        return null;
    }


    @Override
    public Void visit(DoWhileStatement doWhileStatement) {
        callStack.push(doWhileStatement);
        int indent = doWhileStatement.getIndentLevel();
        attachToParentByIndentLevel(doWhileStatement , indent);

        if (doWhileStatement.getBody() != null)
            doWhileStatement.getBody().accept(this);

        return null;
    }

    @Override
    public Void visit(WhileStatement whileStatement) {
        callStack.push(whileStatement);
        int indent = whileStatement.getIndentLevel();
        attachToParentByIndentLevel(whileStatement , indent);

        if (whileStatement.getBody() != null)
            whileStatement.getBody().accept(this);
        callStack.pop();
        return null;
    }

    @Override
    public Void visit(ForStatement forStatement) {
        callStack.push(forStatement);
        int indent = forStatement.getIndentLevel();
        attachToParentByIndentLevel(forStatement , indent);

        if (forStatement.getBody() != null)
            forStatement.getBody().accept(this);
        callStack.pop();
        return null;
    }

    @Override
    public Void visit(IfStatement ifStatement) {
        Statement thenStatement = ifStatement.getThenStatement();
        Statement elseStatement = ifStatement.getElseStatement();
        callStack.push(ifStatement);
        int indent = ifStatement.getIndentLevel();
        checkIndentLevel(indent);
        if(not_in_chain) {
            attachToParentByIndentLevel(ifStatement, indent);
        }

        if (thenStatement != null) {
            not_in_chain = true;
            thenStatement.accept(this);
        }
        if(elseStatement == null){
            not_in_chain = true;
            nodeStack.pop();
            currentIndentLevel = indent;
        }
        else {
            not_in_chain = false;
            currentIndentLevel = indent;
            elseStatement.accept(this);
        }
        callStack.pop();
        return null;
    }


    @Override
    public Void visit(VarDec varDec){
        callStack.push(varDec);
        int indent = varDec.getIndentLevel();
        Statement top = (Statement) nodeStack.peek();
        attachToParentByIndentLevel(varDec , indent);
        if ((indent < currentIndentLevel)){
            nodeStack.pop();
            currentIndentLevel --;
        }
        callStack.pop();
        return null;
    }

    @Override
    public Void visit(ParamDec paramDec) { return null; }

    @Override
    public Void visit(Declarator declarator) { return null; }

    @Override
    public Void visit(ArrayDeclarator arrayDeclarator) { return null; }

    @Override
    public Void visit(FunctionDeclarator functionDeclarator) { return null; }

    @Override
    public Void visit(IdentifierDeclarator identifierDeclarator) { return null; }

    @Override
    public Void visit(InitDeclarator initDeclarator) { return null; }

    @Override
    public Void visit(PointerDeclarator pointerDeclarator) { return null; }

    @Override
    public Void visit(StarPointer starPointer) { return null; }

    @Override
    public Void visit(Expression expression) { return null; }

    @Override
    public Void visit(ArrayExpression arrayExpression) { return null; }

    @Override
    public Void visit(BinaryExpression binaryExpression) { return null; }

    @Override
    public Void visit(CastExpression castExpression) { return null; }

    @Override
    public Void visit(CommaExpression commaExpression) { return null; }

    @Override
    public Void visit(CompoundLiteralExpression compoundLiteralExpression) { return null; }

    @Override
    public Void visit(ConditionalExpression conditionalExpression) { return null; }

    @Override
    public Void visit(ConstExpression constExpression) { return null; }

    @Override
    public Void visit(DigitSequenceExpression digitSequenceExpression) { return null; }

    @Override
    public Void visit(FunctionCallExpression functionCallExpression) { return null; }

    @Override
    public Void visit(IdExpression idExpression) { return null; }

    @Override
    public Void visit(SizeofExpression sizeofExpression) { return null; }

    @Override
    public Void visit(StringExpression stringExpression) { return null; }

    @Override
    public Void visit(UnaryExpression unaryExpression) { return null; }

    @Override
    public Void visit(Initializer initializer) { return null; }

    @Override
    public Void visit(InitializerEntry initializerEntry) { return null; }

    @Override
    public Void visit(FieldDesignator fieldDesignator) { return null; }

    @Override
    public Void visit(ArrayDesignator arrayDesignator) { return null; }

    @Override
    public Void visit(Designator designator) { return null; }

    @Override
    public Void visit(Specifier specifier) { return null; }

    @Override
    public Void visit(ConstSpecifier constSpecifier) { return null; }

    @Override
    public Void visit(TypedefSpecifier typedefSpecifier) { return null; }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        callStack.push(expressionStatement);
        attachToParentByIndentLevel(expressionStatement , expressionStatement.getIndentLevel());
        callStack.pop();
        return null;
    }

    @Override
    public Void visit(BreakStatement breakStatement) {
        callStack.push(breakStatement);
        int indent = breakStatement.getIndentLevel();
        attachToParentByIndentLevel(breakStatement , indent);
        callStack.pop();
        return null;
    }

    @Override
    public Void visit(ContinueStatement continueStatement) {
        callStack.push(continueStatement);
        int indent = continueStatement.getIndentLevel();
        attachToParentByIndentLevel(continueStatement , indent);
        callStack.pop();
        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement) {
        callStack.push(returnStatement);
        int indent = returnStatement.getIndentLevel();
        attachToParentByIndentLevel(returnStatement , indent);
        callStack.pop();
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

    private void attachToParentByIndentLevel(BlockItem item, int indentLevel) {
        Deque<Node> tempStack = new ArrayDeque<>(nodeStack);
        int tempIndent;

        while (!tempStack.isEmpty()) {
            CompoundStatement parent = (CompoundStatement) tempStack.pop();
            tempIndent = parent.getIndentLevel();
            if (tempIndent == indentLevel) {
                if (item instanceof Statement)
                    parent.addSelfStatement((Statement) item);
                else
                    parent.addSelfVarDec((VarDec) item);
                return;
            }
        }

        if (indentLevel == 0 && rootProgram != null) {
            return;
        }

        throw new RuntimeException("RUN TIME ERROR - parent not found");
    }

    private void checkIndentLevel(int indentLevel) {
        if ((indentLevel < currentIndentLevel)){
            nodeStack.pop();
            currentIndentLevel --;
            return;
        }
        return;
    }

    private void printStack() {

        for (Node node : nodeStack) {
            System.out.println("  " + node.getClass().getSimpleName());
        }
    }
}
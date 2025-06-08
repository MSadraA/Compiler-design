package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declarator.pointer.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.declarator.*;
import main.ast.nodes.specifier.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.type.*;
import main.ast.nodes.expression.initializer.*;

public abstract class Visitor<T> implements IVisitor<T> {

    public T visit(Program program) {
        return null;
    }
    public T visit(Declaration declaration) {
        return null;
    }
    public T visit(FuncDec funcDec) {
        return null;
    }
    public T visit(ParamDec paramDec) {
        return null;
    }
    public T visit(VarDec varDec) {
        return null;
    }
    public T visit(Declarator declarator) {
        return null;
    }
    public T visit(ArrayDeclarator arrayDeclarator) {
        return null;
    }
    public T visit(FunctionDeclarator functionDeclarator) {
        return null;
    }
    public T visit(IdentifierDeclarator identifierDeclarator) {
        return null;
    }
    public T visit(InitDeclarator initDeclarator) {
        return null;
    }
    public T visit(PointerDeclarator pointerDeclarator) {
        return null;
    }
    public T visit(StarPointer starPointer) {
        return null;
    }
    public T visit(Expression expression) {
        return null;
    }
    public T visit(ArrayExpression arrayExpression) {
        return null;
    }
    public T visit(BinaryExpression binaryExpression) {
        return null;
    }
    public T visit(CastExpression castExpression) {
        return null;
    }
    public T visit(CommaExpression commaExpression) {
        return null;
    }
    public T visit(CompoundLiteralExpression compoundLiteralExpression) {
        return null;
    }
    public T visit(ConditionalExpression conditionalExpression) {
        return null;
    }
    public T visit(ConstExpression constExpression) {
        return null;
    }
    public T visit(DigitSequenceExpression digitSequenceExpression) {
        return null;
    }
    public T visit(FunctionCallExpression functionCallExpression) {
        return null;
    }
    public T visit(IdExpression idExpression) {
        return null;
    }
    public T visit(SizeofExpression sizeofExpression) {
        return null;
    }
    public T visit(StringExpression stringExpression) {
        return null;
    }
    public T visit(UnaryExpression unaryExpression) {
        return null;
    }
    public T visit(Initializer initializer) {
        return null;
    }
    public T visit(InitializerEntry initializerEntry) {
        return null;
    }
    public T visit(FieldDesignator fieldDesignator) {
        return null;
    }
    public T visit(ArrayDesignator arrayDesignator) {
        return null;
    }
    public T visit(Designator designator) {
        return null;
    }
    public T visit(Specifier specifier) {
        return null;
    }
    public T visit(ConstSpecifier constSpecifier) {
        return null;
    }
    public T visit(TypedefSpecifier typedefSpecifier) {
        return null;
    }
    public T visit(Statement statement) {
        return null;
    }
    public T visit(BreakStatement breakStatement) {
        return null;
    }
    public T visit(CompoundStatement compoundStatement) {
        return null;
    }
    public T visit(ContinueStatement continueStatement) {
        return null;
    }
    public T visit(DoWhileStatement doWhileStatement) {
        return null;
    }
    public T visit(ExpressionStatement expressionStatement) {
        return null;
    }
    public T visit(ForCondStatement forCondStatement) {
        return null;
    }
    public T visit(ForStatement forStatement) {
        return null;
    }
    public T visit(IfStatement ifStatement) {
        return null;
    }
    public T visit(ReturnStatement returnStatement) {
        return null;
    }
    public T visit(WhileStatement whileStatement) {
        return null;
    }
    public T visit(Type type) {
        return null;
    }
    public T visit(BoolType boolType) {
        return null;
    }
    public T visit(CharType charType) {
        return null;
    }
    public T visit(DoubleType doubleType) {
        return null;
    }
    public T visit(FloatType floatType) {
        return null;
    }
    public T visit(IdType idType) {
        return null;
    }
    public T visit(IntType intType) {
        return null;
    }
    public T visit(LongType longType) {
        return null;
    }
    public T visit(ShortType shortType) {
        return null;
    }
    public T visit(SignedType signedType) {
        return null;
    }
    public T visit(UnsignedType unsignedType) {
        return null;
    }
    public T visit(VoidType voidType) {
        return null;
    }
}

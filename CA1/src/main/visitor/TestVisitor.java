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


import java.util.List;

public class TestVisitor extends Visitor<Integer> {
    @Override
    public Integer visit(FuncDec funcDec){
        int count = 0;
        CompoundStatement statement = funcDec.getStatement();
        if(statement != null){
            count = statement.accept(this);
            System.out.println(count);
        }
        return 0;
    }

    @Override
    public Integer visit(CompoundStatement compoundStatement){
        int counter = 0;
        for(Statement statement : compoundStatement.getStatements()){
            counter++;
        }
        for(Declaration declaration : compoundStatement.getDeclarations()) {
            counter++;
        }
        return counter;
    }

    @Override
    public Integer visit(Program program) {
        List<Declaration> declarations = program.getDeclarations();
        for (Declaration declaration : declarations) {
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
        return 0;
    }

    @Override
    public Integer visit(Declarator declarator) {
        return 0;
    }

    @Override
    public Integer visit(ArrayDeclarator arrayDeclarator) {
        return 0;
    }

    @Override
    public Integer visit(FunctionDeclarator functionDeclarator) {
        return 0;
    }

    @Override
    public Integer visit(IdentifierDeclarator identifierDeclarator) {
        return 0;
    }

    @Override
    public Integer visit(InitDeclarator initDeclarator) {
        return 0;
    }

    @Override
    public Integer visit(PointerDeclarator pointerDeclarator) {
        return 0;
    }

    @Override
    public Integer visit(StarPointer starPointer) {
        return 0;
    }

    @Override
    public Integer visit(Expression expression) {
        return 0;
    }

    @Override
    public Integer visit(ArrayExpression arrayExpression) {
        return 0;
    }

    @Override
    public Integer visit(BinaryExpression binaryExpression) {
        return 0;
    }

    @Override
    public Integer visit(CastExpression castExpression) {
        return 0;
    }

    @Override
    public Integer visit(CommaExpression commaExpression) {
        return 0;
    }

    @Override
    public Integer visit(CompoundLiteralExpression compoundLiteralExpression) {
        return 0;
    }

    @Override
    public Integer visit(ConditionalExpression conditionalExpression) {
        return 0;
    }

    @Override
    public Integer visit(ConstExpression constExpression) {
        return 0;
    }

    @Override
    public Integer visit(DigitSequenceExpression digitSequenceExpression) {
        return 0;
    }

    @Override
    public Integer visit(FunctionCallExpression functionCallExpression) {
        return 0;
    }

    @Override
    public Integer visit(IdExpression idExpression) {
        return 0;
    }

    @Override
    public Integer visit(SizeofExpression sizeofExpression) {
        return 0;
    }

    @Override
    public Integer visit(StringExpression stringExpression) {
        return 0;
    }

    @Override
    public Integer visit(UnaryExpression unaryExpression) {
        return 0;
    }

    @Override
    public Integer visit(Initializer initializer) {
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
    public Integer visit(Statement statement) {
        return 0;
    }

    @Override
    public Integer visit(BreakStatement breakStatement) {
        return 0;
    }

    @Override
    public Integer visit(ContinueStatement continueStatement) {
        return 0;
    }

    @Override
    public Integer visit(DoWhileStatement doWhileStatement) {
        return 0;
    }

    @Override
    public Integer visit(ExpressionStatement expressionStatement) {
        return 0;
    }

    @Override
    public Integer visit(ForCondStatement forCondStatement) {
        return 0;
    }

    @Override
    public Integer visit(ForStatement forStatement) {
        return 0;
    }

    @Override
    public Integer visit(IfStatement ifStatement) {
        Expression condition = ifStatement.getCondition();
        Statement thenStatement = ifStatement.getThenStatement();
        Statement elseStatement = ifStatement.getElseStatement();
        if(condition != null){
            int count = condition.accept(this);
            System.out.println();
        }
        if(thenStatement != null){
            int count = thenStatement.accept(this);
            System.out.println();
        }
        return 0;
    }

    @Override
    public Integer visit(ReturnStatement returnStatement) {
        return 0;
    }

    @Override
    public Integer visit(WhileStatement whileStatement) {
        return 0;
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

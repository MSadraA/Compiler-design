package main.ast.nodes.expression;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.expression.initializer.Initializer;
import main.ast.nodes.expression.initializer.InitializerEntry;
import main.ast.nodes.expression.operator.BinaryOperator;
import main.ast.nodes.expression.operator.UnaryOperator;
import main.ast.nodes.statement.Statement;

import java.util.List;

public abstract class Expression extends Node {

    //StringExpression
    public void addStringLiteral(String stringliteral){};

    //ConstantExpression
    public void setValue(String value){};

    //BinaryExpression
    public void setBinaryOperator(BinaryOperator binaryOperator){};
    public void setLeftOperand(Expression leftOperand){};
    public void setRightOperand(Expression rightOperand){};

    //UnaryExpression
    public void setPostfix(boolean postfix){};
    public void setUnaryOperator(UnaryOperator unaryOperator){};
    public void setExpression(Expression operand){};

    //CompoundLiteralExpression
    public void setType(ParamDec type) {}
    public void setInitializers(List<InitializerEntry> initializers) {}

    //ArrayExpression
    public void setAssigned(Expression assigned) {};
    public void setIndex(Expression index) {};

    //FunctionCallExpression
    public void setFunction(Expression function) {};
    public void setArguments(List<Expression> arguments) {};
    public void addArgument(Expression argument) {};

    //CommaExpression
    public void setExpressions(List<Expression> expressions) {};
    public void addExpression(Expression expression) {};

    //CastExpression
    public void setTargetType(ParamDec targetType) {};

    }

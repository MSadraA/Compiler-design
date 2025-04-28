package main.ast.nodes.expression;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.expression.initializer.Initializer;
import main.ast.nodes.expression.initializer.InitializerEntry;
import main.ast.nodes.expression.operator.BinaryOperator;
import main.ast.nodes.expression.operator.UnaryOperator;

import java.util.List;

public abstract class Expression extends Node {

    //StringExpression
    public void addStringLiteral(String stringliteral){};

    //BinaryExpression
    public void setBinaryOperator(BinaryOperator binaryOperator){};
    public void setLeftOperand(Expression leftOperand){};
    public void setRightOperand(Expression rightOperand){};

    //UnaryExpression
    public void setUnaryOperator(UnaryOperator unaryOperator){};
    public void setExpression(Expression operand){};

    //CompoundLiteralExpression
    public void setType(ParamDec type) {}
    public void setInitializers(List<InitializerEntry> initializers) {}



    }

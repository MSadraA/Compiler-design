package main.ast.nodes.expression;

import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.type.Type;

public class CastExpression extends Expression {
    private ParamDec targetType;
    private Expression expression;

    public CastExpression(ParamDec type, Expression expression) {
        this.targetType = type;
        this.expression = expression;
    }

    @Override
    public void setTargetType(ParamDec targetType) {
        this.targetType = targetType;
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
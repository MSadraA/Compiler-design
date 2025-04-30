package main.ast.nodes.expression;

import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.type.Type;
import main.visitor.IVisitor;

public class CastExpression extends Expression {
    private ParamDec targetType;
    private Expression expression;

    public CastExpression(ParamDec type, Expression expression) {
        this.targetType = type;
        this.expression = expression;
    }

    public CastExpression(ParamDec type, Expression expression, int line) {
        this.targetType = type;
        this.expression = expression;
        this.setLine(line);
    }

    @Override
    public void setTargetType(ParamDec targetType) {
        this.targetType = targetType;
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
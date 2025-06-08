package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class ConstExpression extends Expression{
    private String value;

    public String getValue() {
        return value;
    }

    public ConstExpression(String value) {
        this.value = value;
    }

    public ConstExpression(String value, int line) {
        this.value = value;
        this.setLine(line);
    }

    public ConstExpression() {}

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

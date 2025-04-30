package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class DigitSequenceExpression extends Expression {
    private String value;

    public DigitSequenceExpression(String value) {
        this.value = value;
    }

    public DigitSequenceExpression(String value, int line) {
        this.value = value;
        this.setLine(line);
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

package main.ast.nodes.expression;

public class DigitSequenceExpression extends Expression {
    private String value;

    public DigitSequenceExpression(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

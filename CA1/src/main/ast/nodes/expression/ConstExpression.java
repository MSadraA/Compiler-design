package main.ast.nodes.expression;

public class ConstExpression extends Expression{
    private String value;

    public ConstExpression(String value) {
        this.value = value;
    }

    public ConstExpression() {}

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}

package main.ast.nodes.expression;

public class ConditionalExpression extends Expression{
    private Expression condition;
    private Expression trueExpression;
    private Expression falseExpression;

    public ConditionalExpression(Expression condition , Expression trueExpression
            , Expression falseExpression)
    {
        this.condition = condition;
        this.trueExpression = trueExpression;
        this.falseExpression = falseExpression;
    }

    public ConditionalExpression(Expression condition , Expression trueExpression
            , Expression falseExpression, int line)
    {
        this.condition = condition;
        this.trueExpression = trueExpression;
        this.falseExpression = falseExpression;
        this.setLine(line);
    }
}

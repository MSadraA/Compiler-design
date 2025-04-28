package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;

public class ExpressionStatement extends Statement{
    private Expression expression;

    public ExpressionStatement(Expression expression){
        this.expression = expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}

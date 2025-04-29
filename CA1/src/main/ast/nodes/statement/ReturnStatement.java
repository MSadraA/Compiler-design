package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;

public class ReturnStatement extends Statement{
    private Expression expression;

    public ReturnStatement(){}

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}

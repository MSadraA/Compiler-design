package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

public class ExpressionStatement extends Statement{
    private Expression expression;

    public ExpressionStatement(){

    }

    public ExpressionStatement(Expression expression){
        this.expression = expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

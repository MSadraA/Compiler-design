package main.ast.nodes.expression.initializer;

import main.ast.nodes.expression.Expression;

public class ArrayDesignator extends Designator {
    private Expression index;

    @Override
    public void setExpression(Expression index) {
        this.index = index;
    }
}

package main.ast.nodes.expression.initializer;

import main.ast.nodes.expression.Expression;

public class ArrayDesignator extends Designator {
    private Expression index;

    public ArrayDesignator(){}

    public ArrayDesignator(Expression expression , int line){
        this.index = expression;
        this.setLine(line);
    }

    @Override
    public void setExpression(Expression index) {
        this.index = index;
    }
}

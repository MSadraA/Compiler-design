package main.ast.nodes.expression.initializer;

import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

public class ArrayDesignator extends Designator {
    private Expression index;

    public Expression getIndex() {
        return index;
    }

    public ArrayDesignator(){}

    public ArrayDesignator(Expression expression , int line){
        this.index = expression;
        this.setLine(line);
    }

    @Override
    public void setExpression(Expression index) {
        this.index = index;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

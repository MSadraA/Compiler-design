package main.ast.nodes.expression;

public class ArrayExpression extends Expression {
    private Expression assigned;
    private Expression index;

    public ArrayExpression() {
    }

    @Override
    public void setAssigned(Expression assigned) {
        this.assigned = assigned;
    }
    @Override
    public void setIndex(Expression index) {
        this.index = index;
    }
}


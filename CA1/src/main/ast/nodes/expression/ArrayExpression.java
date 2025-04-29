package main.ast.nodes.expression;

public class ArrayExpression extends Expression {
    private Expression assigned;
    private Expression index;

    public ArrayExpression() {
    }

    public ArrayExpression(Expression assigned , Expression index , int line){
        this.assigned = assigned;
        this.index = index;
        this.setLine(line);
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


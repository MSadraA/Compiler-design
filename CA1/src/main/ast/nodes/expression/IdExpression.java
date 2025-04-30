package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class IdExpression extends Expression {
    private String name;

    public IdExpression(String name){
        this.name = name;
    }

    public IdExpression(String name , int line){
        this.name = name;
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

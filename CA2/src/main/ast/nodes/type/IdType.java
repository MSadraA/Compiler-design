package main.ast.nodes.type;

import main.visitor.IVisitor;

public class IdType extends Type {
    private String name;

    public IdType(String name){
        this.name = name;
    }

    public IdType(String name , int line){
        this.name = name;
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

package main.ast.nodes.type;

import main.visitor.IVisitor;

public class BoolType extends Type {
    public BoolType(){}

    public BoolType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

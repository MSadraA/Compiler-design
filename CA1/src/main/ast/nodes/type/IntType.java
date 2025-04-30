package main.ast.nodes.type;

import main.visitor.IVisitor;

public class IntType extends Type {
    public IntType(){}

    public IntType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

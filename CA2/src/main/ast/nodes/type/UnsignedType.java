package main.ast.nodes.type;

import main.visitor.IVisitor;

public class UnsignedType extends Type {
    public UnsignedType(){}

    public UnsignedType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

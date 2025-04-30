package main.ast.nodes.type;

import main.visitor.IVisitor;

public class SignedType extends Type {
    public SignedType(){}

    public SignedType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

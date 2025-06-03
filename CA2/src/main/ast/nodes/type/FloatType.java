package main.ast.nodes.type;

import main.visitor.IVisitor;

public class FloatType extends Type {
    public FloatType(){}

    public FloatType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

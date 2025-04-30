package main.ast.nodes.type;

import main.visitor.IVisitor;

public class DoubleType extends Type {
    public DoubleType(){}

    public DoubleType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

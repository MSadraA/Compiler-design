package main.ast.nodes.type;

import main.visitor.IVisitor;

public class LongType extends Type {
    public LongType(){}

    public LongType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

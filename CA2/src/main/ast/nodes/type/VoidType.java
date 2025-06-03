package main.ast.nodes.type;


import main.visitor.IVisitor;

public class VoidType extends Type {
    public VoidType(){}

    public VoidType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

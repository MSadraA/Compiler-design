package main.ast.nodes.type;


import main.visitor.IVisitor;

public class ShortType extends Type {
    public ShortType(){}

    public ShortType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

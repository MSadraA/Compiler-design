package main.ast.nodes.type;

import main.visitor.IVisitor;

public class CharType extends Type {
    public CharType(){}

    public CharType(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

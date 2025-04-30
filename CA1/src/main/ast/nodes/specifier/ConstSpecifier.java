package main.ast.nodes.specifier;

import main.ast.nodes.declarator.pointer.Pointer;
import main.visitor.IVisitor;

public class ConstSpecifier extends Specifier implements Pointer {
    public ConstSpecifier(){}

    public ConstSpecifier(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

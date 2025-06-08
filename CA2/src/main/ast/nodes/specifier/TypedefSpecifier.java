package main.ast.nodes.specifier;

import main.ast.nodes.declarator.pointer.Pointer;
import main.visitor.IVisitor;

public class TypedefSpecifier extends Specifier implements Pointer {
    public TypedefSpecifier(){}

    public TypedefSpecifier(int line){
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

package main.ast.nodes.declarator;

import main.ast.nodes.declarator.pointer.Pointer;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class PointerDeclarator extends Declarator{
    private List<Pointer> pointers = new ArrayList<>();
    private Declarator declarator;

    public PointerDeclarator(){}

    @Override
    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    @Override
    public void setPointers(List<Pointer> pointers) {this.pointers = pointers;}

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

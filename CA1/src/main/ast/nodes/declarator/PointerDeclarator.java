package main.ast.nodes.declarator;

import main.ast.nodes.declarator.pointer.Pointer;
import java.util.ArrayList;
import java.util.List;

public class PointerDeclarator extends Declarator{
    private List<Pointer> pointers = new ArrayList<>();
    private Declarator declarator;

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setPointers(List<Pointer> pointers) {
        this.pointers = pointers;
    }

    public PointerDeclarator(){

    }
}

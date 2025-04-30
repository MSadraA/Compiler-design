package main.ast.nodes.declarator.pointer;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

public class StarPointer extends Node implements Pointer {
    public StarPointer() {
    }

    public StarPointer(int line) {
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

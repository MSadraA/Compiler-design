package main.ast.nodes.declarator.pointer;

import main.ast.nodes.Node;

public class StarPointer extends Node implements Pointer {
    public StarPointer() {
    }

    public StarPointer(int line) {
        this.setLine(line);
    }
}

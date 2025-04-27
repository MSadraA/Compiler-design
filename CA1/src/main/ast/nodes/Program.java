package main.ast.nodes;

import main.ast.nodes.declaration.Declaration;
import java.util.ArrayList;
import java.util.List;

public class Program extends Node {
    private List<Declaration> declarations = new ArrayList<>();
    public Program() {
    }

    public void addDeclaration(Declaration declaration) {
        this.declarations.add(declaration);
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }
}
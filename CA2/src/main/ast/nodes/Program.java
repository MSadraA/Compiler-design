package main.ast.nodes;

import main.ast.nodes.declaration.Declaration;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends Node {
    private List<Declaration> declarations = new ArrayList<>();
    private SymbolTable symbol_table;

    public Program() {
    }

    public void setSymbolTable(SymbolTable symbol_table) {
        this.symbol_table = symbol_table;
    }

    public SymbolTable getSymbolTable() {
        return this.symbol_table;
    }

    public void setDeclarations(List<Declaration> declarations) {
        this.declarations = declarations;
    }

    public void addDeclaration(Declaration declaration) {
        this.declarations.add(declaration);
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }


    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
package main.ast.nodes.statement;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.VarDec;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatement extends Statement {
    private List<Statement> statements = new ArrayList<>();
    private List<Declaration> declarations = new ArrayList<>();
    private List<BlockItem> items = new ArrayList<>();

    private List<Statement> self_statements = new ArrayList<>();
    private List<Declaration> self_decleration = new ArrayList<>();
    private List<BlockItem> self_items = new ArrayList<>();

    private SymbolTable symbol_table;
    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}

    public CompoundStatement() {
    }

    public List<BlockItem> getItems() {
        return this.items;
    }

    public List<Statement> getStatements() {
        return this.statements;
    }

    public List<Declaration> getDeclarations() {
        return this.declarations;
    }

    public List<BlockItem> getSelfItems() {
        return this.self_items;
    }

    public List<Statement> getSelfStatements() {
        return this.self_statements;
    }

    public List<Declaration> getSelfDeclarations() {
        return this.self_decleration;
    }

    public void addStatement(Statement statement) {
        this.statements.add(statement);
        this.items.add(statement);
    }

    public void addVarDec(VarDec declaration) {
        this.declarations.add(declaration);
        this.items.add(declaration);
    }

    public void addSelfStatement(Statement statement) {
        this.self_statements.add(statement);
        this.self_items.add(statement);
    }

    public void addSelfVarDec(VarDec declaration) {
        this.self_decleration.add(declaration);
        this.self_items.add(declaration);
    }

    public void removeBlockItem(BlockItem item) {
        this.items.remove(item);
        if (item instanceof VarDec) {
            this.declarations.remove(item);
            this.self_decleration.remove(item);
        } else if (item instanceof Statement) {
            this.statements.remove(item);
            this.self_statements.remove(item);
        }
        this.self_items.remove(item);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

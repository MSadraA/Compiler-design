package main.ast.nodes.statement;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.VarDec;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatement extends Statement{
    private List<Statement> statements = new ArrayList<>();
    private List<Declaration> declarations = new ArrayList<>();
    private List<BlockItem> items = new ArrayList<>();

    public CompoundStatement() {
    }

    public List<BlockItem> getItems() { return this.items; }

    public List<Statement> getStatements() {
        return this.statements;
    }

    public List<Declaration> getDeclarations() {
        return this.declarations;
    }

    public void addStatement(Statement statement)
    {
        this.statements.add(statement);
        this.items.add(statement);
    }

    public void addVarDec(VarDec declaration){
        this.declarations.add(declaration);
        this.items.add(declaration);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

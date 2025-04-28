package main.ast.nodes.statement;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.VarDec;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatement extends Statement{
    private List<Statement> statements = new ArrayList<>();
    private List<Declaration> declarations = new ArrayList<>();

    public CompoundStatement() {
    }

    public void addStatement(Statement statement){
        this.statements.add(statement);
    }

    public void addVarDec(VarDec declaration){
        this.declarations.add(declaration);
    }
}

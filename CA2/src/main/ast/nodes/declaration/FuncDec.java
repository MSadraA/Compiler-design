package main.ast.nodes.declaration;

import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.declarator.Declarator;
import main.ast.nodes.statement.CompoundStatement;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;


import java.util.ArrayList;
import java.util.List;


public class FuncDec extends Declaration {
    private List<Specifier> specifiers = new ArrayList<>();
    private Declarator declarator;
    private List<VarDec> varDecs = new ArrayList<>();
    private CompoundStatement statement;

    private SymbolTable symbol_table;

    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}


    public List<Specifier> getSpecifiers() {
        return specifiers;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public List<VarDec> getVarDecs() {
        return varDecs;
    }

    public CompoundStatement getStatement() {
        return statement;
    }


    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setVarDec(List<VarDec> varDecs) {
        this.varDecs = varDecs;
    }

    public void setSpecifiers(List<Specifier>specifiers){
        this.specifiers = specifiers;
    }

    public void setStatement(CompoundStatement statement) {
        this.statement = statement;
    }

    public FuncDec(){
    }


    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

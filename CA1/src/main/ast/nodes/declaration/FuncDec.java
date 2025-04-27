package main.ast.nodes.declaration;

import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.declarator.Declarator;
import main.ast.nodes.statement.Statement;

import java.util.ArrayList;
import java.util.List;


public class FuncDec extends Declaration {
    private List<Specifier> specifiers = new ArrayList<>();
    private Declarator declarator;
    private List<VarDec> varDecs = new ArrayList<>();
    private Statement statement;

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setVarDec(List<VarDec> varDecs) {
        this.varDecs = varDecs;
    }

    public void setSpecifiers(List<Specifier>specifiers){
        this.specifiers = specifiers;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public FuncDec(){

    }
}

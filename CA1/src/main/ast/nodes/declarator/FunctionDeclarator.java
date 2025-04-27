package main.ast.nodes.declarator;

import main.ast.nodes.declaration.ParamDec;
import java.util.ArrayList;
import java.util.List;

public class FunctionDeclarator extends Declarator{
    private Declarator declarator;
    private List<ParamDec> parameters = new ArrayList<>();
    private List<String> identifiers = new ArrayList<>(); //cahnge to List<Identifier> if needed

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setParameters(List<ParamDec> parameters) {
        this.parameters = parameters;
    }

    public void setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
    }

    public FunctionDeclarator() {
    }
}

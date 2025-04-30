package main.ast.nodes.declarator;

import main.ast.nodes.declaration.ParamDec;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionDeclarator extends Declarator{
    private Declarator declarator;
    private List<ParamDec> parameters = new ArrayList<>();
    private List<String> identifiers = new ArrayList<>(); //cahnge to List<Identifier> if needed

    public FunctionDeclarator() {
    }

    @Override
    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    @Override
    public void setParameters(List<ParamDec> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

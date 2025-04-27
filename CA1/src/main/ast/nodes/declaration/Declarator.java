package main.ast.nodes.declaration;

import main.ast.nodes.declaration.pointer.Pointer;
import main.ast.nodes.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class Declarator extends Declaration {

    private Declarator declarator;
    private Expression expression;
    private List<ParamDec> parameters = new ArrayList<>();
    private List<String> identifiers = new ArrayList<>(); //cahnge to List<Identifier> if needed
    private String identifier; //change to Identifier if needed
    private List<Pointer> pointers = new ArrayList<>();

    public void setIdentifier(String identifier) {this.identifier = identifier;}

    public void setDeclarator(Declarator declarator) {this.declarator = declarator;}

    public void setExpression(Expression expression) {this.expression = expression;}

    public void setParameters(List<ParamDec> parameters) {
        this.parameters = parameters;
    }

    public void setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
    }

    public void setPointers(List<Pointer> pointers) {this.pointers = pointers;}

    public Declarator() {
    }
}

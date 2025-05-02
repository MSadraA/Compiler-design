package main.ast.nodes.declarator;

import main.visitor.IVisitor;

public class IdentifierDeclarator extends Declarator{
    private String identifier = ""; //change to Identifier if needed

    public IdentifierDeclarator(){
    }

    public IdentifierDeclarator(String identifier) {
        this.identifier = identifier;
    }

    public IdentifierDeclarator(String identifier, int line) {
        this.identifier = identifier;
        this.setLine(line);
    }

    public String getName(){
        return this.identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

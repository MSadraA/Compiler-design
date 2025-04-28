package main.ast.nodes.declarator;

public class IdentifierDeclarator extends Declarator{
    private String identifier; //change to Identifier if needed

    public IdentifierDeclarator(){
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}

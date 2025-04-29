package main.ast.nodes.declarator;

public class IdentifierDeclarator extends Declarator{
    private String identifier; //change to Identifier if needed

    public IdentifierDeclarator(){
    }

    public IdentifierDeclarator(String identifier) {
        this.identifier = identifier;
    }

    public IdentifierDeclarator(String identifier, int line) {
        this.identifier = identifier;
        this.setLine(line);
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}

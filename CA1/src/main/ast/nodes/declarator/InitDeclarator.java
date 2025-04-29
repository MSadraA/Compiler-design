package main.ast.nodes.declarator;

import main.ast.nodes.expression.initializer.Initializer;

public class InitDeclarator extends Declarator{
    private Declarator declarator;
    private Initializer initializer;

    public InitDeclarator(Declarator declarator, Initializer initializer) {
        this.declarator = declarator;
        this.initializer = initializer;
    }

    public InitDeclarator() {
    }

    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

}

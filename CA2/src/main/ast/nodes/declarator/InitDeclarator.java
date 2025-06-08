package main.ast.nodes.declarator;

import main.ast.nodes.expression.initializer.Initializer;
import main.visitor.IVisitor;

public class InitDeclarator extends Declarator{
    private Declarator declarator;
    private Initializer initializer;

    public Initializer getInitializer(){
        return initializer;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

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

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

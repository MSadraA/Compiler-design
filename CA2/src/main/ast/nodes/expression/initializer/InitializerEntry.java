package main.ast.nodes.expression.initializer;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class InitializerEntry extends Node {
    private List<Designator> designators = new ArrayList<>();
    private Initializer initializer;

    public List<Designator> getDisignators() {
        return designators;
    }

    public Initializer getInitializer() {
        return initializer;
    }


    public void setDesignators(List<Designator> designators) {
        this.designators = designators;
    }

    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

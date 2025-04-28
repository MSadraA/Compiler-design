package main.ast.nodes.expression.initializer;

import main.ast.nodes.Node;
import java.util.List;

public class InitializerEntry extends Node {
    private List<Designator> designators;
    private Initializer initializer;

    public List<Designator> getDesignators() {
        return designators;
    }

    public void setDesignators(List<Designator> designators) {
        this.designators = designators;
    }

    public Initializer getInitializer() {
        return initializer;
    }

    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
    }
}

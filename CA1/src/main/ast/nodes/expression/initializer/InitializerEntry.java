package main.ast.nodes.expression.initializer;

import main.ast.nodes.Node;

import java.util.ArrayList;
import java.util.List;

public class InitializerEntry extends Node {
    private List<Designator> designators = new ArrayList<>();
    private Initializer initializer;

    public void setDesignators(List<Designator> designators) {
        this.designators = designators;
    }

    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
    }
}

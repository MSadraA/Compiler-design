package main.ast.nodes.expression.initializer;

import main.ast.nodes.Node;
import main.ast.nodes.expression.Expression;

public abstract class Designator extends Node {
    //Array designator
    public void setExpression(Expression index){};

    //Field designator
    public void setIdentifier(String fieldName){};
}

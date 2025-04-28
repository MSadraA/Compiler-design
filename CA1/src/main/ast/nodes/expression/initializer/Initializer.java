package main.ast.nodes.expression.initializer;

import main.ast.nodes.Node;
import main.ast.nodes.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class Initializer extends Node {
    private Expression expression;
    private List<InitializerEntry> initializerList = new ArrayList<>();

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public List<InitializerEntry> getInitializerList() {
        return initializerList;
    }

    public void setInitializerList(List<InitializerEntry> initializerList) {
        this.initializerList = initializerList;
    }
}

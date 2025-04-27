package main.ast.nodes.declarator;

import main.ast.nodes.expression.Expression;

public class ArrayDeclarator extends Declarator{
    private Declarator declarator;
    private Expression expression;

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ArrayDeclarator() {
    }
}

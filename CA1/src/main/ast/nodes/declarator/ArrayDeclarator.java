package main.ast.nodes.declarator;

import main.ast.nodes.expression.Expression;

public class ArrayDeclarator extends Declarator{
    private Declarator declarator;
    private Expression expression;

    public ArrayDeclarator() {
    }

    public ArrayDeclarator(Declarator declarator, Expression expression) {
        this.declarator = declarator;
        this.expression = expression;
    }

    public ArrayDeclarator(Declarator declarator, Expression expression, int line) {
        this.declarator = declarator;
        this.expression = expression;
        this.setLine(line);
    }

    @Override
    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}

package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;


public class CommaExpression extends Expression {
    private List<Expression> expressions = new ArrayList<>();

    public CommaExpression() {
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public CommaExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }
    @Override
    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
    @Override
    public void addExpression(Expression expression) {
        this.expressions.add(expression);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

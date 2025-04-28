package main.ast.nodes.expression;

import java.util.ArrayList;
import java.util.List;


public class CommaExpression extends Expression {
    private List<Expression> expressions = new ArrayList<>();

    public CommaExpression() {
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

}

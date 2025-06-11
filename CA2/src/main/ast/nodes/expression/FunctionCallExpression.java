package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionCallExpression extends Expression {
    private Expression function;
    private List<Expression> arguments = new ArrayList<>();
    private List<Expression> self_arguments = new ArrayList<>();

    public Expression getFunction() {
        return function;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public List<Expression> getSelfArguments() {
        return self_arguments;
    }

    public void setSelfArguments(List<Expression> arguments) {
        this.self_arguments = arguments;
    }

    public FunctionCallExpression() {
    }

    public FunctionCallExpression(Expression function, List<Expression> arguments) {
        this.function = function;
        this.arguments = arguments;
    }
    @Override
    public void setFunction(Expression function) {
        this.function = function;
    }
    @Override
    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }
    @Override
    public void addArgument(Expression argument) {
        this.arguments.add(argument);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

package main.ast.nodes.expression;

public class IdExpression extends Expression {
    private String name;

    public IdExpression(String name){
        this.name = name;
    }
}

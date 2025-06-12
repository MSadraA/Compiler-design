package main.ast.nodes.expression;

import main.visitor.IVisitor;

public class IdExpression extends Expression {
    private String name;

    // optional replacement expression, used for example in the case of a macro
    private Expression replacement = null;

    public void setReplacement(Expression replacement) {
        this.replacement = replacement;
    }

    public Expression getReplacement() {
        return replacement;
    }

    public String getValue() {
        return name;
    }

    public IdExpression(String name){
        this.name = name;
    }

    public IdExpression(String name , int line){
        this.name = name;
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

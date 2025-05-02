package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class StringExpression extends Expression{
    private List<String> stringliteral = new ArrayList<>();

    public List<String> getStringLiteral() {
        return stringliteral;
    }

    public List<String> getValue() {
        return stringliteral;
    }

    public StringExpression(){}

    public StringExpression(int line){
        this.setLine(line);
    }

    @Override
    public void addStringLiteral(String stringliteral){
        this.stringliteral.add(stringliteral);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

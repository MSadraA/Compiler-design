package main.ast.nodes.expression;

import java.util.ArrayList;
import java.util.List;

public class StringExpression extends Expression{
    private List<String> stringliteral = new ArrayList<>();

    public StringExpression(){}

    @Override
    public void addStringLiteral(String stringliteral){
        this.stringliteral.add(stringliteral);
    }
}

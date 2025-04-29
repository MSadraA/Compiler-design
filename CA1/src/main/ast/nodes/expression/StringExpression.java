package main.ast.nodes.expression;

import java.util.ArrayList;
import java.util.List;

public class StringExpression extends Expression{
    private List<String> stringliteral = new ArrayList<>();

    public StringExpression(){}

    public StringExpression(int line){
        this.setLine(line);
    }

    @Override
    public void addStringLiteral(String stringliteral){
        this.stringliteral.add(stringliteral);
    }
}

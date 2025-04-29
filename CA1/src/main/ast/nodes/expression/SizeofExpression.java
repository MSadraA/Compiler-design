package main.ast.nodes.expression;

import main.ast.nodes.declaration.ParamDec;

public class SizeofExpression extends Expression {
    private ParamDec typeName;

    public SizeofExpression(ParamDec typeName) {
        this.typeName = typeName;
    }
    public SizeofExpression(ParamDec typeName , int line) {
        this.typeName = typeName;
        this.setLine(line);
    }

}

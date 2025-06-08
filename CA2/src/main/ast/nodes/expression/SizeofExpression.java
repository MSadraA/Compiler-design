package main.ast.nodes.expression;

import main.ast.nodes.declaration.ParamDec;
import main.visitor.IVisitor;

public class SizeofExpression extends Expression {
    private ParamDec typeName;

    public ParamDec getTypeName() {
        return typeName;
    }

    public SizeofExpression(ParamDec typeName) {
        this.typeName = typeName;
    }
    public SizeofExpression(ParamDec typeName , int line) {
        this.typeName = typeName;
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

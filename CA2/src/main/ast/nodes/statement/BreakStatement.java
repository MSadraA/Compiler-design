package main.ast.nodes.statement;

import main.visitor.IVisitor;

public class BreakStatement extends Statement{
    public BreakStatement(){}

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

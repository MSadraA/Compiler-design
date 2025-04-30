package main.ast.nodes.statement;

import main.visitor.IVisitor;

public class ContinueStatement extends Statement{
    public ContinueStatement(){}

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

package main.ast.nodes.statement;

import main.visitor.IVisitor;

public class ForStatement extends Statement{
    private ForCondStatement condition;
    private Statement body;

    public Statement getBody() {
        return body;
    }

    @Override
    public void setBody(Statement body) {
        this.body = body;
    }

    public ForStatement(ForCondStatement condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    public ForStatement(ForCondStatement condition, Statement body , int line) {
        this.condition = condition;
        this.body = body;
        this.setLine(line);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

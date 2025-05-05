package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

public class WhileStatement extends Statement{
    private Expression condition;
    private Statement body;

    public Statement getBody() {
        return body;
    }

    public Expression getCondition() {
        return condition;
    }

    public WhileStatement(){}

    public WhileStatement(Expression condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    public WhileStatement(Expression condition, Statement body , int line){
        this.condition = condition;
        this.body = body;
        this.setLine(line);
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    @Override
    public void setBody(Statement body) {
        this.body = body;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

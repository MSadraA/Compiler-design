package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;

public class WhileStatement extends Statement{
    private Expression condition;
    private Statement body;

    public WhileStatement(){}

    public WhileStatement(Expression condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public void setBody(Statement body) {
        this.body = body;
    }
}

package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;

public class IfStatement extends Statement {
    private Expression condition;
    private Statement thenStatement;
    private Statement elseStatement;

    public IfStatement(){

    }

    public IfStatement(Expression condition, Statement thenStatement, Statement elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public void setElseStatement(Statement elseStatement) {
        this.elseStatement = elseStatement;
    }

    public void setThenStatement(Statement thenStatement) {
        this.thenStatement = thenStatement;
    }
}


package main.ast.nodes.statement;

public class ForStatement extends Statement{
    private ForCondStatement condition;
    private Statement body;

    public ForStatement(ForCondStatement condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    public ForStatement(ForCondStatement condition, Statement body , int line) {
        this.condition = condition;
        this.body = body;
        this.setLine(line);
    }
}

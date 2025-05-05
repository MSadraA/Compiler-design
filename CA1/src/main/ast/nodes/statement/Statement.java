package main.ast.nodes.statement;

import main.ast.nodes.Node;

public abstract class Statement extends Node implements BlockItem{
    private Integer indentLevel = 0;

    public void setBody(Statement body){}

    public void setIndentLevel(Integer indentLevel) {
        this.indentLevel = indentLevel;
    }

    public void addIndentLevel() {
        this.indentLevel += 1;
    }

    public Integer getIndentLevel() {
        return indentLevel;
    }
}

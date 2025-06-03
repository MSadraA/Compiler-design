package main.ast.nodes.declaration;
import main.ast.nodes.Node;

import main.ast.nodes.statement.BlockItem;
import main.visitor.IVisitor;


public abstract class Declaration extends Node implements BlockItem {
    private Integer indentLevel = 0;
    public void setIndentLevel(Integer indentLevel){
        this.indentLevel = indentLevel;
    }

    public void addIndentLevel() {
        this.indentLevel += 1;
    }

    public Integer getIndentLevel(){
        return this.indentLevel;
    }
}

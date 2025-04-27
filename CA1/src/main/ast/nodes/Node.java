package main.ast.nodes;


import java.util.ArrayList;

public abstract class Node {
    private int line;

    public void setLine(int line){this.line = line;}
    public int getLine(){return this.line;}
}

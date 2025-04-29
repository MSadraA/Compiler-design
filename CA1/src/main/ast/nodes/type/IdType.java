package main.ast.nodes.type;

public class IdType extends Type {
    private String name;

    public IdType(String name){
        this.name = name;
    }

    public IdType(String name , int line){
        this.name = name;
        this.setLine(line);
    }
}

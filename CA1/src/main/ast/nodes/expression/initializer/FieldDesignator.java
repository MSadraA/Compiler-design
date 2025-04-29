package main.ast.nodes.expression.initializer;

public class FieldDesignator extends Designator {
    private String fieldName;

    public FieldDesignator(){}

    public FieldDesignator(String fieldName , int line){
        this.fieldName = fieldName;
        this.setLine(line);
    }

    @Override
    public void setIdentifier(String fieldName) {
        this.fieldName = fieldName;
    }
}


package main.ast.nodes.expression.initializer;

import main.visitor.IVisitor;

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

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}


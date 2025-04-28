package main.ast.nodes.expression.initializer;

public class FieldDesignator extends Designator {
    private String fieldName;

    @Override
    public void setIdentifier(String fieldName) {
        this.fieldName = fieldName;
    }
}


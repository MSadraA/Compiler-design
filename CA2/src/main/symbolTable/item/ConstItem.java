package main.symbolTable.item;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.type.Type;

import java.util.List;

public class ConstItem extends VariableItem {
    private Expression value;

    public ConstItem(String name, List<Type> types, Expression value , Declaration declaration) {
        super(name , types , declaration);
        this.value = value;
    }

    public Expression getValue() {
        return value;
    }
}
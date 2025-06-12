package main.symbolTable.item;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.VarDec;
import main.ast.nodes.type.Type;

import java.util.List;

public class TypedefItem extends VariableItem {
    public TypedefItem(String name, List<Type> actualType , Declaration declaration) {
        super(name , actualType , declaration);
    }
}
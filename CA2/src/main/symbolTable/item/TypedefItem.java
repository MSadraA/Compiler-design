package main.symbolTable.item;

import main.ast.nodes.type.Type;

import java.util.List;

public class TypedefItem extends SymbolTableItem {
    public TypedefItem(String name, List<Type> actualType) {
        super(name , actualType);
    }
}
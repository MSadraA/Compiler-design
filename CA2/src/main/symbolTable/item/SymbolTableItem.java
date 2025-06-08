package main.symbolTable.item;

import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.type.Type;
import main.symbolTable.utils.DeclaratorUtils;

import java.util.List;

public class SymbolTableItem {
    protected String name;
    protected List<Type> types;

    public SymbolTableItem(String name, List<Type> types) {
        this.name = name;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public String getTypeString() {
        return types.stream().map(Type::toString).reduce((a, b) -> a + " " + b).orElse("");
    }

    public String getKey() {
        return name;
    }
}


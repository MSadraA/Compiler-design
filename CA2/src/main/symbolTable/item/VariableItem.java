package main.symbolTable.item;

import main.ast.nodes.declarator.Declarator;
import main.ast.nodes.declarator.InitDeclarator;
import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.type.Type;
import main.symbolTable.SymbolTable;

import java.util.List;

import static main.symbolTable.utils.DeclaratorUtils.extractName;


public class VariableItem extends SymbolTableItem {
    public VariableItem(String name, List<Type> types) {
        super(name, types);
    }
}




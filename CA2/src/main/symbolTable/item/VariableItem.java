package main.symbolTable.item;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declarator.Declarator;
import main.ast.nodes.declarator.InitDeclarator;
import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.type.Type;
import main.symbolTable.SymbolTable;

import java.util.List;

import static main.symbolTable.utils.DeclaratorUtils.extractName;


public class VariableItem extends SymbolTableItem {
    private Declaration declaration = null;

    public Declaration getDeclaration(){
        return declaration;
    }

    public VariableItem(String name, List<Type> types) {
        super(name, types);
    }

    public VariableItem(String name, List<Type> types , Declaration declaration) {
        super(name, types);
        this.declaration = declaration;
    }
}




package main.ast.nodes.specifier;

import main.ast.nodes.declarator.pointer.Pointer;

public class TypedefSpecifier extends Specifier implements Pointer {
    public TypedefSpecifier(){}

    public TypedefSpecifier(int line){
        this.setLine(line);
    }
}

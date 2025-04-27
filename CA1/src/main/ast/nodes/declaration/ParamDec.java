package main.ast.nodes.declaration;

import main.ast.nodes.declarator.Declarator;
import main.ast.nodes.specifier.Specifier;

import java.util.ArrayList;
import java.util.List;

public class ParamDec extends Declaration {
    private List<Specifier> specifiers = new ArrayList<>();
    private Declarator declarator;

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setSpecifiers(List<Specifier> specifiers) {
        this.specifiers = specifiers;
    }

    public ParamDec() {
    }
}

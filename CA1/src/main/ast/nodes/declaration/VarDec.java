package main.ast.nodes.declaration;

import main.ast.nodes.declarator.InitDeclarator;
import main.ast.nodes.specifier.Specifier;

import java.util.List;

public class VarDec extends Declaration{
    private List<Specifier> specifiers;
    private List<InitDeclarator> initDeclarators;

    public VarDec(List<Specifier> specifiers, List<InitDeclarator> initDeclarators) {
        this.specifiers = specifiers;
        this.initDeclarators = initDeclarators;
    }

    public VarDec(){
    }

    public void setSpecifiers(List<Specifier> specifiers) {
        this.specifiers = specifiers;
    }

    public void setInitDeclarators(List<InitDeclarator> initDeclarators) {
        this.initDeclarators = initDeclarators;
    }
}


package main.ast.nodes.declaration;

import main.ast.nodes.declarator.InitDeclarator;
import main.ast.nodes.specifier.Specifier;
import main.visitor.IVisitor;

import java.util.List;

public class VarDec extends Declaration{
    private List<Specifier> specifiers;
    private List<InitDeclarator> initDeclarators;

    public List<Specifier> getSpecifiers(){
        return specifiers;
    }

    public List<InitDeclarator> getInitDeclarators(){
        return initDeclarators;
    }

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


    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}


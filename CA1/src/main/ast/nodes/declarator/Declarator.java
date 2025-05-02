package main.ast.nodes.declarator;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.declarator.pointer.Pointer;
import main.ast.nodes.expression.Expression;

import java.lang.reflect.Parameter;
import java.util.List;

public abstract class Declarator extends Node {
    public void setIdentifier(String identifier) {
    }

    public void setDeclarator(Declarator declarator) {
    }

    public void setExpression(Expression expression) {
    }

    public void setParameters(List<ParamDec> parameters) {
    }

    public void setIdentifiers(List<String> identifiers) {
    }

    public void setPointers(List<Pointer> pointers){

    }

}

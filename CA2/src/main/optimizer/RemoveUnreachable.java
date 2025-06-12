package main.optimizer;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declarator.pointer.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.declarator.*;
import main.ast.nodes.specifier.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.expression.initializer.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FunctionItem;
import main.visitor.Visitor;

import java.util.*;

import static main.symbolTable.utils.DeclaratorUtils.extractName;

public class RemoveUnreachable extends Visitor<Void> {

    @Override
    public Void visit(Program program) {
        List<Declaration> reachableDeclarations = new ArrayList<>();
        for (Declaration declaration : program.getDeclarations()) {
            if( declaration instanceof FuncDec funcDec){
                if(funcDec.isReachable())
                    reachableDeclarations.add(funcDec);
            }
            else
                reachableDeclarations.add(declaration);
        }
        program.setDeclarations(reachableDeclarations);
        return null;
    }
}



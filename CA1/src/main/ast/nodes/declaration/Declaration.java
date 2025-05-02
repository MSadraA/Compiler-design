package main.ast.nodes.declaration;
import main.ast.nodes.Node;

import main.ast.nodes.statement.BlockItem;
import main.visitor.IVisitor;


public abstract class Declaration extends Node implements BlockItem {}

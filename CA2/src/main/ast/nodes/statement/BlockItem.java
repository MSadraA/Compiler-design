package main.ast.nodes.statement;

import main.visitor.IVisitor;

public interface BlockItem {
    <T> T accept(IVisitor<T> visitor);
}

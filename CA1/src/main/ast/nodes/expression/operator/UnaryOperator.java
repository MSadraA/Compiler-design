package main.ast.nodes.expression.operator;

public enum UnaryOperator {
    PLUS, MINUS,
    NOT,       // Logical NOT (!)
    BITWISE_NOT, // Bitwise NOT (~)
    INCREMENT,  // ++
    DECREMENT,  // --
    SIZEOF,
    AND,
    TILDE,
    STAR,
}


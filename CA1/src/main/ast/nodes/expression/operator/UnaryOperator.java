package main.ast.nodes.expression.operator;

public enum UnaryOperator {
    PLUS, MINUS,
    NOT,         // Logical NOT (!)
    BITWISE_NOT, // Bitwise NOT (~)
    INCREMENT,   // ++
    DECREMENT,   // --
    SIZEOF,
    AND,         // address-of (&)
    TILDE,       // bitwise NOT (~), duplicate of BITWISE_NOT
    STAR;        // dereference (*)

    public String getSymbol() {
        return switch (this) {
            case PLUS -> "+";
            case MINUS -> "-";
            case NOT -> "!";
            case BITWISE_NOT, TILDE -> "~";
            case INCREMENT -> "++";
            case DECREMENT -> "--";
            case SIZEOF -> "sizeof";
            case AND -> "&";
            case STAR -> "*";
        };
    }
}

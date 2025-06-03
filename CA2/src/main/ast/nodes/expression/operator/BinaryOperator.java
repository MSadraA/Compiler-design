package main.ast.nodes.expression.operator;

public enum BinaryOperator {
    EQUAL, NOT_EQUAL,GREATER_EQUAL,LESS_EQUAL,
    GREATER_THAN, LESS_THAN,
    PLUS, MINUS,
    MUL, DIV, MOD,
    AND, OR,
    BITWISE_AND, BITWISE_OR, BITWISE_XOR,
    LEFT_SHIFT, RIGHT_SHIFT,
    ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN, MUL_ASSIGN, DIV_ASSIGN, MOD_ASSIGN,
    LEFT_SHIFT_ASSIGN,RIGHT_SHIFT_ASSIGN,AND_ASSIGN,
    XOR_ASSIGN,OR_ASSIGN;

    public String getSymbol() {
        return switch (this) {
            case EQUAL -> "==";
            case NOT_EQUAL -> "!=";
            case GREATER_EQUAL -> ">=";
            case LESS_EQUAL -> "<=";
            case GREATER_THAN -> ">";
            case LESS_THAN -> "<";
            case PLUS -> "+";
            case MINUS -> "-";
            case MUL -> "*";
            case DIV -> "/";
            case MOD -> "%";
            case AND -> "&&";
            case OR -> "||";
            case BITWISE_AND -> "&";
            case BITWISE_OR -> "|";
            case BITWISE_XOR -> "^";
            case LEFT_SHIFT -> "<<";
            case RIGHT_SHIFT -> ">>";
            case ASSIGN -> "=";
            case PLUS_ASSIGN -> "+=";
            case MINUS_ASSIGN -> "-=";
            case MUL_ASSIGN -> "*=";
            case DIV_ASSIGN -> "/=";
            case MOD_ASSIGN -> "%=";
            case LEFT_SHIFT_ASSIGN -> "<<=";
            case RIGHT_SHIFT_ASSIGN -> ">>=";
            case AND_ASSIGN -> "&=";
            case XOR_ASSIGN -> "^=";
            case OR_ASSIGN -> "|=";
            };
        }
    }

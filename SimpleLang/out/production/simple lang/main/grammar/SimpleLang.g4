grammar SimpleLang;

// Parser rules
program : (func_dec )* main;

func_dec: 'FuncDec' ID LPAR RPAR LBRACE stmt* RBRACE;

main: MAIN LPAR RPAR LBRACE stmt* RBRACE;

stmt:
    assign
    | if_stmt
    | var_dec
    | func_call SEMI
    | return_stmt
    ;

return_stmt: RETURN expr SEMI;

var_dec: TYPE ID SEMI;

assign: ID ASSIGN expr SEMI;

if_stmt:  IF LPAR expr RPAR stmt (ELSE stmt)?;

expr:
    expr (
        '++'
        | '--'
        )
    | expr op = ('*' | '/') expr
    | expr op = ('+' | '-') expr
    | func_call
    | primary_expr;

func_call: ID LPAR RPAR;

primary_expr:
    ID
    | INT_VAL
    | BOOL_VAL
    | STR_VAL
    | DOUBLE_VAL;

// Lexer rules

// 1- General structure
MAIN : 'main';
TYPE : 'int' | 'string' | 'double' | 'bool';
IF : 'if';
ELSE : 'else';
RETURN : 'return';

// 2- Symbols
LBRACE : '{';
RBRACE : '}';
SEMI : ';';
ASSIGN : '=';
PLUS : '+';
LPAR : '(';
RPAR : ')';

// 3- Identifiers
ID : [a-zA-Z_][a-zA-Z0-9_]*;
INT_VAL : [0] | [1-9][0-9]*;
STR_VAL : '"' ( ~["\\] | '\\' . )* '"' ;
BOOL_VAL: 'true' | 'false';
DOUBLE_VAL: ([0] | [1-9][0-9]*)'.'[0-9]+;


// 4- Whitespace and comments
WHITE_SPACE : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
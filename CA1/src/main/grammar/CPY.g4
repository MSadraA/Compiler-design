grammar CPY;

@header{
    import java.util.ArrayList;
    import java.util.List;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.declarator.pointer.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.declarator.*;
    import main.ast.nodes.specifier.*;
    import main.ast.nodes.statement.*;
    import main.ast.nodes.type.*;
    import main.ast.nodes.expression.initializer.*;
    import main.ast.nodes.expression.operator.*;
}


program returns [Program programRet]:
    (t = translationUnit { $programRet = $t.programRet; })? EOF ;

translationUnit returns [Program programRet]:
    { $programRet = new Program(); }
    (e = externalDeclaration { if ($e.declarationRet != null) $programRet.addDeclaration($e.declarationRet); })+ ;

externalDeclaration returns [Declaration declarationRet]:
    f=functionDefinition { $declarationRet = $f.functionDecRet; }
    | d=declaration { $declarationRet = $d.varDecRet; }
    | Semi { $declarationRet = null; }
    ;

functionDefinition returns [FuncDec functionDecRet]:
    { $functionDecRet = new FuncDec(); }
    (a = declarationSpecifiers{$functionDecRet.setSpecifiers($a.specifiersRet);})?
    b = declarator { $functionDecRet.setDeclarator($b.declaratorRet); }
    (c = declarationList{$functionDecRet.setVarDec($c.varDecsRet);})?
    d = compoundStatement{ $functionDecRet.setStatement($d.compoundStatementRet); }
    ;

declarationList returns [List<VarDec> varDecsRet]:
    { $varDecsRet = new ArrayList<>(); }
    (d = declaration {$varDecsRet.add($d.varDecRet);})+ ;


expression returns [Expression expressionRet]:
    pri = primaryExpression {$expressionRet = $pri.expressionRet;}
    | e1 = expression LeftBracket e2 = expression RightBracket                      // Array indexing
    {
        $expressionRet = new ArrayExpression();
        $expressionRet.setAssigned($e1.expressionRet);
        $expressionRet.setIndex($e2.expressionRet);
    }
    | e = expression                                                                // Function call
    {
        $expressionRet = new FunctionCallExpression();
        $expressionRet.setFunction($e.expressionRet);
    }
    LeftParen (a = argumentExpressionList {$expressionRet.setArguments($a.expressionsRet);})? RightParen
    //Unarys
    | e = expression PlusPlus {$expressionRet = new UnaryExpression($e.expressionRet, UnaryOperator.INCREMENT, true);} // Postfix increment
    | e = expression MinusMinus {$expressionRet = new UnaryExpression($e.expressionRet, UnaryOperator.DECREMENT, true);} // Postfix decrement
    | pre = prefixexpression {$expressionRet = $pre.expressionRet;}
    | c = castType {$expressionRet = $c.expressionRet;}                             // Cast expression
    //Binarys
    | e1 = expression {$expressionRet = new BinaryExpression();
    $expressionRet.setLeftOperand($e1.expressionRet);}
    (Star {$expressionRet.setBinaryOperator(BinaryOperator.MUL);}
    | Div {$expressionRet.setBinaryOperator(BinaryOperator.DIV);}
    | Mod {$expressionRet.setBinaryOperator(BinaryOperator.MOD);})
    e2 = expression {$expressionRet.setRightOperand($e2.expressionRet);}// Multiplicative
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      (Plus { $expressionRet.setBinaryOperator(BinaryOperator.PLUS); }
      | Minus { $expressionRet.setBinaryOperator(BinaryOperator.MINUS); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); } // Additive
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      (LeftShift { $expressionRet.setBinaryOperator(BinaryOperator.LEFT_SHIFT); }
      | RightShift { $expressionRet.setBinaryOperator(BinaryOperator.RIGHT_SHIFT); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Shift
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      (Less { $expressionRet.setBinaryOperator(BinaryOperator.LESS_THAN); }
      | Greater { $expressionRet.setBinaryOperator(BinaryOperator.GREATER_THAN); }
      | LessEqual { $expressionRet.setBinaryOperator(BinaryOperator.LESS_EQUAL); }
      | GreaterEqual { $expressionRet.setBinaryOperator(BinaryOperator.GREATER_EQUAL); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Relational
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      (Equal { $expressionRet.setBinaryOperator(BinaryOperator.EQUAL); }
      | NotEqual { $expressionRet.setBinaryOperator(BinaryOperator.NOT_EQUAL); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Equality
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      And { $expressionRet.setBinaryOperator(BinaryOperator.BITWISE_AND); }
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Bitwise AND
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      Xor { $expressionRet.setBinaryOperator(BinaryOperator.BITWISE_XOR); }
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Bitwise XOR
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      Or { $expressionRet.setBinaryOperator(BinaryOperator.BITWISE_OR); }
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Bitwise OR
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      AndAnd { $expressionRet.setBinaryOperator(BinaryOperator.AND); }
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Logical AND
    | e1 = expression { $expressionRet = new BinaryExpression();
                        $expressionRet.setLeftOperand($e1.expressionRet); }
      OrOr { $expressionRet.setBinaryOperator(BinaryOperator.OR); }
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }// Logical OR

    | e1 = expression Question e2 = expression Colon e3 = expression// Conditional operator
    {$expressionRet = new ConditionalExpression($e1.expressionRet , $e2.expressionRet , $e3.expressionRet);}

    | e1 = expression op = assignmentOperator e2 = expression// Assignment
    {$expressionRet = new BinaryExpression($e1.expressionRet,$e2.expressionRet,$op.binaryOperatorRet);}
    | e1 = expression                                                               // Comma operator
    {
        $expressionRet = new CommaExpression();
        $expressionRet.addExpression($e1.expressionRet);
    }
    (Comma e2 = expression {$expressionRet.addExpression($e2.expressionRet);})+ ;


prefixexpression returns [Expression expressionRet , List<UnaryOperator> ops = new ArrayList<>()]:
    (p=prefixOperator { $ops.add($p.operatorRet); })* (base = postfixExpression)
      {
          $expressionRet = $base.expressionRet;
          for (int i = $ops.size() - 1; i >= 0; i--) {
              UnaryExpression ue = new UnaryExpression($expressionRet , $ops.get(i) , false);
              $expressionRet = ue;
          }
      }
    ;

prefixOperator returns [UnaryOperator operatorRet]:
    PlusPlus { $operatorRet = UnaryOperator.INCREMENT; }
    | MinusMinus { $operatorRet = UnaryOperator.DECREMENT; }
    | Sizeof { $operatorRet = UnaryOperator.SIZEOF; }
    ;

postfixExpression returns [Expression expressionRet]:
    p = primaryExpression {$expressionRet = $p.expressionRet;}
    | op = unaryOperator c = castExpression {$expressionRet = new UnaryExpression($c.expressionRet, $op.operatorRet, false);}
    | Sizeof LeftParen t = typeName RightParen {$expressionRet = new SizeofExpression($t.parameterRet);}
    ;

primaryExpression returns [Expression expressionRet]:
    Identifier
    {
        $expressionRet = new IdExpression($Identifier.getText());
        $expressionRet.setLine($Identifier.getLine());
    }
    | Constant
    {
        $expressionRet = new ConstExpression($Constant.getText());
        $expressionRet.setLine($Constant.getLine());
    }
    | {$expressionRet = new StringExpression();}
    (StringLiteral {$expressionRet.addStringLiteral($StringLiteral.getText());})+
    | LeftParen expression RightParen
    {
        $expressionRet = $expression.expressionRet;
    }
    | {$expressionRet = new CompoundLiteralExpression();}
    LeftParen (t = typeName) {$expressionRet.setType($t.parameterRet);} RightParen
    LeftBrace (i = initializerList) {$expressionRet.setInitializers($i.initializerListRet);} Comma? RightBrace
    ;

argumentExpressionList returns [List<Expression> expressionsRet]:
    { $expressionsRet = new ArrayList<>(); }
    e1 = expression {$expressionsRet.add($e1.expressionRet);}
    (Comma e2 = expression {$expressionsRet.add($e2.expressionRet);})* ;

unaryOperator returns [UnaryOperator operatorRet]:
    And { $operatorRet = UnaryOperator.AND;}
    | Star { $operatorRet = UnaryOperator.STAR; }
    | Plus { $operatorRet = UnaryOperator.PLUS; }
    | Minus { $operatorRet = UnaryOperator.MINUS; }
    | Tilde { $operatorRet = UnaryOperator.TILDE; }
    | Not { $operatorRet = UnaryOperator.NOT; }
    ;

castExpression returns [Expression expressionRet]
  : castType { $expressionRet = $castType.expressionRet; }
  | expression { $expressionRet = $expression.expressionRet; }
  | DigitSequence { $expressionRet = new DigitSequenceExpression($DigitSequence.getText());}
  ;

castType returns [Expression expressionRet]:
    LeftParen t = typeName RightParen c =castExpression
    { $expressionRet = new CastExpression($t.parameterRet , $c.expressionRet); }
    ;

assignmentOperator returns [BinaryOperator binaryOperatorRet]
  : Assign {$binaryOperatorRet = BinaryOperator.ASSIGN;}
  | StarAssign {$binaryOperatorRet = BinaryOperator.MUL_ASSIGN;}
  | DivAssign {$binaryOperatorRet = BinaryOperator.DIV_ASSIGN;}
  | ModAssign {$binaryOperatorRet = BinaryOperator.MOD_ASSIGN;}
  | PlusAssign {$binaryOperatorRet = BinaryOperator.PLUS_ASSIGN;}
  | MinusAssign {$binaryOperatorRet = BinaryOperator.MINUS_ASSIGN;}
  | LeftShiftAssign {$binaryOperatorRet = BinaryOperator.LEFT_SHIFT_ASSIGN;}
  | RightShiftAssign {$binaryOperatorRet = BinaryOperator.RIGHT_SHIFT_ASSIGN;}
  | AndAssign {$binaryOperatorRet = BinaryOperator.AND_ASSIGN;}
  | XorAssign {$binaryOperatorRet = BinaryOperator.XOR_ASSIGN;}
  | OrAssign {$binaryOperatorRet = BinaryOperator.OR_ASSIGN;}
  ;

declaration returns [VarDec varDecRet]:
    { $varDecRet = new VarDec(); }
    declarationSpecifiers initDeclaratorList? Semi ;

declarationSpecifiers returns [List<Specifier> specifiersRet]
    : { $specifiersRet = new ArrayList<>(); }
      (d = declarationSpecifier { $specifiersRet.add($d.specifierRet); })+ ;


declarationSpecifier returns [Specifier specifierRet]:
    Typedef{$specifierRet = new TypedefSpecifier(); $specifierRet.setLine($Typedef.getLine());}
    | t = typeSpecifier{$specifierRet = $t.typeRet;}
    | Const {$specifierRet = new ConstSpecifier(); $specifierRet.setLine($Const.getLine());};

initDeclaratorList
    : initDeclarator (Comma initDeclarator)* ;

initDeclarator
    : declarator (Assign initializer)? ;

typeSpecifier returns [Type typeRet]
    : Void    {$typeRet = new VoidType(); $typeRet.setLine($Void.getLine());}
    | Char    {$typeRet = new CharType(); $typeRet.setLine($Char.getLine());}
    | Short   {$typeRet = new ShortType(); $typeRet.setLine($Short.getLine());}
    | Int     {$typeRet = new IntType(); $typeRet.setLine($Int.getLine());}
    | Long    {$typeRet = new LongType(); $typeRet.setLine($Long.getLine());}
    | Float   {$typeRet = new FloatType(); $typeRet.setLine($Float.getLine());}
    | Double  {$typeRet = new DoubleType(); $typeRet.setLine($Double.getLine());}
    | Signed  {$typeRet = new SignedType(); $typeRet.setLine($Signed.getLine());}
    | Unsigned{$typeRet = new UnsignedType(); $typeRet.setLine($Unsigned.getLine());}
    | Bool    {$typeRet = new BoolType(); $typeRet.setLine($Bool.getLine());}
    | id = Identifier {$typeRet = new IdType($id.getText()); $typeRet.setLine($id.getLine());}
    ;

specifierQualifierList returns [List<Specifier> specifiersRet]:
    { $specifiersRet = new ArrayList<>(); }
    (t = typeSpecifier { $specifiersRet.add($t.typeRet);}
    | Const
    {
        ConstSpecifier constSpec = new ConstSpecifier();
        constSpec.setLine($Const.getLine());
        $specifiersRet.add(constSpec);
    })
    (s = specifierQualifierList {$specifiersRet.addAll($s.specifiersRet);})? ;

declarator returns [PointerDeclarator declaratorRet]:
    { $declaratorRet = new PointerDeclarator(); }
    (p = pointer { $declaratorRet.setPointers($p.pointersRet); })?
    d = directDeclarator { $declaratorRet.setDeclarator($d.declaratorRet); };

directDeclarator returns [Declarator declaratorRet]
    : Identifier
    {
        $declaratorRet = new IdentifierDeclarator();
        $declaratorRet.setIdentifier($Identifier.text);
        $declaratorRet.setLine($Identifier.getLine());
    }
    | LeftParen a = declarator RightParen { $declaratorRet = $a.declaratorRet; }
    | b = directDeclarator
    {
        $declaratorRet = new ArrayDeclarator();
        $declaratorRet.setDeclarator($b.declaratorRet);
    }
      LeftBracket (c = expression { $declaratorRet.setExpression($c.expressionRet); })? RightBracket
    | d = directDeclarator
    {
        $declaratorRet = new FunctionDeclarator();
        $declaratorRet.setDeclarator($d.declaratorRet);
    }
    LeftParen (f = parameterList { $declaratorRet.setParameters($f.parametersRet); }
    | (g = identifierList { $declaratorRet.setIdentifiers($g.identifiersRet); })?) RightParen ;

pointer returns [List<Pointer> pointersRet]
    : { $pointersRet = new ArrayList<Pointer>(); }
      ((Star)
       (Const { $pointersRet.add(new ConstSpecifier()); })?)+ ;

parameterList returns [List<ParamDec> parametersRet]
    : { $parametersRet = new ArrayList<ParamDec>(); }
      a = parameterDeclaration { $parametersRet.add($a.parameterRet); }
      (Comma b = parameterDeclaration { $parametersRet.add($b.parameterRet); })* ;

parameterDeclaration returns [ParamDec parameterRet]
    : { $parameterRet = new ParamDec(); }
      a = declarationSpecifiers { $parameterRet.setSpecifiers($a.specifiersRet); }
      ((b = declarator { $parameterRet.setDeclarator($b.declaratorRet); })
       | (c = abstractDeclarator { $parameterRet.setDeclarator($c.declaratorRet); })?) ;

identifierList returns [List<String> identifiersRet]
    : { $identifiersRet = new ArrayList<String>(); }
      Identifier { $identifiersRet.add($Identifier.text); }
      (Comma Identifier { $identifiersRet.add($Identifier.text); })* ;

typeName returns [ParamDec parameterRet]:
    { $parameterRet = new ParamDec(); }
    s = specifierQualifierList { $parameterRet.setSpecifiers($s.specifiersRet); }
    (a = abstractDeclarator {$parameterRet.setDeclarator($a.declaratorRet);})? ;

abstractDeclarator returns [Declarator declaratorRet]
    : { $declaratorRet = new PointerDeclarator(); }
      (p = pointer { $declaratorRet.setPointers($p.pointersRet); })?
      d = directAbstractDeclarator { $declaratorRet.setDeclarator($d.declaratorRet); }
    | { $declaratorRet = new PointerDeclarator(); }
      p = pointer { $declaratorRet.setPointers($p.pointersRet); }
    ;

directAbstractDeclarator returns [Declarator declaratorRet]:
    { $declaratorRet = new ArrayDeclarator(); }
    LeftBracket (a = expression {$declaratorRet.setExpression($a.expressionRet);})? RightBracket
    | { $declaratorRet = new FunctionDeclarator(); }
    LeftParen  ((b = abstractDeclarator {$declaratorRet.setDeclarator($b.declaratorRet) ;})
    | (c = parameterList {$declaratorRet.setParameters($c.parametersRet);})?) RightParen
    | d = directAbstractDeclarator
    {
        $declaratorRet = new ArrayDeclarator();
        $declaratorRet.setDeclarator($d.declaratorRet);
    }
    LeftBracket (e = expression {$declaratorRet.setExpression($e.expressionRet);})? RightBracket
    | f = directAbstractDeclarator
    {
        $declaratorRet = new FunctionDeclarator();
        $declaratorRet.setDeclarator($f.declaratorRet);
    }
    LeftParen (g = parameterList {$declaratorRet.setParameters($g.parametersRet);})? RightParen ;

initializer returns [Initializer initializerRet]:
    e = expression
    {
        $initializerRet = new Initializer();
        $initializerRet.setExpression($e.expressionRet);
    }
    | LeftBrace i = initializerList Comma? RightBrace
    {
        $initializerRet = new Initializer();
        $initializerRet.setInitializerList($i.initializerListRet);
    }
;

initializerList returns [List<InitializerEntry> initializerListRet]
    : { $initializerListRet = new ArrayList<>(); }
      first = initializerEntry { $initializerListRet.add($first.entryRet); }
      (Comma next=initializerEntry { $initializerListRet.add($next.entryRet); })*
    ;

initializerEntry returns [InitializerEntry entryRet]:
    {$entryRet = new InitializerEntry();}
    (d = designation {$entryRet.setDesignators($d.designatorsRet);})?
    i=initializer {$entryRet.setInitializer($i.initializerRet);}
    ;

designation returns [List<Designator> designatorsRet]
    : { $designatorsRet = new ArrayList<>(); }
      (d=designator { $designatorsRet.add($d.designatorRet); })+ Assign
    ;

designator returns [Designator designatorRet]
    : LeftBracket e = expression RightBracket
        { $designatorRet = new ArrayDesignator(); $designatorRet.setExpression($e.expressionRet); }
    | Dot Identifier
        {
            $designatorRet = new FieldDesignator();
            $designatorRet.setIdentifier($Identifier.getText());
            $designatorRet.setLine($Identifier.getLine());
        }
    ;

statement returns [Statement statementRet]
    : c = compoundStatement { $statementRet = $c.compoundStatementRet; }
    | e = expressionStatement { $statementRet = $e.statementRet; }
    | selectionStatement | iterationStatement | jumpStatement ;

compoundStatement returns [CompoundStatement compoundStatementRet]:
    { $compoundStatementRet = new CompoundStatement(); }
    LeftBrace ((b = blockItem
    {
        if ($b.varDecRet != null) {
            $compoundStatementRet.addVarDec($b.varDecRet);
        }
        else if ($b.statementRet != null) {
            $compoundStatementRet.addStatement($b.statementRet);
        }
    }
    )+)? RightBrace ;

blockItem returns [Statement statementRet , VarDec varDecRet]
    : s = statement {$statementRet = $s.statementRet;}
    | d = declaration {$varDecRet = $d.varDecRet;} ;

expressionStatement returns [Statement statementRet]
    : (e = expression
    {
        $statementRet = new ExpressionStatement($e.expressionRet);
    })?
    Semi ;

selectionStatement
    : If LeftParen expression RightParen statement (Else statement)? ;

iterationStatement
    : While LeftParen expression RightParen statement
    | Do statement While LeftParen expression RightParen Semi
    | For LeftParen forCondition RightParen statement ;

forCondition
    : (forDeclaration | expression?) Semi forExpression? Semi forExpression? ;

forDeclaration
    : declarationSpecifiers initDeclaratorList? ;

forExpression
    : expression (Comma expression)* ;

jumpStatement
    : ( Continue | Break | Return expression? ) Semi ;

Break                 : 'break'                 ;
Char                  : 'char'                  ;
Const                 : 'const'                 ;
Continue              : 'continue'              ;
Do                    : 'do'                    ;
Double                : 'double'                ;
Else                  : 'else'                  ;
Float                 : 'float'                 ;
For                   : 'for'                   ;
If                    : 'if'                    ;
Int                   : 'int'                   ;
Long                  : 'long'                  ;
Return                : 'return'                ;
Short                 : 'short'                 ;
Signed                : 'signed'                ;
Sizeof                : 'sizeof'                ;
Switch                : 'switch'                ;
Typedef               : 'typedef'               ;
Unsigned              : 'unsigned'              ;
Void                  : 'void'                  ;
While                 : 'while'                 ;
Bool                  : 'bool'                  ;
LeftParen             : '('                     ;
RightParen            : ')'                     ;
LeftBracket           : '['                     ;
RightBracket          : ']'                     ;
LeftBrace             : '{'                     ;
RightBrace            : '}'                     ;
Less                  : '<'                     ;
LessEqual             : '<='                    ;
Greater               : '>'                     ;
GreaterEqual          : '>='                    ;
LeftShift             : '<<'                    ;
RightShift            : '>>'                    ;
Plus                  : '+'                     ;
PlusPlus              : '++'                    ;
Minus                 : '-'                     ;
MinusMinus            : '--'                    ;
Star                  : '*'                     ;
Div                   : '/'                     ;
Mod                   : '%'                     ;
And                   : '&'                     ;
Or                    : '|'                     ;
AndAnd                : '&&'                    ;
OrOr                  : '||'                    ;
Xor                   : '^'                     ;
Not                   : '!'                     ;
Tilde                 : '~'                     ;
Question              : '?'                     ;
Colon                 : ':'                     ;
Semi                  : ';'                     ;
Comma                 : ','                     ;
Assign                : '='                     ;
StarAssign            : '*='                    ;
DivAssign             : '/='                    ;
ModAssign             : '%='                    ;
PlusAssign            : '+='                    ;
MinusAssign           : '-='                    ;
LeftShiftAssign       : '<<='                   ;
RightShiftAssign      : '>>='                   ;
AndAssign             : '&='                    ;
XorAssign             : '^='                    ;
OrAssign              : '|='                    ;
Equal                 : '=='                    ;
NotEqual              : '!='                    ;
Arrow                 : '->'                    ;
Dot                   : '.'                     ;

Identifier
    : IdentifierNondigit (IdentifierNondigit | Digit)* ;

fragment IdentifierNondigit
    : Nondigit | UniversalCharacterName ;

fragment Nondigit
    : [a-zA-Z_] ;

fragment Digit
    : [0-9] ;

fragment UniversalCharacterName
    : '\\u' HexQuad | '\\U' HexQuad HexQuad ;

fragment HexQuad
    : HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit ;

Constant
    : IntegerConstant | FloatingConstant | CharacterConstant ;

fragment IntegerConstant
    : DecimalConstant IntegerSuffix?
    | OctalConstant IntegerSuffix?
    | HexadecimalConstant IntegerSuffix?
    | BinaryConstant ;

fragment BinaryConstant
    : '0' [bB] [0-1]+ ;

fragment DecimalConstant
    : NonzeroDigit Digit* ;

fragment OctalConstant
    : '0' OctalDigit* ;

fragment HexadecimalConstant
    : HexadecimalPrefix HexadecimalDigit+ ;

fragment HexadecimalPrefix
    : '0' [xX] ;

fragment NonzeroDigit
    : [1-9] ;

fragment OctalDigit
    : [0-7] ;

fragment HexadecimalDigit
    : [0-9a-fA-F] ;

fragment IntegerSuffix
    : UnsignedSuffix LongSuffix? | UnsignedSuffix LongLongSuffix | LongSuffix UnsignedSuffix? | LongLongSuffix UnsignedSuffix? ;

fragment UnsignedSuffix
    : [uU] ;

fragment LongSuffix
    : [lL] ;

fragment LongLongSuffix
    : 'll' | 'LL' ;

fragment FloatingConstant
    : DecimalFloatingConstant | HexadecimalFloatingConstant ;

fragment DecimalFloatingConstant
    : FractionalConstant ExponentPart? FloatingSuffix? | DigitSequence ExponentPart FloatingSuffix? ;

fragment HexadecimalFloatingConstant
    : HexadecimalPrefix (HexadecimalFractionalConstant | HexadecimalDigitSequence) BinaryExponentPart FloatingSuffix? ;

fragment FractionalConstant
    : DigitSequence? Dot DigitSequence | DigitSequence Dot ;

fragment ExponentPart
    : [eE] Sign? DigitSequence ;

fragment Sign
    : [+-] ;

DigitSequence
    : Digit+ ;

fragment HexadecimalFractionalConstant
    : HexadecimalDigitSequence? Dot HexadecimalDigitSequence | HexadecimalDigitSequence Dot ;

fragment BinaryExponentPart
    : [pP] Sign? DigitSequence ;

fragment HexadecimalDigitSequence
    : HexadecimalDigit+ ;

fragment FloatingSuffix
    : [flFL] ;

fragment CharacterConstant
    : '\'' CCharSequence '\'' | 'L\'' CCharSequence '\''| 'u\'' CCharSequence '\'' | 'U\'' CCharSequence '\''
    ;

fragment CCharSequence
    : CChar+ ;

fragment CChar
    : ~['\\\r\n] | EscapeSequence ;

fragment EscapeSequence
    : SimpleEscapeSequence | OctalEscapeSequence | HexadecimalEscapeSequence | UniversalCharacterName ;

fragment SimpleEscapeSequence
    : '\\' ['"?abfnrtv\\] ;

fragment OctalEscapeSequence
    : '\\' OctalDigit OctalDigit? OctalDigit? ;

fragment HexadecimalEscapeSequence
    : '\\x' HexadecimalDigit+ ;

StringLiteral
    : EncodingPrefix? '"' SCharSequence? '"' ;

fragment EncodingPrefix
    : 'u8' | 'u' | 'U' | 'L' ;

fragment SCharSequence
    : SChar+ ;

fragment SChar
    : ~["\\\r\n] | EscapeSequence | '\\\n' | '\\\r\n' ;

MultiLineMacro
    : '#' (~[\n]*? '\\' '\r'? '\n')+ ~ [\n]+ -> channel(HIDDEN) ;

Directive
    : '#' ~[\n]* -> channel(HIDDEN) ;

Whitespace
    : [ \t]+ -> channel(HIDDEN) ;

Newline
    : ('\r' '\n'? | '\n') -> channel(HIDDEN) ;

BlockComment
    : '/*' .*? '*/' -> channel(HIDDEN) ;

LineComment
    : '//' ~[\r\n]* -> channel(HIDDEN) ;
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
    import java.util.LinkedList;
    import java.util.Stack;
    import org.antlr.v4.runtime.*;
}


program returns [Program programRet]:
    (t = translationUnit { $programRet = $t.programRet; })? EOF ;

translationUnit returns [Program programRet]:
    { $programRet = new Program(); }
    (e = externalDeclaration
    { if ($e.declarationRet != null) $programRet.addDeclaration($e.declarationRet); })+ ;

externalDeclaration returns [Declaration declarationRet]:
    f=functionDefinition { $declarationRet = $f.functionDecRet; }
    | d=declaration { $declarationRet = $d.varDecRet; }
    | NEWLINE { $declarationRet = null; }
    ;

functionDefinition returns [FuncDec functionDecRet]:
    { $functionDecRet = new FuncDec(); }
    (a = declarationSpecifiers{$functionDecRet.setSpecifiers($a.specifiersRet);})?
    b = declarator { $functionDecRet.setDeclarator($b.declaratorRet); }
    (c = declarationList{$functionDecRet.setVarDec($c.varDecsRet);})?
    Colon
    d = compoundStatement{ $functionDecRet.setStatement($d.compoundStatementRet);}
    End
    {$functionDecRet.setLine($Colon.getLine());}
    ;

declarationList returns [List<VarDec> varDecsRet]:
    { $varDecsRet = new ArrayList<>(); }
    (d = declaration {$varDecsRet.add($d.varDecRet);})+ ;


expression returns [Expression expressionRet]:
    pri = primaryExpression {$expressionRet = $pri.expressionRet;}
    | e1 = expression LeftBracket e2 = expression RightBracket // Array indexing
    {$expressionRet = new ArrayExpression($e1.expressionRet , $e2.expressionRet , $LeftBracket.getLine());}
    | e = expression // Function call
    {
        $expressionRet = new FunctionCallExpression();
        $expressionRet.setFunction($e.expressionRet);
        $expressionRet.setLine($e.expressionRet.getLine());
    }
    LeftParen (a = argumentExpressionList {$expressionRet.setArguments($a.expressionsRet);})? RightParen
    //Unarys
    | e = expression PlusPlus // Postfix increment
    {$expressionRet = new UnaryExpression($e.expressionRet, UnaryOperator.INCREMENT, true , $PlusPlus.getLine());}
    | e = expression MinusMinus // Postfix decrement
    {$expressionRet = new UnaryExpression($e.expressionRet, UnaryOperator.DECREMENT, true , $MinusMinus.getLine());}
    | pre = prefixexpression {$expressionRet = $pre.expressionRet;}
    | c = castType {$expressionRet = $c.expressionRet;} // Cast expression
    //Binarys
    | e1 = expression // Multiplicative
    {
        $expressionRet = new BinaryExpression();
        $expressionRet.setLeftOperand($e1.expressionRet);
        $expressionRet.setLine($e1.expressionRet.getLine());
    }
    (Star {$expressionRet.setBinaryOperator(BinaryOperator.MUL);}
    | Div {$expressionRet.setBinaryOperator(BinaryOperator.DIV);}
    | Mod {$expressionRet.setBinaryOperator(BinaryOperator.MOD);})
    e2 = expression {$expressionRet.setRightOperand($e2.expressionRet);}
    | e1 = expression // Additive
    {
        $expressionRet = new BinaryExpression();
        $expressionRet.setLeftOperand($e1.expressionRet);
        $expressionRet.setLine($e1.expressionRet.getLine());
    }
      (Plus { $expressionRet.setBinaryOperator(BinaryOperator.PLUS); }
      | Minus { $expressionRet.setBinaryOperator(BinaryOperator.MINUS); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }
    | e1 = expression // Shift
    {
        $expressionRet = new BinaryExpression();
        $expressionRet.setLeftOperand($e1.expressionRet);
        $expressionRet.setLine($e1.expressionRet.getLine());
    }
      (LeftShift { $expressionRet.setBinaryOperator(BinaryOperator.LEFT_SHIFT); }
      | RightShift { $expressionRet.setBinaryOperator(BinaryOperator.RIGHT_SHIFT); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }
    | e1 = expression // Relational
    {
        $expressionRet = new BinaryExpression();
        $expressionRet.setLeftOperand($e1.expressionRet);
        $expressionRet.setLine($e1.expressionRet.getLine());
    }
      (Less { $expressionRet.setBinaryOperator(BinaryOperator.LESS_THAN); }
      | Greater { $expressionRet.setBinaryOperator(BinaryOperator.GREATER_THAN); }
      | LessEqual { $expressionRet.setBinaryOperator(BinaryOperator.LESS_EQUAL); }
      | GreaterEqual { $expressionRet.setBinaryOperator(BinaryOperator.GREATER_EQUAL); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }
    | e1 = expression // Equality
    {
        $expressionRet = new BinaryExpression();
        $expressionRet.setLeftOperand($e1.expressionRet);
        $expressionRet.setLine($e1.expressionRet.getLine());
    }
      (Equal { $expressionRet.setBinaryOperator(BinaryOperator.EQUAL); }
      | NotEqual { $expressionRet.setBinaryOperator(BinaryOperator.NOT_EQUAL); })
      e2 = expression { $expressionRet.setRightOperand($e2.expressionRet); }
    | e1 = expression And e2 = expression
    { $expressionRet = new BinaryExpression($e1.expressionRet,$e2.expressionRet,BinaryOperator.BITWISE_AND,$And.getLine()); }// Bitwise AND
    | e1 = expression And e2 = expression
    { $expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, BinaryOperator.BITWISE_AND, $And.getLine()); } // Bitwise AND
    | e1 = expression Xor e2 = expression
    { $expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, BinaryOperator.BITWISE_XOR, $Xor.getLine()); } // Bitwise XOR
    | e1 = expression Or e2 = expression
    { $expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, BinaryOperator.BITWISE_OR, $Or.getLine()); } // Bitwise OR
    | e1 = expression AndAnd e2 = expression
    { $expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, BinaryOperator.AND, $AndAnd.getLine()); } // Logical AND
    | e1 = expression OrOr e2 = expression
    { $expressionRet = new BinaryExpression($e1.expressionRet, $e2.expressionRet, BinaryOperator.OR, $OrOr.getLine()); } // Logical OR


    | e1 = expression Question e2 = expression Colon e3 = expression // Conditional operator
    {$expressionRet = new ConditionalExpression($e1.expressionRet , $e2.expressionRet , $e3.expressionRet,$Question.getLine());}

    | e1 = expression op = assignmentOperator e2 = expression // Assignment
    {$expressionRet = new BinaryExpression($e1.expressionRet,$e2.expressionRet,$op.binaryOperatorRet , $e1.expressionRet.getLine());}
    | e1 = expression // Comma operator
    {
        $expressionRet = new CommaExpression();
        $expressionRet.addExpression($e1.expressionRet);
        $expressionRet.setLine($e1.expressionRet.getLine());
    }
    (Comma e2 = expression {$expressionRet.addExpression($e2.expressionRet);})+ ;


prefixexpression returns [Expression expressionRet , List<UnaryOperator> ops = new ArrayList<>()]:
    (p=prefixOperator { $ops.add($p.operatorRet); })* (base = postfixExpression)
      {
          $expressionRet = $base.expressionRet;
          for (int i = $ops.size() - 1; i >= 0; i--) {
              UnaryExpression ue = new UnaryExpression($expressionRet , $ops.get(i) , false , $expressionRet.getLine());
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
    | op = unaryOperator c = castExpression
    {$expressionRet = new UnaryExpression($c.expressionRet, $op.operatorRet, false , $c.expressionRet.getLine());}
    | Sizeof LeftParen t = typeName RightParen
    {$expressionRet = new SizeofExpression($t.parameterRet , $Sizeof.getLine());}
    ;

primaryExpression returns [Expression expressionRet]:
    Identifier{ $expressionRet = new IdExpression($Identifier.getText() , $Identifier.getLine());}
    | Constant { $expressionRet = new ConstExpression($Constant.getText() , $Constant.getLine());}
    | {$expressionRet = new StringExpression();}
    (StringLiteral
    {
        $expressionRet.addStringLiteral($StringLiteral.getText());
        $expressionRet.setLine($StringLiteral.getLine());
    } )+
    | LeftParen expression RightParen { $expressionRet = $expression.expressionRet; }
    | LeftParen t = typeName RightParen LeftBrace i = initializerList Comma? RightBrace
    { $expressionRet = new CompoundLiteralExpression($t.parameterRet , $i.initializerListRet , $LeftBrace.getLine());}
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
  : c = castType { $expressionRet = $c.expressionRet; }
  | e = expression { $expressionRet = $e.expressionRet; }
  | DigitSequence { $expressionRet = new DigitSequenceExpression($DigitSequence.getText() , $DigitSequence.getLine());}
  ;

castType returns [Expression expressionRet]:
    LeftParen t = typeName RightParen c =castExpression
    { $expressionRet = new CastExpression($t.parameterRet , $c.expressionRet , $LeftParen.getLine()); }
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
    d = declarationSpecifiers { $varDecRet.setSpecifiers($d.specifiersRet); }
    (i = initDeclaratorList { $varDecRet.setInitDeclarators($i.initDeclaratorsRet);})? NEWLINE
    {$varDecRet.setLine($NEWLINE.getLine());}
    ;

declarationSpecifiers returns [List<Specifier> specifiersRet]
    : { $specifiersRet = new ArrayList<>(); }
      (d = declarationSpecifier { $specifiersRet.add($d.specifierRet); })+
      ;


declarationSpecifier returns [Specifier specifierRet]:
    Typedef{$specifierRet = new TypedefSpecifier($Typedef.getLine());}
    | t = typeSpecifier{$specifierRet = $t.typeRet;}
    | Const {$specifierRet = new ConstSpecifier($Const.getLine());}
    ;

initDeclaratorList returns [List<InitDeclarator> initDeclaratorsRet]:
    { $initDeclaratorsRet = new ArrayList<>(); }
    i1 = initDeclarator {$initDeclaratorsRet.add($i1.initDeclaratorRet);}
    (Comma i2 = initDeclarator {$initDeclaratorsRet.add($i2.initDeclaratorRet);})* ;

initDeclarator returns [InitDeclarator initDeclaratorRet]:
    { $initDeclaratorRet = new InitDeclarator();}
    d = declarator
    {
        $initDeclaratorRet.setDeclarator($d.declaratorRet);
        $initDeclaratorRet.setLine($d.declaratorRet.getLine());
    }
    (Assign i = initializer {$initDeclaratorRet.setInitializer($i.initializerRet);})?
    ;

typeSpecifier returns [Type typeRet]
    : Void    {$typeRet = new VoidType($Void.getLine());}
    | Char    {$typeRet = new CharType($Char.getLine());}
    | Short   {$typeRet = new ShortType($Short.getLine());}
    | Int     {$typeRet = new IntType($Int.getLine());}
    | Long    {$typeRet = new LongType($Long.getLine());}
    | Float   {$typeRet = new FloatType($Float.getLine());}
    | Double  {$typeRet = new DoubleType($Double.getLine());}
    | Signed  {$typeRet = new SignedType($Signed.getLine());}
    | Unsigned{$typeRet = new UnsignedType($Unsigned.getLine());}
    | Bool    {$typeRet = new BoolType($Bool.getLine());}
    | id = Identifier {$typeRet = new IdType($id.getText() , $id.getLine());}
    ;

specifierQualifierList returns [List<Specifier> specifiersRet]:
    { $specifiersRet = new ArrayList<>(); }
    ( t = typeSpecifier { $specifiersRet.add($t.typeRet);}
    | Const {$specifiersRet.add(new ConstSpecifier($Const.getLine()));} )
    (s = specifierQualifierList {$specifiersRet.addAll($s.specifiersRet);})? ;

declarator returns [PointerDeclarator declaratorRet]:
    { $declaratorRet = new PointerDeclarator(); }
    (p = pointer { $declaratorRet.setPointers($p.pointersRet); })?
    d = directDeclarator
    {
        $declaratorRet.setDeclarator($d.declaratorRet);
        $declaratorRet.setLine($d.declaratorRet.getLine());
    };

directDeclarator returns [Declarator declaratorRet]
    : Identifier {$declaratorRet = new IdentifierDeclarator($Identifier.getText(),$Identifier.getLine());}
    | LeftParen a = declarator RightParen { $declaratorRet = $a.declaratorRet; }
    | b = directDeclarator
    {
        $declaratorRet = new ArrayDeclarator();
        $declaratorRet.setDeclarator($b.declaratorRet);
        $declaratorRet.setLine($b.declaratorRet.getLine());
    }
      LeftBracket (c = expression { $declaratorRet.setExpression($c.expressionRet); })? RightBracket
    | d = directDeclarator
    {
        $declaratorRet = new FunctionDeclarator();
        $declaratorRet.setDeclarator($d.declaratorRet);
        $declaratorRet.setLine($d.declaratorRet.getLine());
    }
    LeftParen (f = parameterList { $declaratorRet.setParameters($f.parametersRet); }
    | (g = identifierList { $declaratorRet.setIdentifiers($g.identifiersRet); })?) RightParen ;

pointer returns [List<Pointer> pointersRet]
    : { $pointersRet = new ArrayList<Pointer>(); }
      ( (Star { $pointersRet.add(new StarPointer($Star.getLine())); } )
       (Const { $pointersRet.add(new ConstSpecifier($Const.getLine())); })? )+ ;

parameterList returns [List<ParamDec> parametersRet]
    : { $parametersRet = new ArrayList<ParamDec>(); }
      a = parameterDeclaration { $parametersRet.add($a.parameterRet); }
      (Comma b = parameterDeclaration { $parametersRet.add($b.parameterRet); })* ;

parameterDeclaration returns [ParamDec parameterRet]:
      a = declarationSpecifiers
      {
        $parameterRet = new ParamDec();
        $parameterRet.setSpecifiers($a.specifiersRet);
      }
      ( (b = declarator
      {
        $parameterRet.setDeclarator($b.declaratorRet);
        $parameterRet.setLine($b.declaratorRet.getLine());
      } )
       | (c = abstractDeclarator { $parameterRet.setDeclarator($c.declaratorRet); })?) ;

identifierList returns [List<String> identifiersRet]
    : { $identifiersRet = new ArrayList<String>(); }
      Identifier { $identifiersRet.add($Identifier.text); }
      (Comma Identifier { $identifiersRet.add($Identifier.text); })* ;

typeName returns [ParamDec parameterRet]:
    s = specifierQualifierList
    {
        $parameterRet = new ParamDec();
        $parameterRet.setSpecifiers($s.specifiersRet);
    }
    (a = abstractDeclarator {$parameterRet.setDeclarator($a.declaratorRet);})? ;

abstractDeclarator returns [Declarator declaratorRet]
    : { $declaratorRet = new PointerDeclarator(); }
      (p = pointer { $declaratorRet.setPointers($p.pointersRet); })?
      d = directAbstractDeclarator
      {
        $declaratorRet.setDeclarator($d.declaratorRet);
        $declaratorRet.setLine($d.declaratorRet.getLine());
      }
    | p = pointer
      {
         $declaratorRet = new PointerDeclarator();
         $declaratorRet.setPointers($p.pointersRet);
         //set line if it's needed
      }
    ;

directAbstractDeclarator returns [Declarator declaratorRet]:
    { $declaratorRet = new ArrayDeclarator(); }
    LeftBracket (a = expression {$declaratorRet.setExpression($a.expressionRet); $declaratorRet.setLine($a.expressionRet.getLine());})? RightBracket
    | { $declaratorRet = new FunctionDeclarator(); }
    LeftParen  ((b = abstractDeclarator {$declaratorRet.setDeclarator($b.declaratorRet) ;})
    | (c = parameterList {$declaratorRet.setParameters($c.parametersRet);})?) RightParen {$declaratorRet.setLine($RightParen.getLine());}
    | d = directAbstractDeclarator
    {
        $declaratorRet = new ArrayDeclarator();
        $declaratorRet.setDeclarator($d.declaratorRet);
    }
    LeftBracket (e = expression {$declaratorRet.setExpression($e.expressionRet);})? RightBracket
    {$declaratorRet.setLine($RightBracket.getLine());}
    | f = directAbstractDeclarator
    {
        $declaratorRet = new FunctionDeclarator();
        $declaratorRet.setDeclarator($f.declaratorRet);
    }
    LeftParen (g = parameterList {$declaratorRet.setParameters($g.parametersRet);})? RightParen
    {$declaratorRet.setLine($RightParen.getLine());}
    ;

initializer returns [Initializer initializerRet]:
    e = expression
    {
        $initializerRet = new Initializer();
        $initializerRet.setExpression($e.expressionRet);
        $initializerRet.setLine($e.expressionRet.getLine());
    }
    | LeftBrace i = initializerList Comma? RightBrace
    {
        $initializerRet = new Initializer();
        $initializerRet.setInitializerList($i.initializerListRet);
        $initializerRet.setLine($RightBrace.getLine());
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
    {$entryRet.setLine($i.initializerRet.getLine());}
    ;

designation returns [List<Designator> designatorsRet]
    : { $designatorsRet = new ArrayList<>(); }
      (d=designator { $designatorsRet.add($d.designatorRet); })+ Assign
    ;

designator returns [Designator designatorRet]
    : LeftBracket e = expression RightBracket{ $designatorRet = new ArrayDesignator($e.expressionRet , $RightBracket.getLine());}
    | Dot Identifier {$designatorRet = new FieldDesignator($Identifier.getText() , $Identifier.getLine());}
    ;

statement returns [Statement statementRet]
    : c = compoundStatement { $statementRet = $c.compoundStatementRet; }
    | e = expressionStatement { $statementRet = $e.statementRet; }
    | s = selectionStatement { $statementRet = $s.statementRet; }
    | i = iterationStatement { $statementRet = $i.statementRet; }
    | j = jumpStatement { $statementRet = $j.statementRet; };

compoundStatement returns [CompoundStatement compoundStatementRet]
    @init { Integer count = 0; }
    :
    { $compoundStatementRet = new CompoundStatement(); }
    nl = NEWLINE { $compoundStatementRet.setLine($nl.getLine());}
    ((NEWLINE* (Tab {count++;})+ b = blockItem
    {
        if ($b.varDecRet != null) {
            $compoundStatementRet.addVarDec($b.varDecRet);
            $b.varDecRet.setIndentLevel(count);
            count = 0;
        }
        else if ($b.statementRet != null) {
            $compoundStatementRet.addStatement($b.statementRet);
            $b.statementRet.setIndentLevel(count);
            count = 0;
        }
    }
    NEWLINE*)+)?
    ;

blockItem returns [Statement statementRet , VarDec varDecRet]
    : s = statement {$statementRet = $s.statementRet;}
    | d = declaration {$varDecRet = $d.varDecRet;} ;

expressionStatement returns [ExpressionStatement statementRet]:
    {$statementRet = new ExpressionStatement();}
    (e = expression {$statementRet.setExpression($e.expressionRet);})?
    NEWLINE {$statementRet.setLine($NEWLINE.getLine());}
    ;

selectionStatement returns [IfStatement statementRet]
    @init {int thenIndent = 0; int elseIndent = 0; }
    :
    { $statementRet = new IfStatement();}
    If {$statementRet.setLine($If.getLine());} LeftParen e = expression {$statementRet.setCondition($e.expressionRet);}
    RightParen Colon s1 = statement {$statementRet.setThenStatement($s1.statementRet);}
    (NEWLINE* (Tab {thenIndent++;})+ Else s2 = statement
    {$statementRet.setElseStatement($s2.statementRet); $s2.statementRet.setIndentLevel(thenIndent);}
    | NEWLINE* (Tab {elseIndent++;})+ Else Colon s3 = compoundStatement
    {$statementRet.setElseStatement($s3.compoundStatementRet);})?
    ;

iterationStatement returns [Statement statementRet]:
    While LeftParen e = expression RightParen Colon s = statement
    {$statementRet = new WhileStatement($e.expressionRet , $s.statementRet , $While.getLine());}
    | Do Colon s = statement (NEWLINE* Tab+) While LeftParen e = expression RightParen NEWLINE
    {$statementRet = new DoWhileStatement($e.expressionRet , $s.statementRet , $Do.getLine());}
    | For LeftParen f = forCondition RightParen Colon s = statement
    {$statementRet = new ForStatement($f.forConditionRet , $s.statementRet , $For.getLine());}
    ;

forCondition returns [ForCondStatement forConditionRet]:
    {$forConditionRet = new ForCondStatement();}
    (f = forDeclaration {$forConditionRet.setInitDeclaration($f.varDecRet);}
    | (e = expression { $forConditionRet.setInitExpression($e.expressionRet);})? )
    Semi (a1 = argumentExpressionList {$forConditionRet.setConditions($a1.expressionsRet);})?
    Semi (a2 = argumentExpressionList {$forConditionRet.setUpdateExpressions($a2.expressionsRet);})?
    {$forConditionRet.setLine($Semi.getLine());}
    ;

forDeclaration returns [VarDec varDecRet]:
    { $varDecRet = new VarDec(); }
    d = declarationSpecifiers { $varDecRet.setSpecifiers($d.specifiersRet);}
    (i = initDeclaratorList { $varDecRet.setInitDeclarators($i.initDeclaratorsRet);})?
    ;


jumpStatement returns [Statement statementRet]:
    ( Continue {$statementRet = new ContinueStatement();}
     | Break {$statementRet = new BreakStatement();}
     | Return {$statementRet = new ReturnStatement();}
     (e = expression {$statementRet = new ReturnStatement($e.expressionRet);})? )
     NEWLINE
     {$statementRet.setLine($NEWLINE.getLine());}
     ;

End                   : 'end'                   ;
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
LeftShift             : '<< = new ReturnsSt'                    ;
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
Tab                   : ('\t' | ('    '))       ;

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


fragment SPACES : (' ' | '\t')+ ;


NEWLINE
    : ((Tab | '//' ~[\r\n]*) | ' ')* '\r'? '\n' ;

Whitespace
    : ( [ ] ) -> skip ;

BlockComment
    : '/*' .*? '*/' -> channel(HIDDEN) ;

LineComment
    : '//' ~[\r\n]* -> channel(HIDDEN) ;
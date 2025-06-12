package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declarator.pointer.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.declarator.*;
import main.ast.nodes.specifier.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.type.*;
import main.ast.nodes.expression.initializer.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.*;
import main.symbolTable.utils.DeclaratorUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NameAnalyzer extends Visitor<Void> {
    boolean hasErrors = false;
    boolean[] typeError = new boolean[] { false };
    private SymbolTable currFunctionScope = null;

    public boolean hasError() {return (hasErrors || typeError[0]);};

    private boolean isInFunctionCallContext = false;
    private int argCount = 0;
    private List<Boolean> usedArgs;

    private static class FuncCallContext {
        private boolean isFuncCallArg = false;
        private final Deque<Expression> funcCallStack = new ArrayDeque<>();
        List<Boolean> usedArgs;
        List<Expression> argsExpression = new ArrayList<>();
        int currArg = 0;

        FuncCallContext(List<Boolean> usedArgs) {
            this.usedArgs = usedArgs;
        }
    }
    private FuncCallContext currentContext() {
        return funcCallContextStack.isEmpty() ? null : funcCallContextStack.peek();
    }
    private final Deque<FuncCallContext> funcCallContextStack = new ArrayDeque<>();


    // handle function sig for funcCalls
//    private boolean isFuncCallArg = false;
//    private List<Boolean> usedArgs = null;
//    private List<Expression> argsExpression = new ArrayList<>();
//    private final Deque<Expression> funcCallStack = new ArrayDeque<>();
//    private int currArg = 0;

    private static final List<String> BUILT_INS = List.of("printf", "scanf");

    private boolean isBuiltIn(String name) {
        return name != null && BUILT_INS.contains(name.trim());
    }


    @Override
    public Void visit(Program program) {
        SymbolTable.root = new SymbolTable(null);
        SymbolTable.push(SymbolTable.root);

        program.setSymbolTable(SymbolTable.top);

        for (Declaration declaration : program.getDeclarations()) {
            declaration.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FuncDec funcDec) {
        Declarator declarator = funcDec.getDeclarator();
        String funcName = DeclaratorUtils.extractName(declarator);
        List<Type> types = DeclaratorUtils.extractTypes(funcDec.getSpecifiers() , typeError);
        List<SymbolTableItem> params = DeclaratorUtils.extractFunctionParamItems(declarator);
        FunctionItem functionItem = null;
        try {
            functionItem = new FunctionItem(funcName , types ,params);
            SymbolTable.top.put(functionItem);
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Line:" + funcDec.getLine() + "-> function " + funcName + " already declared");
            hasErrors = true;
        }
        SymbolTable funcScope = new SymbolTable(SymbolTable.top);
        SymbolTable.push(funcScope);
        currFunctionScope = funcScope;
        funcDec.set_symbol_table(funcScope);

        if (declarator != null)
            declarator.accept(this);

        functionItem.clearParameters();
        for (SymbolTableItem item : funcScope.items.values()){
            functionItem.addParameter(item);
        }

        if (funcDec.getStatement() != null) {
            funcDec.getStatement().accept(this);
        }

        currFunctionScope = null;
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {

        SymbolTable newScope;
        if(currFunctionScope == null){
            newScope = new SymbolTable(SymbolTable.top);
        }
        else{
            newScope = currFunctionScope;
            currFunctionScope = null;
        }

        SymbolTable.push(newScope);
        compoundStatement.set_symbol_table(newScope);
        for (BlockItem item : compoundStatement.getSelfItems()) {
            item.accept(this);
        }

        SymbolTable.pop();
        return null;
    }


    @Override
    public Void visit(DoWhileStatement doWhileStatement) {
        Expression condition = doWhileStatement.getCondition();
        Statement body = doWhileStatement.getBody();
        if(condition != null) {
            condition.accept(this);
        }
        if(body != null) {
            body.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(WhileStatement whileStatement) {
        Expression condition = whileStatement.getCondition();
        Statement body = whileStatement.getBody();
        if(condition != null) {
            condition.accept(this);
        }
        if(body != null) {
            body.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForStatement forStatement) {
        ForCondStatement condition = forStatement.getCondition();
        Statement body = forStatement.getBody();
        if(condition != null) {
            condition.accept(this);
        }
        if(body != null){
            body.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ForCondStatement forCondStatement){
        if (forCondStatement.getInitDeclaration() != null)
            forCondStatement.getInitDeclaration().accept(this);

        if (forCondStatement.getInitExpression() != null)
            forCondStatement.getInitExpression().accept(this);

        if (forCondStatement.getConditions() != null) {
            for (Expression condition : forCondStatement.getConditions()) {
                condition.accept(this);
            }
        }

        if (forCondStatement.getUpdateExpressions() != null) {
            for (Expression update : forCondStatement.getUpdateExpressions()) {
                update.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(IfStatement ifStatement) {
        Expression condition = ifStatement.getCondition();
        Statement thenBody = ifStatement.getThenStatement();
        Statement elseBody = ifStatement.getElseStatement();
        if (condition != null) {
            condition.accept(this);
        }
        if (thenBody != null) {
            thenBody.accept(this);
        }
        if (elseBody != null) {
            elseBody.accept(this);
        }
        return null;
    }

    private void handleConst(VarDec varDec) {
        List<Type> baseTypes = DeclaratorUtils.extractTypes(
                varDec.getSpecifiers().subList(1, varDec.getSpecifiers().size()) , typeError
        );
        InitDeclarator declarator = varDec.getInitDeclarators().getFirst();
        Initializer initializer = declarator.getInitializer();
        String name = DeclaratorUtils.extractName(declarator.getDeclarator());
        if(name != null && initializer != null){
            try{
                SymbolTable.top.put(new ConstItem(name , baseTypes, initializer.getExpression() , varDec));
            } catch (ItemAlreadyExistsException e) {
                System.out.println( "Line:" + varDec.getLine() + "-> " + name + " already declared");
                hasErrors = true;
            }
        }
    }

    private void handleTypedef(VarDec varDec) {
        List<Type> baseTypes = DeclaratorUtils.extractTypes(
                varDec.getSpecifiers().subList(1, varDec.getSpecifiers().size() - 1) , typeError
        );
        String typedefName = DeclaratorUtils.extractVarName(varDec.getSpecifiers());
        varDec.setTypes(baseTypes);

        if (typedefName != null) {
            try {
                SymbolTable.top.put(new TypedefItem(typedefName, baseTypes , varDec));
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line:" + varDec.getLine() + "-> " + typedefName + " already declared");
                hasErrors = true;
            }
        }
    }

    private void handleVariable(VarDec varDec){
        List<InitDeclarator> declarators = varDec.getInitDeclarators();
        if (declarators != null && !declarators.isEmpty()) {
            List<Type> types = DeclaratorUtils.extractTypes(varDec.getSpecifiers() , typeError);

            varDec.setTypes(types);
            for (InitDeclarator init : declarators) {
                Declarator declarator = init.getDeclarator();
                String name = DeclaratorUtils.extractName(declarator);

                try {
                    SymbolTable.top.put(new VariableItem(name, types , varDec));
                } catch (ItemAlreadyExistsException e) {
                    System.out.println("Line:" + varDec.getLine() + "-> " + name + " already declared");
                    hasErrors = true;
                }
                if(init.getInitializer() != null)
                    init.getInitializer().accept(this);
            }
        } else {
            String s_name = DeclaratorUtils.extractVarName(varDec.getSpecifiers());
            int size = varDec.getSpecifiers().size();
            List<Type> types = (size > 0)? DeclaratorUtils.extractTypes(varDec.getSpecifiers().subList(0, size - 1) , typeError): null;
            varDec.setTypes(types);
            if (s_name != null) {
                try {
                    SymbolTable.top.put(new VariableItem(s_name, types , varDec));
                } catch (ItemAlreadyExistsException e) {
                    System.out.println("Line:" + varDec.getLine() + "-> " + s_name + " already declared");
                    hasErrors = true;
                }
            }
        }
    }

    @Override
    public Void visit(VarDec varDec) {
        if(varDec.getSpecifiers().getFirst() instanceof ConstSpecifier){
            if(varDec.getInitDeclarators() == null)
                return null;
            handleConst(varDec);
            return null;
        }

        if (varDec.getSpecifiers().getFirst() instanceof TypedefSpecifier) {
            handleTypedef(varDec);
            return null;
        }

        handleVariable(varDec);
        return null;
    }


    @Override
    public Void visit(ParamDec paramDec) {
        List<Specifier> specs = paramDec.getSpecifiers();
        int size = specs.size();
        List<Type> types = (size > 0) ? DeclaratorUtils.extractTypes(specs.subList(0, specs.size() - 1) , typeError): null;

        String name = null;

        if (paramDec.getDeclarator() != null)
            name = DeclaratorUtils.extractName(paramDec.getDeclarator());

        if (name == null)
            name = DeclaratorUtils.extractVarName(specs);

        if (name != null) {
            try {
                SymbolTable.top.put(new VariableItem(name, types , paramDec));
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line:" + paramDec.getLine() + "-> " + name + " already declared");
                hasErrors = true;
            }
        }
        return null;
    }

    @Override
    public Void visit(Declarator declarator) { return null; }

    @Override
    public Void visit(ArrayDeclarator arrayDeclarator) { return null; }

    @Override
    public Void visit(FunctionDeclarator functionDeclarator) {
        List<ParamDec> params = functionDeclarator.getParameters();

        for (ParamDec param : params) {
            param.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IdentifierDeclarator identifierDeclarator) { return null; }

    @Override
    public Void visit(InitDeclarator initDeclarator) {

        return null;
    }

    @Override
    public Void visit(PointerDeclarator pointerDeclarator) {
        if(pointerDeclarator.getDeclarator() != null)
            pointerDeclarator.getDeclarator().accept(this);
        return null;
    }

    @Override
    public Void visit(StarPointer starPointer) { return null; }

    @Override
    public Void visit(ArrayExpression arrayExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        addFunctionArg(arrayExpression);
        if (ctx != null) {
            ctx.funcCallStack.push(arrayExpression);
        }
        if (arrayExpression.getAssigned() != null)
            arrayExpression.getAssigned().accept(this);
        if (arrayExpression.getIndex() != null)
            arrayExpression.getIndex().accept(this);
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        addFunctionArg(binaryExpression);
        if (ctx != null) {
            ctx.funcCallStack.push(binaryExpression);
        }
        if (binaryExpression.getLeftOperand() != null)
            binaryExpression.getLeftOperand().accept(this);
        if (binaryExpression.getRightOperand() != null)
            binaryExpression.getRightOperand().accept(this);
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }


    @Override
    public Void visit(CastExpression castExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        addFunctionArg(castExpression);
        if (ctx != null) {
            ctx.funcCallStack.push(castExpression);
        }
        if (castExpression.getTargetType() != null)
            castExpression.getTargetType().accept(this);
        if (castExpression.getExpression() != null)
            castExpression.getExpression().accept(this);
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }

    @Override
    public Void visit(CommaExpression commaExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        if (ctx != null) {
            ctx.funcCallStack.push(commaExpression);
        }
        for (Expression expr : commaExpression.getExpressions()) {
            expr.accept(this);
        }
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }

    @Override
    public Void visit(CompoundLiteralExpression compoundLiteralExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        addFunctionArg(compoundLiteralExpression);
        if (ctx != null) {
            ctx.funcCallStack.push(compoundLiteralExpression);
        }
        if (compoundLiteralExpression.getType() != null)
            compoundLiteralExpression.getType().accept(this);
        if (compoundLiteralExpression.getInitializers() != null) {
            for (InitializerEntry entry : compoundLiteralExpression.getInitializers()) {
                entry.accept(this);
            }
        }
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }

    @Override
    public Void visit(ConditionalExpression conditionalExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        addFunctionArg(conditionalExpression);
        if (ctx != null) {
            ctx.funcCallStack.push(conditionalExpression);
        }
        if (conditionalExpression.getCondition() != null)
            conditionalExpression.getCondition().accept(this);
        if (conditionalExpression.getTrueExpression() != null)
            conditionalExpression.getTrueExpression().accept(this);
        if (conditionalExpression.getFalseExpression() != null)
            conditionalExpression.getFalseExpression().accept(this);
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }

    @Override
    public Void visit(ConstExpression constExpression) {
        addFunctionArg(constExpression);
        return null;
    }

    @Override
    public Void visit(DigitSequenceExpression digitSequenceExpression) {
        addFunctionArg(digitSequenceExpression);
        return null;
    }

    private void handleBuiltInFunctionCall(FunctionCallExpression functionCallExpression) {
        Expression functionCall = functionCallExpression.getFunction();
        for (Expression arg : functionCallExpression.getArguments()) {
            arg.accept(this);
        }
    }

    @Override
    public Void visit(FunctionCallExpression functionCallExpression) {
        Expression functionExpr = functionCallExpression.getFunction();
        Expression functionCall = functionCallExpression.getFunction();
        if(functionCall instanceof IdExpression idExpression){
            if(isBuiltIn(idExpression.getValue())) {
                for (Expression arg : functionCallExpression.getArguments()) {
                    arg.accept(this);
                }
                return null;
            }
        }
        isInFunctionCallContext = true;
        argCount = countFunctionArguments(functionCallExpression);
        functionExpr.accept(this);
        isInFunctionCallContext = false;

        FuncCallContext ctx = new FuncCallContext(usedArgs);
        funcCallContextStack.push(ctx);
        usedArgs = null;

        ctx.funcCallStack.push(functionCallExpression);
        ctx.isFuncCallArg = true;
        for (Expression arg : functionCallExpression.getArguments()) {
            arg.accept(this);
        }
        functionCallExpression.setSelfArguments(ctx.argsExpression);
        ctx.isFuncCallArg = false;
        funcCallContextStack.pop();
        if (!funcCallContextStack.isEmpty()) {
            FuncCallContext parent = funcCallContextStack.peek();
            if (parent.usedArgs != null &&
                    parent.currArg < parent.usedArgs.size() &&
                    parent.usedArgs.get(parent.currArg)) {
                parent.argsExpression.add(functionCallExpression);
            }
            parent.currArg++;
        }
        return null;
    }

    private void handleFunctionCallIdentifier(IdExpression idExpression, String name) {
        try {
            FunctionItem item =  SymbolTable.top.findFunctionByName(name , argCount);
            argCount = 0; // Reset argCount after visiting a function call
            item.setUed();
            usedArgs = item.getUsedArgs();
        } catch (ItemNotFoundException e) {
            System.out.println("Line:" + idExpression.getLine() + "-> " + name + " not declared");
            hasErrors = true;
        }
    }

    private void replaceConstValue(IdExpression idExpression , String name){
        SymbolTableItem existingItem = SymbolTable.top.findItemByName(name);
        if(existingItem instanceof ConstItem){
            Expression constValue = ((ConstItem) existingItem).getValue();
            idExpression.setReplacement(constValue);
            existingItem.setUed();
        }
    }

    private void handleVariableOrConstUsage(IdExpression idExpression, String name) {
        try {
            SymbolTableItem item = SymbolTable.top.getItem(name);
            FuncCallContext ctx = funcCallContextStack.peek();
            if (ctx != null && ctx.isFuncCallArg) {
                if (ctx.usedArgs != null && ctx.usedArgs.get(ctx.currArg)) {
                    item.setUed();
                    replaceConstValue(idExpression , name);
                    ctx.argsExpression.add(idExpression);
                }
                ctx.currArg += 1;
            }
            else {
                item.setUed();
                replaceConstValue(idExpression , name);
            }
        } catch (ItemNotFoundException e) {
            System.out.println("Line:" + idExpression.getLine() + "-> " + name + " not declared");
            hasErrors = true;
        }
    }

    @Override
    public Void visit(IdExpression idExpression) {
        String name = idExpression.getValue();
        if (isInFunctionCallContext) {
            if (name == null || isBuiltIn(name)) {
                return null;
            }
            handleFunctionCallIdentifier(idExpression, name);
            return null;
        }
        handleVariableOrConstUsage(idExpression, name);
        return null;
    }

    @Override
    public Void visit(SizeofExpression sizeofExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        addFunctionArg(sizeofExpression);
        if (ctx != null) {
            ctx.funcCallStack.push(sizeofExpression);
        }
        if (sizeofExpression.getTypeName() != null)
            sizeofExpression.getTypeName().accept(this);
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }
    @Override
    public Void visit(StringExpression stringExpression) {
        addFunctionArg(stringExpression);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        addFunctionArg(unaryExpression);
        if (ctx != null) {
            ctx.funcCallStack.push(unaryExpression);
        }
        if (unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);
        if (ctx != null) {
            ctx.funcCallStack.pop();
        }
        return null;
    }

    @Override
    public Void visit(Initializer initializer) {
        if (initializer.getExpression() != null) {
            initializer.getExpression().accept(this);
        }

        for (InitializerEntry entry : initializer.getInitializerList()) {
            entry.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(InitializerEntry initializerEntry) {
        for (Designator designator : initializerEntry.getDisignators()) {
            designator.accept(this);
        }

        if (initializerEntry.getInitializer() != null) {
            initializerEntry.getInitializer().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FieldDesignator fieldDesignator) { return null; }

    @Override
    public Void visit(ArrayDesignator arrayDesignator) {
        if (arrayDesignator.getIndex() != null)
            arrayDesignator.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(Designator designator) {
        if (designator instanceof FieldDesignator)
            designator.accept(this);
        else if (designator instanceof ArrayDesignator)
            designator.accept(this);
        return null;
    }
    @Override
    public Void visit(Specifier specifier) { return null; }

    @Override
    public Void visit(ConstSpecifier constSpecifier) { return null; }

    @Override
    public Void visit(TypedefSpecifier typedefSpecifier) {
        return null;
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        Expression expression = expressionStatement.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BreakStatement breakStatement) {
        return null;
    }

    @Override
    public Void visit(ContinueStatement continueStatement) {
        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement) {
        Expression expression = returnStatement.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        return null;
    }

    private void addFunctionArg(Expression expression) {
        FuncCallContext ctx = funcCallContextStack.peek();
        if (ctx == null)
            return;

        if (!ctx.isFuncCallArg || ctx.usedArgs == null || ctx.currArg >= ctx.usedArgs.size())
            return;

        if(ctx.funcCallStack.size() == 1
                && (ctx.funcCallStack.peek() instanceof FunctionCallExpression)){
            if(ctx.usedArgs.get(ctx.currArg)){
                ctx.argsExpression.add(expression);
            }
            ctx.currArg += 1;
        }
        else if(ctx.funcCallStack.peek() instanceof CommaExpression){
            if(ctx.usedArgs.get(ctx.currArg)){
                ctx.argsExpression.add(expression);
            }
            ctx.currArg += 1;
        }
    }


    private int countFunctionArguments(FunctionCallExpression callExpr) {
        int count = 0;
        for (Expression arg : callExpr.getArguments()) {
            count += countArgsRecursive(arg);
        }
        return count;
    }

    private int countArgsRecursive(Expression expr) {
        if (expr instanceof CommaExpression comma) {
            int sum = 0;
            for (Expression subExpr : comma.getExpressions()) {
                sum += countArgsRecursive(subExpr);
            }
            return sum;
        }
        return 1;
    }

    @Override
    public Void visit(Type type) { return null; }

    @Override
    public Void visit(BoolType boolType) { return null; }

    @Override
    public Void visit(CharType charType) { return null; }

    @Override
    public Void visit(DoubleType doubleType) { return null; }

    @Override
    public Void visit(FloatType floatType) { return null; }

    @Override
    public Void visit(IdType idType) { return null; }

    @Override
    public Void visit(IntType intType) { return null; }

    @Override
    public Void visit(LongType longType) { return null; }

    @Override
    public Void visit(ShortType shortType) { return null; }

    @Override
    public Void visit(SignedType signedType) { return null; }

    @Override
    public Void visit(UnsignedType unsignedType) { return null; }

    @Override
    public Void visit(VoidType voidType) { return null; }
}

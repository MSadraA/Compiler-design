package main.ast.nodes.expression;

import main.ast.nodes.expression.operator.UnaryOperator;

public class UnaryExpression extends Expression{
    private Expression operand;
    protected UnaryOperator unaryOperator;
    private boolean isPostfix;

    public UnaryExpression() { }
    public UnaryExpression(Expression operand, UnaryOperator unaryOperator){
        this.operand = operand;
        this.unaryOperator = unaryOperator;
    }
    public UnaryExpression(Expression operand, UnaryOperator unaryOperator, Boolean isPostfix){
        this.operand = operand;
        this.unaryOperator = unaryOperator;
        this.isPostfix = isPostfix;
    }

    public UnaryExpression(Expression operand, UnaryOperator unaryOperator, Boolean isPostfix , int line){
        this.operand = operand;
        this.unaryOperator = unaryOperator;
        this.isPostfix = isPostfix;
        this.setLine(line);
    }

    @Override
    public void setUnaryOperator(UnaryOperator unaryOperator) {
        this.unaryOperator = unaryOperator;
    }

    @Override
    public void setExpression(Expression operand) {
        this.operand = operand;
    }

    @Override
    public void setPostfix(boolean postfix) {
        isPostfix = postfix;
    }
}

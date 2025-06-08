package main.ast.nodes.expression;

import main.ast.nodes.expression.operator.BinaryOperator;
import main.visitor.IVisitor;

public class BinaryExpression extends Expression{

    private Expression leftOperand;
    private Expression rightOperand;
    private BinaryOperator binaryOperator;


    public BinaryExpression() { }
    public BinaryExpression(Expression leftOperand, Expression rightOperand,
                            BinaryOperator binaryOperator){
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.binaryOperator = binaryOperator;
    }
    public BinaryExpression(Expression leftOperand, Expression rightOperand,
                            BinaryOperator binaryOperator, int line){
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.binaryOperator = binaryOperator;
        this.setLine(line);
    }

    public Expression getLeftOperand(){
        return this.leftOperand;
    }

    public Expression getRightOperand(){
        return this.rightOperand;
    }
    
    public BinaryOperator getOperator(){
        return binaryOperator;
    }

    @Override
    public void setBinaryOperator(BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    @Override
    public void setLeftOperand(Expression leftOperand) {
        this.leftOperand = leftOperand;
    }

    @Override
    public void setRightOperand(Expression rightOperand) {
        this.rightOperand = rightOperand;
    }

    public BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }


    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

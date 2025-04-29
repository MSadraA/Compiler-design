package main.ast.nodes.statement;

import main.ast.nodes.declaration.VarDec;
import main.ast.nodes.expression.Expression;

import java.util.List;

public class ForCondStatement extends Statement{
    private VarDec initDeclaration;
    private Expression initExpression;
    private List<Expression> conditions;
    private List<Expression> updateExpressions;

    void setInitDeclaration(VarDec initDeclaration) {
        this.initDeclaration = initDeclaration;
    }

    void setInitExpression(Expression initExpression) {
        this.initExpression = initExpression;
    }

    void setConditions(List<Expression> conditions) {
        this.conditions = conditions;
    }

    void setUpdateExpressions(List<Expression> updateExpressions) {
        this.updateExpressions = updateExpressions;
    }

}

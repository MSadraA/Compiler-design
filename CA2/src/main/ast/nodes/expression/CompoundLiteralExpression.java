package main.ast.nodes.expression;

import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.expression.initializer.Initializer;
import main.ast.nodes.expression.initializer.InitializerEntry;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundLiteralExpression extends Expression {
    private ParamDec type;
    private List<InitializerEntry> initializers = new ArrayList<>();

    public List<InitializerEntry> getInitializers(){
        return initializers;
    }

    public CompoundLiteralExpression(){
    }

    public CompoundLiteralExpression(ParamDec type, List<InitializerEntry> initializers) {
        this.type = type;
        this.initializers = initializers;
    }

    public CompoundLiteralExpression(ParamDec type, List<InitializerEntry> initializers, int line) {
        this.type = type;
        this.initializers = initializers;
        this.setLine(line);
    }

    @Override
    public void setType(ParamDec type) {
        this.type = type;
    }

    @Override
    public void setInitializers(List<InitializerEntry> initializers) {
        this.initializers = initializers;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

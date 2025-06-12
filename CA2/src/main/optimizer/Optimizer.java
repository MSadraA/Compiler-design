package main.optimizer;

import main.ast.nodes.Program;

import java.util.List;

public class Optimizer {
    public void optimize(Program program) {
        new AfterReturn().visit(program);
        new NoSideEffects().visit(program);
        new UnusedVarVisitor().visit(program);
//        new SideEffectFreeVisitor().visit(program);
//        new MultipleAssignmentVisitor().visit(program);
    }
}
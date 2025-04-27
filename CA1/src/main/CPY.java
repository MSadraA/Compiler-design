package main;

import main.ast.nodes.Program;
import main.grammar.CPYLexer;
import main.grammar.CPYParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;

public class CPY {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        CPYLexer simpleLangLexer = new CPYLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        CPYParser flParser = new CPYParser(tokens);
        Program program = flParser.program().programRet;
        System.out.println();

//        TestVisitor my_visitor = new TestVisitor();
//        my_visitor.visit(program);
    }
}
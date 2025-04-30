package main;

import main.ast.nodes.Program;
import main.grammar.CPYLexer;
import main.grammar.CPYParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import main.visitor.*;
import java.io.IOException;

public class CPY {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        CPYLexer simpleLangLexer = new CPYLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        CPYParser flParser = new CPYParser(tokens);
        Program program = flParser.program().programRet;

        TestVisitor my_visitor = new TestVisitor();
        int count = my_visitor.visit(program);
        System.out.println("Number of statements: " + count);
    }
}
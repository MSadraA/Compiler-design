package main;
import main.grammar.CPYLexer;
import main.grammar.CPYParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.IOException;

public class CPY {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        CPYLexer lexer = new CPYLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CPYParser parser = new CPYParser(tokens);
        CPYParser.CompilationUnitContext tree = parser.compilationUnit();
        System.out.println(tree.toStringTree(parser));
    }
}

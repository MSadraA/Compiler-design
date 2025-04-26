package main;

import main.grammar.CPYLexer;
import main.grammar.CPYParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;

public class CPY {
    public static void main(String[] args) throws IOException {
        // ورودی فایل
        CharStream reader = CharStreams.fromFileName(args[0]);

        // ساخت لکسرو توکن
        CPYLexer lexer = new CPYLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // ساخت parser
        CPYParser parser = new CPYParser(tokens);

        // صدا زدن rule اصلی
        CPYParser.ProgramContext tree = parser.program();

        // چاپ parse tree
        System.out.println(tree.toStringTree(parser));
    }
}

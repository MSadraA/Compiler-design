import main.ast.nodes.Program;
import main.grammar.CPYLexer;
import main.grammar.CPYParser;
import main.optimizer.Optimizer;
import main.symbolTable.SymbolTable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import main.visitor.*;
import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        CPYLexer simpleLangLexer = new CPYLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        CPYParser flParser = new CPYParser(tokens);
        Program program = flParser.program().programRet;


        CpyVisitor cpyVisitor = new CpyVisitor();
        cpyVisitor.visit(program);

        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);
        if(nameAnalyzer.hasError())
            return;

        Optimizer optimizer = new Optimizer();
        optimizer.optimize(program);

        TestVisitor my_visitor = new TestVisitor();
        my_visitor.visit(program);
    }
}
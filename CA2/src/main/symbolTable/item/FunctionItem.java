package main.symbolTable.item;

import main.ast.nodes.declaration.FuncDec;
import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.type.Type;
import main.symbolTable.utils.DeclaratorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static main.symbolTable.utils.DeclaratorUtils.extractName;

public class FunctionItem extends SymbolTableItem {
    private final List<SymbolTableItem> parameters;

    public void clearParameters(){
        parameters.clear();
    }

    public void addParameter(SymbolTableItem item){
        parameters.add(item);
    }

    public FunctionItem(String name, List<Type> returnTypes, List<SymbolTableItem> parameters) {
        super(name, returnTypes);
        this.parameters = parameters;
    }

    public List<SymbolTableItem> getParameters() {
        return parameters;
    }

    @Override
    public String getKey() {
        String paramSig = parameters.stream()
                .map(item -> item.getTypes().stream()
                        .map(DeclaratorUtils::normalizeType)
                        .collect(Collectors.joining(" "))
                )
                .collect(Collectors.joining(","));
        return name + "(" + paramSig + ")";
    }

    public List<Boolean> getUsedArgs(){
        List<Boolean> tmp = new ArrayList<>();
        for (SymbolTableItem item : parameters){
            if(item.getUsed())
                tmp.add(true);
            else
                tmp.add(false);
        }
        return tmp;
    }
}

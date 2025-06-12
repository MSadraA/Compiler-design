package main.symbolTable;


import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FunctionItem;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.item.TypedefItem;
import main.symbolTable.item.VariableItem;

import java.util.*;


public class SymbolTable {

    //Start of static members

    public static SymbolTable top;
    public static SymbolTable root;
    private static Stack<SymbolTable> stack = new Stack<>();

    public static void push(SymbolTable symbolTable) {
        if (top != null)
            stack.push(top);
        top = symbolTable;
    }

    public static void pop() {
        top = stack.pop();
    }

    public SymbolTable pre;
    public Map<String, SymbolTableItem> items;

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
    }

    public static Stack<SymbolTable> getStack() {
        return stack;
    }

    boolean isNamedItem(SymbolTableItem item) {
        return item instanceof VariableItem || item instanceof TypedefItem;
    }

    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getKey()) || findTypedefByName(item.getKey()) != null)
            throw new ItemAlreadyExistsException();
        items.put(item.getKey(), item);
    }

    public SymbolTableItem getItem(String key) throws ItemNotFoundException {
        SymbolTable currentSymbolTable = this;

        while(currentSymbolTable != null) {
            SymbolTableItem symbolTableItem = currentSymbolTable.items.get(key);
            if( symbolTableItem != null )
                return symbolTableItem;
            currentSymbolTable = currentSymbolTable.pre;
        }
        throw new ItemNotFoundException();
    }

    public FunctionItem findFunctionByName(String name , int argCount) throws ItemNotFoundException{
        SymbolTable current = this;
        while (current != null) {
            for (SymbolTableItem item : current.items.values()) {
                if (item instanceof FunctionItem && item.getName().equals(name) && ((FunctionItem) item).getParameters().size() == argCount)
                    return (FunctionItem) item;
            }
            current = current.pre;
        }
        throw new ItemNotFoundException();
    }

    public TypedefItem findTypedefByName(String name) {
        SymbolTable current = this;
        while (current != null) {
            for (SymbolTableItem item : current.items.values()) {
                if (item instanceof TypedefItem && item.getName().equals(name))
                    return (TypedefItem) item;
            }
            current = current.pre;
        }
        return null;
    }

    public SymbolTableItem findItemByName(String name) {
        SymbolTable current = this;
        while (current != null) {
            SymbolTableItem item = current.items.get(name);
            if (item != null)
                return item;
            current = current.pre;
        }
        return null;
    }

    public int getItemsSize() {
        return this.items.size();
    }
}

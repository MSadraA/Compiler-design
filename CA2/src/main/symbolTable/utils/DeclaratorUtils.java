package main.symbolTable.utils;

import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.declarator.*;
import main.ast.nodes.specifier.ConstSpecifier;
import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.type.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.item.TypedefItem;
import main.symbolTable.item.VariableItem;

import java.util.ArrayList;
import java.util.List;

public class DeclaratorUtils {
    public static String extractName(Declarator declarator) {
        if (declarator instanceof IdentifierDeclarator) {
            return ((IdentifierDeclarator) declarator).getName();
        } else if (declarator instanceof PointerDeclarator) {
            return extractName(((PointerDeclarator) declarator).getDeclarator());
        } else if (declarator instanceof ArrayDeclarator) {
            return extractName(((ArrayDeclarator) declarator).getDeclarator());
        } else if (declarator instanceof FunctionDeclarator) {
            return extractName(((FunctionDeclarator) declarator).getDeclarator());
        } else {
            return "UNKNOWN";
        }
    }

    public static List<SymbolTableItem> extractFunctionParamItems(Declarator declarator) {
        List<SymbolTableItem> params = new ArrayList<>();

        if (declarator instanceof PointerDeclarator pointer)
            declarator = pointer.getDeclarator();

        if (declarator instanceof FunctionDeclarator funcDecl) {
            for (ParamDec param : funcDecl.getParameters()) {
                Declarator innerDecl = param.getDeclarator();
                List<Specifier> specs = param.getSpecifiers();

                String name = DeclaratorUtils.extractVarName(specs);
                int size = specs.size();
                List<Type> types = (size > 0) ? extractTypes(specs.subList(0, size - 1)) : null;
                if (name == null && innerDecl != null)
                    name = DeclaratorUtils.extractName(innerDecl);

                if (name != null) {
                    SymbolTableItem item = new VariableItem(name, types);
                    params.add(item);
                }
            }
        }

        return params;
    }

    public static String extractVarName(List<Specifier> specs) {
        if (specs == null || specs.isEmpty())
            return null;

        Specifier last = specs.getLast();
        if (last instanceof IdType idType)
            return idType.getName();

        return null;
    }

    public static List<Type> extractTypes(List<Specifier> specifiers) {
        List<Type> types = new ArrayList<>();
        if (specifiers == null || specifiers.isEmpty())
            return types;

        for (Specifier spec : specifiers) {
            if (spec instanceof IdType idType) {
                String alias = idType.getName();
                try {
                    TypedefItem typedefItem = (TypedefItem) SymbolTable.top.getItem(alias);
                    types.addAll(typedefItem.getTypes());
                } catch (ItemNotFoundException e) {
                    System.out.println("Line: " + spec.getLine() + " Typedef not found for alias: " + alias);
                }
            } else if (spec instanceof Type type) {
                types.add(type);
            }
        }
        return types;
    }

    public static String normalizeType(Type type) {
        return switch (type) {
            case null -> "void"; // or "unknown"
            case IntType intType -> "int";
            case CharType charType -> "char";
            case FloatType floatType -> "float";
            case DoubleType doubleType -> "double";
            case LongType longType -> "long";
            case ShortType shortType -> "short";
            case BoolType boolType -> "bool";
            case SignedType signedType -> "signed";
            case UnsignedType unsignedType -> "unsigned";
            case VoidType voidType -> "void";
            case IdType id -> id.getName(); // for user-defined types
            default -> type.getClass().getSimpleName().toLowerCase();
        };

    }

}

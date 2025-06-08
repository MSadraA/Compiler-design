package main.symbolTable.utils;

import main.ast.nodes.declaration.ParamDec;
import main.ast.nodes.declarator.*;
import main.ast.nodes.specifier.ConstSpecifier;
import main.ast.nodes.specifier.Specifier;
import main.ast.nodes.type.*;
import main.symbolTable.item.SymbolTableItem;
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
                if (name == null && innerDecl != null)
                    name = DeclaratorUtils.extractName(innerDecl);

                if (name != null) {
                    SymbolTableItem item = new VariableItem(name, extractTypes(specs));
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

        for (int i = 0; i < specifiers.size() - 1; i++) {
            Specifier spec = specifiers.get(i);
            if (spec instanceof Type type)
                types.add(type);
        }

        Specifier last = specifiers.getLast();
        if (last instanceof Type type && !(last instanceof IdType)) {
            types.add(type);
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

// Generated from /home/sadra/Documents/Codes/Compiler-design/CA1/src/main/grammar/CPY.g4 by ANTLR 4.13.2
package main.grammar;

    import java.util.ArrayList;
    import java.util.List;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.declarator.pointer.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.declarator.*;
    import main.ast.nodes.specifier.*;
    import main.ast.nodes.statement.*;
    import main.ast.nodes.type.*;
    import main.ast.nodes.expression.initializer.*;
    import main.ast.nodes.expression.operator.*;
    import java.util.LinkedList;
    import java.util.Stack;
    import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CPYParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CPYVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CPYParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CPYParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(CPYParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#externalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalDeclaration(CPYParser.ExternalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CPYParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#declarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationList(CPYParser.DeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CPYParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#prefixexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixexpression(CPYParser.PrefixexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#prefixOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOperator(CPYParser.PrefixOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(CPYParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(CPYParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExpressionList(CPYParser.ArgumentExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(CPYParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(CPYParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#castType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastType(CPYParser.CastTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(CPYParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CPYParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifiers(CPYParser.DeclarationSpecifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifier(CPYParser.DeclarationSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList(CPYParser.InitDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator(CPYParser.InitDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(CPYParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifierQualifierList(CPYParser.SpecifierQualifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(CPYParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectDeclarator(CPYParser.DirectDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(CPYParser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(CPYParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(CPYParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(CPYParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(CPYParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractDeclarator(CPYParser.AbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#directAbstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectAbstractDeclarator(CPYParser.DirectAbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(CPYParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#initializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerList(CPYParser.InitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#initializerEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerEntry(CPYParser.InitializerEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#designation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignation(CPYParser.DesignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#designator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator(CPYParser.DesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CPYParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(CPYParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(CPYParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(CPYParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(CPYParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(CPYParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition(CPYParser.ForConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration(CPYParser.ForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CPYParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(CPYParser.JumpStatementContext ctx);
}
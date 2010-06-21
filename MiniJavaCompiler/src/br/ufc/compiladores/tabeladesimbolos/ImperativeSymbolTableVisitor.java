package br.ufc.compiladores.tabeladesimbolos;

import br.ufc.compiladores.sintaxeabstrata.BooleanType;
import br.ufc.compiladores.sintaxeabstrata.ClassDeclExtends;
import br.ufc.compiladores.sintaxeabstrata.ClassDeclSimple;
import br.ufc.compiladores.sintaxeabstrata.Formal;
import br.ufc.compiladores.sintaxeabstrata.Identifier;
import br.ufc.compiladores.sintaxeabstrata.IdentifierType;
import br.ufc.compiladores.sintaxeabstrata.IntArrayType;
import br.ufc.compiladores.sintaxeabstrata.IntegerType;
import br.ufc.compiladores.sintaxeabstrata.MethodDecl;
import br.ufc.compiladores.sintaxeabstrata.Program;
import br.ufc.compiladores.sintaxeabstrata.VarDecl;
import br.ufc.compiladores.symbol.Symbol;

public class ImperativeSymbolTableVisitor implements SymbolTableVisitor {

	private SymbolTable symbolTable;

	public ImperativeSymbolTableVisitor() {
		symbolTable = new SymbolTable();
	}

	Table getSymbolTable() {
		return symbolTable;
	}

	@Override
	public Table visit(Program program) {
		return null;
	}

	@Override
	public Table visit(ClassDeclSimple classDeclSimple) {
		return null;
	}

	@Override
	public Table visit(ClassDeclExtends classDeclExtends) {
		return null;
	}

	@Override
	public VarInfo visit(VarDecl varDecl) {
		return new VarInfo(varDecl.type, Symbol.symbol(varDecl.identifier
				.toString()));
	}

	@Override
	public Table visit(MethodDecl methodDecl) {
		return null;
	}

	@Override
	public VarInfo visit(Formal formal) {
		return new VarInfo(formal.type, Symbol.symbol(formal.identifier.str));
	}

	@Override
	public Symbol visit(IntArrayType intArrayType) {
		return Symbol.symbol("int[]");
	}

	@Override
	public Symbol visit(BooleanType booleanType) {
		return Symbol.symbol("boolean");
	}

	@Override
	public Symbol visit(IntegerType intergerType) {
		return Symbol.symbol("int");
	}

	@Override
	public Symbol visit(IdentifierType identifierType) {
		return Symbol.symbol(identifierType.str);
	}

	@Override
	public Symbol visit(Identifier identifier) {
		return Symbol.symbol(identifier.str);

	}

}

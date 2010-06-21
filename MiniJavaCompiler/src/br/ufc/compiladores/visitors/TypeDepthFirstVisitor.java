package br.ufc.compiladores.visitors;

import br.ufc.compiladores.sintaxeabstrata.And;
import br.ufc.compiladores.sintaxeabstrata.ArrayAssign;
import br.ufc.compiladores.sintaxeabstrata.ArrayLength;
import br.ufc.compiladores.sintaxeabstrata.ArrayLookup;
import br.ufc.compiladores.sintaxeabstrata.Assign;
import br.ufc.compiladores.sintaxeabstrata.Block;
import br.ufc.compiladores.sintaxeabstrata.BooleanType;
import br.ufc.compiladores.sintaxeabstrata.Call;
import br.ufc.compiladores.sintaxeabstrata.ClassDeclExtends;
import br.ufc.compiladores.sintaxeabstrata.ClassDeclSimple;
import br.ufc.compiladores.sintaxeabstrata.False;
import br.ufc.compiladores.sintaxeabstrata.Formal;
import br.ufc.compiladores.sintaxeabstrata.Identifier;
import br.ufc.compiladores.sintaxeabstrata.IdentifierExp;
import br.ufc.compiladores.sintaxeabstrata.IdentifierType;
import br.ufc.compiladores.sintaxeabstrata.If;
import br.ufc.compiladores.sintaxeabstrata.IntArrayType;
import br.ufc.compiladores.sintaxeabstrata.IntegerLiteral;
import br.ufc.compiladores.sintaxeabstrata.IntegerType;
import br.ufc.compiladores.sintaxeabstrata.LessThan;
import br.ufc.compiladores.sintaxeabstrata.MainClass;
import br.ufc.compiladores.sintaxeabstrata.MethodDecl;
import br.ufc.compiladores.sintaxeabstrata.Minus;
import br.ufc.compiladores.sintaxeabstrata.NewArray;
import br.ufc.compiladores.sintaxeabstrata.NewObject;
import br.ufc.compiladores.sintaxeabstrata.Not;
import br.ufc.compiladores.sintaxeabstrata.Plus;
import br.ufc.compiladores.sintaxeabstrata.Print;
import br.ufc.compiladores.sintaxeabstrata.Program;
import br.ufc.compiladores.sintaxeabstrata.This;
import br.ufc.compiladores.sintaxeabstrata.Times;
import br.ufc.compiladores.sintaxeabstrata.True;
import br.ufc.compiladores.sintaxeabstrata.Type;
import br.ufc.compiladores.sintaxeabstrata.VarDecl;
import br.ufc.compiladores.sintaxeabstrata.While;

public class TypeDepthFirstVisitor implements TypeVisitor {

	// MainClass mainClass;
	// ClassDeclList classDeclList;
	public Type visit(Program n) {
		n.mainClass.accept(this);
		for (int i = 0; i < n.classDeclList.size(); i++) {
			n.classDeclList.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier ident1,ident2;
	// Statement statement;
	public Type visit(MainClass n) {
		n.ident1.accept(this);
		n.ident2.accept(this);
		n.statement.accept(this);
		return null;
	}

	// Identifier ident;
	// VarDeclList varDeclList;
	// MethodDeclList metDeclList;
	public Type visit(ClassDeclSimple n) {
		n.ident.accept(this);
		for (int i = 0; i < n.varDeclList.size(); i++) {
			n.varDeclList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			n.metDeclList.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier ident1, ident2;
	// VarDeclList varDeclList;
	// MethodDeclList metDeclList;
	public Type visit(ClassDeclExtends n) {
		n.ident1.accept(this);
		n.ident2.accept(this);
		for (int i = 0; i < n.varDeclList.size(); i++) {
			n.varDeclList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			n.metDeclList.elementAt(i).accept(this);
		}
		return null;
	}

	// Type type;
	// Identifier identifier;
	public Type visit(VarDecl n) {
		n.type.accept(this);
		n.identifier.accept(this);
		return null;
	}

	// Type type;
	// Identifier identifier;
	// FormalList formalList;
	// VarDeclList varDeclList;
	// StatementList statementList;
	// Exp exp;
	public Type visit(MethodDecl n) {
		n.type.accept(this);
		n.identifier.accept(this);
		for (int i = 0; i < n.formalList.size(); i++) {
			n.formalList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.varDeclList.size(); i++) {
			n.varDeclList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.statementList.size(); i++) {
			n.statementList.elementAt(i).accept(this);
		}
		n.exp.accept(this);
		return null;
	}

	// Type type;
	// Identifier identifier;
	public Type visit(Formal n) {
		n.type.accept(this);
		n.identifier.accept(this);
		return null;
	}

	public Type visit(IntArrayType n) {
		return null;
	}

	public Type visit(BooleanType n) {
		return null;
	}

	public Type visit(IntegerType n) {
		return null;
	}

	// String s;
	public Type visit(IdentifierType n) {
		return null;
	}

	// StatementList statementList;
	public Type visit(Block n) {
		for (int i = 0; i < n.statementList.size(); i++) {
			n.statementList.elementAt(i).accept(this);
		}
		return null;
	}

	// Exp exp;
	// Statement stat1,stat2;
	public Type visit(If n) {
		n.exp.accept(this);
		n.stat1.accept(this);
		n.stat2.accept(this);
		return null;
	}

	// Exp exp;
	// Statement statement;
	public Type visit(While n) {
		n.exp.accept(this);
		n.statement.accept(this);
		return null;
	}

	// Exp exp;
	public Type visit(Print n) {
		n.exp.accept(this);
		return null;
	}

	// Identifier identifier;
	// Exp exp;
	public Type visit(Assign n) {
		n.identifier.accept(this);
		n.exp.accept(this);
		return null;
	}

	// Identifier identifier;
	// Exp exp1,exp2;
	public Type visit(ArrayAssign n) {
		n.identifier.accept(this);
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp exp1,exp2;
	public Type visit(And n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp exp1,exp2;
	public Type visit(LessThan n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp exp1,exp2;
	public Type visit(Plus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp exp1,exp2;
	public Type visit(Minus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp exp1,exp2;
	public Type visit(Times n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp exp1,exp2;
	public Type visit(ArrayLookup n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp exp;
	public Type visit(ArrayLength n) {
		n.exp.accept(this);
		return null;
	}

	// Exp exp;
	// Identifier identifier;
	// ExpList expList;
	public Type visit(Call n) {
		n.exp.accept(this);
		n.identifier.accept(this);
		for (int i = 0; i < n.expList.size(); i++) {
			n.expList.elementAt(i).accept(this);
		}
		return null;
	}

	// int i;
	public Type visit(IntegerLiteral n) {
		return null;
	}

	public Type visit(True n) {
		return null;
	}

	public Type visit(False n) {
		return null;
	}

	// String s;
	public Type visit(IdentifierExp n) {
		return null;
	}

	public Type visit(This n) {
		return null;
	}

	// Exp exp;
	public Type visit(NewArray n) {
		n.exp.accept(this);
		return null;
	}

	// Identifier i;
	public Type visit(NewObject n) {
		return null;
	}

	// Exp exp;
	public Type visit(Not n) {
		n.exp.accept(this);
		return null;
	}

	// String s;
	public Type visit(Identifier n) {
		return null;
	}
}

package br.ufc.compiladores.visitors;

import br.ufc.compiladores.sintaxeabstrata.*;

public class TypeDepthFirstVisitor implements TypeVisitor {

	// MainClass m;
	// ClassDeclList cl;
	public Type visit(Program n) {
		n.mainClass.accept(this);
		for (int i = 0; i < n.classDeclList.size(); i++) {
			n.classDeclList.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier i1,i2;
	// Statement s;
	public Type visit(MainClass n) {
		n.ident1.accept(this);
		n.ident2.accept(this);
		n.statement.accept(this);
		return null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
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

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
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

	// Type t;
	// Identifier i;
	public Type visit(VarDecl n) {
		n.type.accept(this);
		n.identifier.accept(this);
		return null;
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
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

	// Type t;
	// Identifier i;
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

	// StatementList sl;
	public Type visit(Block n) {
		for (int i = 0; i < n.statementList.size(); i++) {
			n.statementList.elementAt(i).accept(this);
		}
		return null;
	}

	// Exp e;
	// Statement s1,s2;
	public Type visit(If n) {
		n.exp.accept(this);
		n.stat1.accept(this);
		n.stat2.accept(this);
		return null;
	}

	// Exp e;
	// Statement s;
	public Type visit(While n) {
		n.exp.accept(this);
		n.statement.accept(this);
		return null;
	}

	// Exp e;
	public Type visit(Print n) {
		n.exp.accept(this);
		return null;
	}

	// Identifier i;
	// Exp e;
	public Type visit(Assign n) {
		n.identifier.accept(this);
		n.exp.accept(this);
		return null;
	}

	// Identifier i;
	// Exp e1,e2;
	public Type visit(ArrayAssign n) {
		n.identifier.accept(this);
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp e1,e2;
	public Type visit(And n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp e1,e2;
	public Type visit(LessThan n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp e1,e2;
	public Type visit(Plus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp e1,e2;
	public Type visit(Minus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp e1,e2;
	public Type visit(Times n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp e1,e2;
	public Type visit(ArrayLookup n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
		return null;
	}

	// Exp e;
	public Type visit(ArrayLength n) {
		n.exp.accept(this);
		return null;
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
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

	// Exp e;
	public Type visit(NewArray n) {
		n.exp.accept(this);
		return null;
	}

	// Identifier i;
	public Type visit(NewObject n) {
		return null;
	}

	// Exp e;
	public Type visit(Not n) {
		n.e.accept(this);
		return null;
	}

	// String s;
	public Type visit(Identifier n) {
		return null;
	}
}

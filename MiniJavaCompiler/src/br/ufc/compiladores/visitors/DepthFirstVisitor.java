package br.ufc.compiladores.visitors;

import br.ufc.compiladores.sintaxeabstrata.*;

public class DepthFirstVisitor implements Visitor {

	// MainClass m;
	// ClassDeclList cl;
	public void visit(Program n) {
		n.mainClass.accept(this);
		for (int i = 0; i < n.classDeclList.size(); i++) {
			n.classDeclList.elementAt(i).accept(this);
		}
	}

	// Identifier i1,i2;
	// Statement s;
	public void visit(MainClass n) {
		n.ident1.accept(this);
		n.ident2.accept(this);
		n.statement.accept(this);
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclSimple n) {
		n.ident.accept(this);
		for (int i = 0; i < n.varDeclList.size(); i++) {
			n.varDeclList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			n.metDeclList.elementAt(i).accept(this);
		}
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclExtends n) {
		n.ident1.accept(this);
		n.ident2.accept(this);
		for (int i = 0; i < n.varDeclList.size(); i++) {
			n.varDeclList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			n.metDeclList.elementAt(i).accept(this);
		}
	}

	// Type t;
	// Identifier i;
	public void visit(VarDecl n) {
		n.type.accept(this);
		n.identifier.accept(this);
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public void visit(MethodDecl n) {
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
	}

	// Type t;
	// Identifier i;
	public void visit(Formal n) {
		n.type.accept(this);
		n.identifier.accept(this);
	}

	public void visit(IntArrayType n) {
	}

	public void visit(BooleanType n) {
	}

	public void visit(IntegerType n) {
	}

	// String s;
	public void visit(IdentifierType n) {
	}

	// StatementList sl;
	public void visit(Block n) {
		for (int i = 0; i < n.statementList.size(); i++) {
			n.statementList.elementAt(i).accept(this);
		}
	}

	// Exp e;
	// Statement s1,s2;
	public void visit(If n) {
		n.exp.accept(this);
		n.stat1.accept(this);
		n.stat2.accept(this);
	}

	// Exp e;
	// Statement s;
	public void visit(While n) {
		n.exp.accept(this);
		n.statement.accept(this);
	}

	// Exp e;
	public void visit(Print n) {
		n.exp.accept(this);
	}

	// Identifier i;
	// Exp e;
	public void visit(Assign n) {
		n.identifier.accept(this);
		n.exp.accept(this);
	}

	// Identifier i;
	// Exp e1,e2;
	public void visit(ArrayAssign n) {
		n.identifier.accept(this);
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp e1,e2;
	public void visit(And n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp e1,e2;
	public void visit(LessThan n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Plus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Minus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Times n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp e1,e2;
	public void visit(ArrayLookup n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp e;
	public void visit(ArrayLength n) {
		n.exp.accept(this);
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public void visit(Call n) {
		n.exp.accept(this);
		n.identifier.accept(this);
		for (int i = 0; i < n.expList.size(); i++) {
			n.expList.elementAt(i).accept(this);
		}
	}

	// int i;
	public void visit(IntegerLiteral n) {
	}

	public void visit(True n) {
	}

	public void visit(False n) {
	}

	// String s;
	public void visit(IdentifierExp n) {
	}

	public void visit(This n) {
	}

	// Exp e;
	public void visit(NewArray n) {
		n.exp.accept(this);
	}

	// Identifier i;
	public void visit(NewObject n) {
	}

	// Exp e;
	public void visit(Not n) {
		n.e.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
	}
}

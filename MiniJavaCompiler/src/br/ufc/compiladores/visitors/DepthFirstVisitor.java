package br.ufc.compiladores.visitors;

import java.util.Stack;

import br.ufc.compiladores.checagemdetipos.CurrentClass;
import br.ufc.compiladores.checagemdetipos.CurrentMethod;
import br.ufc.compiladores.checagemdetipos.Table;
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
import br.ufc.compiladores.sintaxeabstrata.VarDecl;
import br.ufc.compiladores.sintaxeabstrata.While;

public class DepthFirstVisitor implements Visitor {

	Stack<CurrentClass> currentClassList = new Stack<CurrentClass>();
	Stack<CurrentMethod> currentMethodList = new Stack<CurrentMethod>();
	CurrentClass currentClass = currentClassList.peek();
	CurrentMethod currentMethod = currentMethodList.peek();

	// MainClass mainClass;
	// ClassDeclList classDeclList;
	public void visit(Program n) {
		n.mainClass.accept(this);
		for (int i = 0; i < n.classDeclList.size(); i++) {
			n.classDeclList.elementAt(i).accept(this);
			Table.endScopeClass();
		}
	}

	// Identifier ident1,ident2;
	// Statement statement;
	public void visit(MainClass n) {
		n.ident1.accept(this);
		n.ident2.accept(this);
		n.statement.accept(this);
	}

	// Identifier ident;
	// VarDeclList varDeclList;
	// MethodDeclList metDeclList;
	public void visit(ClassDeclSimple n) {
		n.ident.accept(this);

		if (currentClass != null) {
			System.out.println(n.ident.str + "cannot be declared into "
					+ currentClass.getName());
		} else if (!currentClass.addClass(n.ident.str, null))
			System.out.println(n.ident.str + "is already defined in "
					+ currentClass.getName());
		else {
			currentClassList.push(new CurrentClass(n.ident.str));
			currentClass = currentClassList.peek();
			Table.beginScopeClass();
		}

		for (int i = 0; i < n.varDeclList.size(); i++) {
			n.varDeclList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			n.metDeclList.elementAt(i).accept(this);
			Table.endScopeMethod();
		}
	}

	// Identifier ident1;
	// Identifier ident2;
	// VarDeclList varDeclList;
	// MethodDeclList metDeclList;
	public void visit(ClassDeclExtends n) {
		n.ident1.accept(this);
		n.ident2.accept(this);

		if (currentClass != null) {
			System.out.println(n.ident1.str + "cannot be defined into "
					+ currentClass.getName());
		} else if (!currentClass.addClass(n.ident1.str, null))
			System.out.println(n.ident1.str + "is already defined in "
					+ currentClass.getName());
		else {
			currentClassList.push(new CurrentClass(n.ident1.str));
			currentClass = currentClassList.peek();
			Table.beginScopeClass();
		}

		for (int i = 0; i < n.varDeclList.size(); i++) {
			n.varDeclList.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			n.metDeclList.elementAt(i).accept(this);
			Table.endScopeMethod();
		}
	}

	// Type type;
	// Identifier identifier;
	public void visit(VarDecl n) {
		n.type.accept(this);
		n.identifier.accept(this);

		if (currentMethod == null) {
			if (!currentClass.addVar(n.identifier.str, n.type))
				System.out.println(n.identifier + "is already defined in "
						+ currentClass.getName());
		} else if (!currentMethod.addVar(n.identifier.str, n.type))
			System.out.println(n.identifier.str + "is already defined in "
					+ currentClass.getName() + "." + currentMethod.getName());

	}

	// Type type;
	// Identifier identifier;
	// FormalList formalList;
	// VarDeclList varDeclList;
	// StatementList statementList;
	// Exp exp;
	public void visit(MethodDecl n) {
		n.type.accept(this);
		n.identifier.accept(this);

		if (currentMethod != null) {
			System.out.println(n.identifier.str + "cannot be defined into "
					+ currentMethod.getName());
		} else if (!currentClass.addMethod(n.identifier.str, null))
			System.out.println(n.identifier.str + "is already defined in "
					+ currentClass.getName());
		else {
			currentMethodList.push(new CurrentMethod(n.identifier.str));
			currentMethod = currentMethodList.peek();
			Table.beginScopeMethod();
		}

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

	// Type type;
	// Identifier identifier;
	public void visit(Formal n) {
		n.type.accept(this);
		n.identifier.accept(this);

		if (currentMethod == null) {
			System.out.println(n.identifier + "has not been passed to "
					+ currentClass.getName());
		} else if (!currentMethod.addVar(n.identifier.str, n.type))
			System.out.println(n.identifier.str
					+ "is already defined as a parameter in "
					+ currentClass.getName() + "." + currentMethod.getName());

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

	// StatementList statementList;
	public void visit(Block n) {
		for (int i = 0; i < n.statementList.size(); i++) {
			n.statementList.elementAt(i).accept(this);
		}
	}

	// Exp exp;
	// Statement stat1,stat2;
	public void visit(If n) {
		n.exp.accept(this);
		n.stat1.accept(this);
		n.stat2.accept(this);
	}

	// Exp exp;
	// Statement statement;
	public void visit(While n) {
		n.exp.accept(this);
		n.statement.accept(this);
	}

	// Exp exp;
	public void visit(Print n) {
		n.exp.accept(this);
	}

	// Identifier identifier;
	// Exp exp;
	public void visit(Assign n) {
		n.identifier.accept(this);
		n.exp.accept(this);
	}

	// Identifier identifier;
	// Exp exp1,exp2;
	public void visit(ArrayAssign n) {
		n.identifier.accept(this);
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp exp1,exp2;
	public void visit(And n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp exp1, exp2;
	public void visit(LessThan n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp exp1,exp2;
	public void visit(Plus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp exp1,exp2;
	public void visit(Minus n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp exp1,exp2;
	public void visit(Times n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp exp1,exp2;
	public void visit(ArrayLookup n) {
		n.exp1.accept(this);
		n.exp2.accept(this);
	}

	// Exp exp;
	public void visit(ArrayLength n) {
		n.exp.accept(this);
	}

	// Exp exp;
	// Identifier identifier;
	// ExpList expList;
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

	// Exp exp;
	public void visit(NewArray n) {
		n.exp.accept(this);
	}

	// Identifier i;
	public void visit(NewObject n) {
	}

	// Exp exp;
	public void visit(Not n) {
		n.exp.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
	}
}

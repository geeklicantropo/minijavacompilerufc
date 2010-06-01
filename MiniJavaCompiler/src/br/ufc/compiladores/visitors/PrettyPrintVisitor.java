package br.ufc.compiladores.visitors;

import br.ufc.compiladores.sintaxeabstrata.*;

public class PrettyPrintVisitor implements Visitor {

	// MainClass mainClass;
	// ClassDeclList classDeclList;
	public void visit(Program n) {
		n.mainClass.accept(this);
		for (int i = 0; i < n.classDeclList.size(); i++) {
			System.out.println();
			n.classDeclList.elementAt(i).accept(this);
		}
	}

	// Identifier ident1,ident2;
	// Statement statement;
	public void visit(MainClass n) {
		System.out.print("class ");
		n.ident1.accept(this);
		System.out.println(" {");
		System.out.print("  public static void main (String [] ");
		n.ident2.accept(this);
		System.out.println(") {");
		System.out.print("    ");
		n.statement.accept(this);
		System.out.println("  }");
		System.out.println("}");
	}

	// Identifier ident;
	// VarDeclList varDeclList;
	// MethodDeclList metDeclList;
	public void visit(ClassDeclSimple n) {
		System.out.print("class ");
		n.ident.accept(this);
		System.out.println(" { ");
		for (int i = 0; i < n.varDeclList.size(); i++) {
			System.out.print("  ");
			n.varDeclList.elementAt(i).accept(this);
			if (i + 1 < n.varDeclList.size()) {
				System.out.println();
			}
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			System.out.println();
			n.metDeclList.elementAt(i).accept(this);
		}
		System.out.println();
		System.out.println("}");
	}

	// Identifier ident1;
	// Identifier ident2;
	// VarDeclList varDeclList;
	// MethodDeclList metDeclList;
	public void visit(ClassDeclExtends n) {
		System.out.print("class ");
		n.ident1.accept(this);
		System.out.println(" extends ");
		n.ident2.accept(this);
		System.out.println(" { ");
		for (int i = 0; i < n.varDeclList.size(); i++) {
			System.out.print("  ");
			n.varDeclList.elementAt(i).accept(this);
			if (i + 1 < n.varDeclList.size()) {
				System.out.println();
			}
		}
		for (int i = 0; i < n.metDeclList.size(); i++) {
			System.out.println();
			n.metDeclList.elementAt(i).accept(this);
		}
		System.out.println();
		System.out.println("}");
	}

	// Type type;
	// Identifier identifier;
	public void visit(VarDecl n) {
		n.type.accept(this);
		System.out.print(" ");
		n.identifier.accept(this);
		System.out.print(";");
	}

	// Type type;
	// Identifier identifier;
	// FormalList formalList;
	// VarDeclList varDeclList;
	// StatementList statementList;
	// Exp exp;
	public void visit(MethodDecl n) {
		System.out.print("  public ");
		n.type.accept(this);
		System.out.print(" ");
		n.identifier.accept(this);
		System.out.print(" (");
		for (int i = 0; i < n.formalList.size(); i++) {
			n.formalList.elementAt(i).accept(this);
			if (i + 1 < n.formalList.size()) {
				System.out.print(", ");
			}
		}
		System.out.println(") { ");
		for (int i = 0; i < n.varDeclList.size(); i++) {
			System.out.print("    ");
			n.varDeclList.elementAt(i).accept(this);
			System.out.println("");
		}
		for (int i = 0; i < n.statementList.size(); i++) {
			System.out.print("    ");
			n.statementList.elementAt(i).accept(this);
			if (i < n.statementList.size()) {
				System.out.println("");
			}
		}
		System.out.print("    return ");
		n.exp.accept(this);
		System.out.println(";");
		System.out.print("  }");
	}

	// Type type;
	// Identifier identifier;
	public void visit(Formal n) {
		n.type.accept(this);
		System.out.print(" ");
		n.identifier.accept(this);
	}

	public void visit(IntArrayType n) {
		System.out.print("int []");
	}

	public void visit(BooleanType n) {
		System.out.print("boolean");
	}

	public void visit(IntegerType n) {
		System.out.print("int");
	}

	// String s;
	public void visit(IdentifierType n) {
		System.out.print(n.s);
	}

	// StatementList statementList;
	public void visit(Block n) {
		System.out.println("{ ");
		for (int i = 0; i < n.statementList.size(); i++) {
			System.out.print("      ");
			n.statementList.elementAt(i).accept(this);
			System.out.println();
		}
		System.out.print("    } ");
	}

	// Exp exp;
	// Statement stat1,stat2;
	public void visit(If n) {
		System.out.print("if (");
		n.exp.accept(this);
		System.out.println(") ");
		System.out.print("    ");
		n.stat1.accept(this);
		System.out.println();
		System.out.print("    else ");
		n.stat2.accept(this);
	}

	// Exp exp;
	// Statement statement;
	public void visit(While n) {
		System.out.print("while (");
		n.exp.accept(this);
		System.out.print(") ");
		n.statement.accept(this);
	}

	// Exp exp;
	public void visit(Print n) {
		System.out.print("System.out.println(");
		n.exp.accept(this);
		System.out.print(");");
	}

	// Identifier identifier;
	// Exp exp;
	public void visit(Assign n) {
		n.identifier.accept(this);
		System.out.print(" = ");
		n.exp.accept(this);
		System.out.print(";");
	}

	// Identifier identifier;
	// Exp exp1,exp2;
	public void visit(ArrayAssign n) {
		n.identifier.accept(this);
		System.out.print("[");
		n.exp1.accept(this);
		System.out.print("] = ");
		n.exp2.accept(this);
		System.out.print(";");
	}

	// Exp exp1,exp2;
	public void visit(And n) {
		System.out.print("(");
		n.exp1.accept(this);
		System.out.print(" && ");
		n.exp2.accept(this);
		System.out.print(")");
	}

	// Exp exp1,exp2;
	public void visit(LessThan n) {
		System.out.print("(");
		n.exp1.accept(this);
		System.out.print(" < ");
		n.exp2.accept(this);
		System.out.print(")");
	}

	// Exp exp1,exp2;
	public void visit(Plus n) {
		System.out.print("(");
		n.exp1.accept(this);
		System.out.print(" + ");
		n.exp2.accept(this);
		System.out.print(")");
	}

	// Exp exp1,exp2;
	public void visit(Minus n) {
		System.out.print("(");
		n.exp1.accept(this);
		System.out.print(" - ");
		n.exp2.accept(this);
		System.out.print(")");
	}

	// Exp exp1,exp2;
	public void visit(Times n) {
		System.out.print("(");
		n.exp1.accept(this);
		System.out.print(" * ");
		n.exp2.accept(this);
		System.out.print(")");
	}

	// Exp exp1,exp2;
	public void visit(ArrayLookup n) {
		n.exp1.accept(this);
		System.out.print("[");
		n.exp2.accept(this);
		System.out.print("]");
	}

	// Exp exp;
	public void visit(ArrayLength n) {
		n.exp.accept(this);
		System.out.print(".length");
	}

	// Exp exp;
	// Identifier identifier;
	// ExpList expList;
	public void visit(Call n) {
		n.exp.accept(this);
		System.out.print(".");
		n.identifier.accept(this);
		System.out.print("(");
		for (int i = 0; i < n.expList.size(); i++) {
			n.expList.elementAt(i).accept(this);
			if (i + 1 < n.expList.size()) {
				System.out.print(", ");
			}
		}
		System.out.print(")");
	}

	// int i;
	public void visit(IntegerLiteral n) {
		System.out.print(n.i);
	}

	public void visit(True n) {
		System.out.print("true");
	}

	public void visit(False n) {
		System.out.print("false");
	}

	// String s;
	public void visit(IdentifierExp n) {
		System.out.print(n.s);
	}

	public void visit(This n) {
		System.out.print("this");
	}

	// Exp exp;
	public void visit(NewArray n) {
		System.out.print("new int [");
		n.exp.accept(this);
		System.out.print("]");
	}

	// Identifier i;
	public void visit(NewObject n) {
		System.out.print("new ");
		System.out.print(n.identifier.str);
		System.out.print("()");
	}

	// Exp e;
	public void visit(Not n) {
		System.out.print("!");
		n.exp.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
		System.out.print(n.str);
	}
}

package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.Visitor;
import br.ufc.compiladores.visitors.TypeVisitor;

public class ArrayAssign extends Statement {
	public Identifier identifier;
	public Exp exp1, exp2;

	public ArrayAssign(Identifier ai, Exp ae1, Exp ae2) {
		identifier = ai;
		exp1 = ae1;
		exp2 = ae2;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}

}

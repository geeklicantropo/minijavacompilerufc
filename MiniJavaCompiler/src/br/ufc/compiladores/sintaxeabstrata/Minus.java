package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class Minus extends Exp {
	public Exp exp1, exp2;

	public Minus(Exp ae1, Exp ae2) {
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

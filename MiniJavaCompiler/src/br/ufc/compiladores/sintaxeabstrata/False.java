package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class False extends Exp {
	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}

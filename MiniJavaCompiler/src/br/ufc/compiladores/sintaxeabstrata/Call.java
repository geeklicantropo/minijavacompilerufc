package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class Call extends Exp {
	public Exp exp;
	public Identifier identifier;
	public ExpList expList;

	public Call(Exp ae, Identifier ai, ExpList ael) {
		exp = ae;
		identifier = ai;
		expList = ael;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}

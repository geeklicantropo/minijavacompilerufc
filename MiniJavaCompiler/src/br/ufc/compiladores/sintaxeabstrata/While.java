package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.Visitor;
import br.ufc.compiladores.visitors.TypeVisitor;

public class While extends Statement {
	public Exp exp;
	public Statement statement;

	public While(Exp ae, Statement as) {
		exp = ae;
		statement = as;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}

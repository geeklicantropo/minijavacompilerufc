package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class If extends Statement {
	public Exp exp;
	public Statement stat1, stat2;

	public If(Exp ae, Statement as1, Statement as2) {
		exp = ae;
		stat1 = as1;
		stat2 = as2;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}

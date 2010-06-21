package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class MainClass {
	public Identifier ident1, ident2;
	public Statement statement;

	public MainClass(Identifier ai1, Identifier ai2, Statement as) {
		ident1 = ai1;
		ident2 = ai2;
		statement = as;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}

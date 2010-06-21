package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public abstract class ClassDecl {
	public abstract void accept(Visitor v);

	public abstract Type accept(TypeVisitor v);
}

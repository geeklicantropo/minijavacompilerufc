package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class ClassDeclSimple extends ClassDecl {
	public Identifier i;
	public VarDeclList vl;
	public MethodDeclList ml;

	public ClassDeclSimple(Identifier ai, VarDeclList avl, MethodDeclList aml) {
		i = ai;
		vl = avl;
		ml = aml;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}

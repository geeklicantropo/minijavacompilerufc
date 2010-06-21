package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class ClassDeclSimple extends ClassDecl {
	public Identifier ident;
	public VarDeclList varDeclList;
	public MethodDeclList metDeclList;

	public ClassDeclSimple(Identifier ai, VarDeclList avl, MethodDeclList aml) {
		ident = ai;
		varDeclList = avl;
		metDeclList = aml;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Type accept(TypeVisitor v) {
		return v.visit(this);
	}
}

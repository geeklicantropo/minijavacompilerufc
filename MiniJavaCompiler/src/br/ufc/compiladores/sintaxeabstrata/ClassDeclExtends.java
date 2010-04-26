package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.TypeVisitor;
import br.ufc.compiladores.visitors.Visitor;

public class ClassDeclExtends extends ClassDecl {
	public Identifier ident1;
	public Identifier ident2;
	public VarDeclList varDeclList;
	public MethodDeclList metDeclList;

	public ClassDeclExtends(Identifier ai, Identifier aj, VarDeclList avl,
			MethodDeclList aml) {
		ident1 = ai;
		ident2 = aj;
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

package br.ufc.compiladores.tipos;

public class Array extends Type {

	public Type element;

	public Array(Type element) {
		this.element = element;
	}

	public boolean coerceTo(Type t) {
		return this == t.actual();
	}
}

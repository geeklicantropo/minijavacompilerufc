package br.ufc.compiladores.tipos;

public class Nil extends Type {
	public Nil() {

	}

	public boolean coerceTo(Type type) {
		Type a = type.actual();
		return (a instanceof Record) || (a instanceof Nil);
	}

}

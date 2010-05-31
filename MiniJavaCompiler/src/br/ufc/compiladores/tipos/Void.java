package br.ufc.compiladores.tipos;

public class Void extends Type {
	public Void() {

	}

	public boolean coerceTo(Type type) {
		return type.actual() instanceof Void;
	}
}

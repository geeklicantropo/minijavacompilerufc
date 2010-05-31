package br.ufc.compiladores.tipos;

public class Int extends Type {
	public Int() {

	}

	public boolean coerceTo(Type t) {
		return t.actual() instanceof Int;
	}

}

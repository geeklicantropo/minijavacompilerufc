package br.ufc.compiladores.tipos;

public class String extends Type {

	public String() {

	}

	public boolean coerceTo(Type type) {
		return type.actual() instanceof String;
	}

}

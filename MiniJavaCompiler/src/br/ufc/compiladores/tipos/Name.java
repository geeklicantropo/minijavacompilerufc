package br.ufc.compiladores.tipos;

import br.ufc.compiladores.checagemdetipos.Symbol;

public class Name extends Type {

	public Symbol name;
	private Type binding;

	public Name(Symbol symbol) {
		this.name = symbol;
	}

	public boolean isLoop() {
		Type b = binding;
		boolean any;
		binding = null;

		if (b == null) {
			any = true;
		} else {
			if (b instanceof Name) {
				any = ((Name) b).isLoop();
			} else {
				any = false;
			}
		}
		binding = b;
		return any;
	}
}

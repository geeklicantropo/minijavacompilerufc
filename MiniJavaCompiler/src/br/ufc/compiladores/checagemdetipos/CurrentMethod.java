package br.ufc.compiladores.checagemdetipos;

import br.ufc.compiladores.sintaxeabstrata.Type;

public class CurrentMethod {

	private String name;

	public CurrentMethod(String name) {
		setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean addVar(String id, Type t) {
		Symbol symbol = Symbol.symbol(id);

		int currentScope = Table.getScopeMethod().peek();
		int index = Table.getSymbolStackMethod().search(symbol);

		if (index != -1
				&& index > (Table.getSymbolStackMethod().size() - currentScope)) {
			return Table.putMethod(symbol, t);
		}

		else {
			return false;
		}

	}
}

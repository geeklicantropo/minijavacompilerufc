package br.ufc.compiladores.checagemdetipos;

import br.ufc.compiladores.sintaxeabstrata.Type;

public class CurrentClass extends CurrentMethod {

	public CurrentClass(String name) {
		super(name);
	}

	public boolean addClass(String id, Type type) {
		Symbol symbol = Symbol.symbol(id);

		int currentScope = Table.getScopeClass().peek();
		int index = Table.getSymbolStackClass().search(symbol);

		if (index != -1
				&& index > (Table.getSymbolStackClass().size() - currentScope)) {
			return Table.putClass(symbol, type);
		} else {
			return false;
		}
	}

	public boolean addMethod(String id, Type type) {
		Symbol symbol = Symbol.symbol(id);

		int currentScope = Table.getScopeClass().peek();
		int index = Table.getSymbolStackClass().search(symbol);
		boolean b;

		if (index != -1
				&& index > (Table.getSymbolStackMethod().size() - currentScope)) {
			b = Table.putClass(symbol, type);
			Table.beginScopeMethod();
			return b;
		} else if (Table.getHashTable().get(symbol).peek() != type) {
			b = Table.putClass(symbol, type);
			Table.beginScopeMethod();
			return b;
		} else {
			return false;
		}
	}

}

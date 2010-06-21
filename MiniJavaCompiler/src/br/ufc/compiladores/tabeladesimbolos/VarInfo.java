package br.ufc.compiladores.tabeladesimbolos;

import br.ufc.compiladores.sintaxeabstrata.Type;
import br.ufc.compiladores.symbol.Symbol;

public class VarInfo {
	public Type type;
	public Symbol name;

	public VarInfo(Type t, Symbol s) {
		super();

		type = t;
		name = s;

	}

}

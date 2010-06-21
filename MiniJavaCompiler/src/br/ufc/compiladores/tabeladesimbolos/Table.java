package br.ufc.compiladores.tabeladesimbolos;

import java.util.Set;

import br.ufc.compiladores.symbol.Symbol;

public abstract class Table {
    public abstract void put(Symbol key, Object value);
    public abstract Object get(Symbol key);
    public abstract Set<Symbol> keys();
}


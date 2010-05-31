package br.ufc.compiladores.tipos;

import br.ufc.compiladores.checagemdetipos.Symbol;

public class Record extends Type {

	public Symbol fieldName;

	public Type fieldType;
	public Record tail;

	public Record(Symbol symbol, Type type, Record x) {
		this.fieldName = symbol;
		this.fieldType = type;
		this.tail = x;
	}

	public boolean coerceTo(Type type) {
		return this == type.actual();
	}
}

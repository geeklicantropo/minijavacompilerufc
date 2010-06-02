package br.ufc.compiladores.tabeladesimbolos;

public class HashT {

	final int SIZE = 256;
	Bucket table[] = new Bucket[SIZE];

	private int hash(String str) {
		int h = 0;
		for (int i = 0; i < str.length(); i++) {
			h *= 65599 + str.charAt(i);
		}

		return h;
	}

	public void insert(String str, Bucket binding) {
		int index = hash(str) % SIZE;
		table[index] = new Bucket(str, binding, table[index]);
	}

	public Object lookup(String str) {
		int index = hash(str) % SIZE;
		for (Bucket b = table[index]; b != null; b = b.next) {
			if (str.equalsIgnoreCase(b.key)) {
				return b.binding;
			}
		}
		return null;
	}

	public void pop(String str) {
		int index = hash(str) % SIZE;
		table[index] = table[index].next;
	}
}

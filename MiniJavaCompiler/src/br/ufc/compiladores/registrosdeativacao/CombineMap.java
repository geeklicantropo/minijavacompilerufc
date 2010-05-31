package br.ufc.compiladores.registrosdeativacao;

public class CombineMap implements TempMap {
	TempMap tMap1, tMap2;

	public String tempMap(Temp temp) {
		String s = tMap1.tempMap(temp);
		if (s != null)
			return s;
		return tMap2.tempMap(temp);
	}

	public CombineMap(TempMap temp1, TempMap temp2) {
		tMap1 = temp1;
		tMap2 = temp2;
	}
}

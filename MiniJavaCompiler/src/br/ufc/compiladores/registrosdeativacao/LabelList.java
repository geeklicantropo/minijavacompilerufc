package br.ufc.compiladores.registrosdeativacao;

public class LabelList {
	public Label head;
	public LabelList tail;

	public LabelList(Label h, LabelList t) {
		head = h;
		tail = t;
	}
}

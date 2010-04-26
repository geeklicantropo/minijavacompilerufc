package br.ufc.compiladores.checagemdetipos;

public class ErrorMsg {
	boolean anyErrors;

	void complain(String msg) {
		anyErrors = true;
		System.out.println(msg);
	}
}
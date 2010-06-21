package br.ufc.compiladores.util;

public class ErrorMsg {
	static boolean anyErrors;

	public static void complain(String msg) {
		anyErrors = true;
		System.out.println(msg);
	}
}
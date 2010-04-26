package br.ufc.compiladores.main;

import br.ufc.compiladores.analisadorlexico.MiniJavaParser;
import br.ufc.compiladores.analisadorlexico.ParseException;
import br.ufc.compiladores.sintaxeabstrata.Program;
import br.ufc.compiladores.visitors.PrettyPrintVisitor;

public class Main {
	public static void main(String[] args) {
		try {
			Program root = new MiniJavaParser(System.in).program();
			root.accept(new PrettyPrintVisitor());
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
	}
}

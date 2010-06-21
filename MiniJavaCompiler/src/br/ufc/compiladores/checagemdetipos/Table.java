package br.ufc.compiladores.checagemdetipos;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

import br.ufc.compiladores.symbol.Symbol;

public class Table {

	private static Hashtable<Symbol, Stack<Object>> table;
	private static Stack<Symbol> methodsSymbols;
	private static Stack<Symbol> classSymbols;
	private static Stack<Integer> scopeMethod;
	private static Stack<Integer> scopeClass;

	public Table() {
		table = new Hashtable<Symbol, Stack<Object>>();
		methodsSymbols = new Stack<Symbol>();
		classSymbols = new Stack<Symbol>();
		scopeMethod = new Stack<Integer>();
		scopeClass = new Stack<Integer>();
	}

	public static boolean putMethod(Symbol key, Object value) {
		Stack<Object> tempStack = table.get(key);

		tempStack.push(value);
		table.put(key, tempStack);
		methodsSymbols.push(key);

		return true;
	}

	public static boolean putClass(Symbol key, Object value) {
		Stack<Object> tempStack = table.get(key);

		tempStack.push(value);
		table.put(key, tempStack);
		classSymbols.push(key);

		return true;
	}

	public static Object get(Symbol key) {
		return table.get(key);
	}

	public static Hashtable<Symbol, Stack<Object>> getHashTable() {
		return table;
	}

	public static Stack<Symbol> getSymbolStackMethod() {
		return methodsSymbols;
	}

	public static Stack<Symbol> getSymbolStackClass() {
		return classSymbols;
	}

	public static Stack<Integer> getScopeMethod() {
		return scopeMethod;
	}

	public static Stack<Integer> getScopeClass() {
		return scopeClass;
	}

	public static void beginScopeMethod() {
		scopeMethod.push(methodsSymbols.size());
	}

	public static void beginScopeClass() {
		scopeClass.push(classSymbols.size());
	}

	public static void endScopeMethod() {
		while (methodsSymbols.size() > scopeMethod.peek()) {
			Stack<Object> tempStack = table
					.remove(methodsSymbols.peek());
			tempStack.pop();
			table.put(methodsSymbols.peek(), tempStack);
			methodsSymbols.pop();
		}

		scopeMethod.pop();
	}

	public static void endScopeClass() {
		while (classSymbols.size() > scopeClass.peek()) {
			Stack<Object> tempStack = table.remove(classSymbols.peek());
			tempStack.pop();
			table.put(classSymbols.peek(), tempStack);
			classSymbols.pop();
		}

		scopeClass.pop();
	}

	public static Enumeration keys() {
		return table.keys();
	}

}

package br.ufc.compiladores.tabeladesimbolos;

import br.ufc.compiladores.sintaxeabstrata.BooleanType;
import br.ufc.compiladores.sintaxeabstrata.ClassDeclExtends;
import br.ufc.compiladores.sintaxeabstrata.ClassDeclSimple;
import br.ufc.compiladores.sintaxeabstrata.Formal;
import br.ufc.compiladores.sintaxeabstrata.Identifier;
import br.ufc.compiladores.sintaxeabstrata.IdentifierType;
import br.ufc.compiladores.sintaxeabstrata.IntArrayType;
import br.ufc.compiladores.sintaxeabstrata.IntegerType;
import br.ufc.compiladores.sintaxeabstrata.MethodDecl;
import br.ufc.compiladores.sintaxeabstrata.Program;
import br.ufc.compiladores.sintaxeabstrata.VarDecl;
import br.ufc.compiladores.symbol.Symbol;

public interface SymbolTableVisitor {
    public Table visit(Program n);
    public Table visit(ClassDeclSimple n);
    public Table visit(ClassDeclExtends n);
    public VarInfo visit(VarDecl n);
    public Table visit(MethodDecl n);
    public VarInfo visit(Formal n);
    public Symbol visit(IntArrayType n);
    public Symbol visit(BooleanType n);
    public Symbol visit(IntegerType n);
    public Symbol visit(IdentifierType n);
    public Symbol visit(Identifier n);
}


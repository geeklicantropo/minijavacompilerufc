package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.Visitor;
import br.ufc.compiladores.visitors.TypeVisitor;

public class VarDecl {
  public Type type;
  public Identifier identifier;
  
  public VarDecl(Type at, Identifier ai) {
    type=at; identifier=ai;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

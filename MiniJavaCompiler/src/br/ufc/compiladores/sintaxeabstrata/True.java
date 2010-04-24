package br.ufc.compiladores.sintaxeabstrata;

import br.ufc.compiladores.visitors.Visitor;
import br.ufc.compiladores.visitors.TypeVisitor;

public class True extends Exp {
  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

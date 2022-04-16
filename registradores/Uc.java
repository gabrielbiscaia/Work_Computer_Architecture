package registradores;

import java.util.ArrayList;

public class Uc { // Unidade de controle
  public String instrucao;
  public String opcode;
  public String op1;
  public String op2;

  public void decode(ArrayList<String> palavras, int numInstrucao) {
    this.opcode = palavras.get(numInstrucao).substring(0, 4);
    this.op1 = palavras.get(numInstrucao).substring(4, 10);
    this.op2 = palavras.get(numInstrucao).substring(10, 16);
    System.out.println("OPCODE: "+this.opcode+" Operando 1: "+this.op1+" Operando 2: "+this.op2);
  }
}

package registradores;

import java.util.ArrayList;

public class Uc { // Unidade de controle
  public String instrucao;
  public ArrayList<String> opcode = new ArrayList<String>();
  public ArrayList<String> op1 = new ArrayList<String>();
  public ArrayList<String> op2 = new ArrayList<String>();

  public void decode(ArrayList<String> palavras) {
    for (int i = 0; i < palavras.size(); i++) {
      this.opcode.add(palavras.get(i).substring(0, 4));
      this.op1.add(palavras.get(i).substring(4, 10));
      this.op2.add(palavras.get(i).substring(10, 16));
      System.out.println(this.op2);
    }
  }
}

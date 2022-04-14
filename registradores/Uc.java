package registradores;

import java.util.ArrayList;

public class Uc { // Unidade de controle
  public int i;
  public int eax, ebx;
  public String instrucao;
  public ArrayList<String> opcode = new ArrayList<String>();
  public ArrayList<String> op1 = new ArrayList<String>();
  public ArrayList<String> op2 = new ArrayList<String>();

  public void lerPalavra(ArrayList<String> palavras) {
    for (int i = 0; i < palavras.size(); i++) {
      this.opcode.add(palavras.get(i).substring(0, 3));
      System.out.println(opcode);
      this.op1.add(palavras.get(i).substring(3, 9));
      this.op2.add(palavras.get(i).substring(9, 15));
    }
  }
}

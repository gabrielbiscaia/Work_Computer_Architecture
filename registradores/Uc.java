package registradores;

import java.util.ArrayList;

public class Uc { // Unidade de controle
  public ArrayList<String> instrucaoDecodada;
  public String[] opcode = new String[50];
  public String[] op1 = new String [50];
  public String[] op2 = new String[50];

  public ArrayList<String> decode(ArrayList<String> palavras, int numInstrucao) {//função para separar os operandos

    if(numInstrucao < palavras.size()){//esse if é para enquanto tiver palavra para decodificar
      //instanciando cada casa
      this.opcode[numInstrucao] = new String();
      this.op1[numInstrucao] = new String();
      this.op2[numInstrucao] = new String();
      //limpar o arrayList
      instrucaoDecodada = new ArrayList<>();
      //4 opcode, 6 primeiro operando, 6 segundo operando
      this.opcode[numInstrucao] = palavras.get(numInstrucao).substring(0, 4);
      this.op1[numInstrucao] = palavras.get(numInstrucao).substring(4, 10);
      this.op2[numInstrucao] = palavras.get(numInstrucao).substring(10, 16);
      //0 = opcode, 1 = op1, 2 = op2
      instrucaoDecodada.add(0, this.opcode[numInstrucao]);
      instrucaoDecodada.add(1, this.op1[numInstrucao]);
      instrucaoDecodada.add(2, this.op2[numInstrucao]);
      return instrucaoDecodada;
    }else{
      //limpar o arrayList para dar return null
      instrucaoDecodada = new ArrayList<>();
      return instrucaoDecodada;
    }
  }
}

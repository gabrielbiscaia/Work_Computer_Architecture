import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import registradores.*;

public class Cpu {
    public int numInstrucao;
    public Acc acc = new Acc();
    public Ir ir = new Ir();
    public Mar mar = new Mar();
    public Mbr mbr = new Mbr();
    public Overflow of = new Overflow();
    public Pc pc = new Pc();
    public Uc uc = new Uc();
    public Ula ula = new Ula();
    public ArrayList<String> palavras = new ArrayList<String>();
    
    public void cicloDeBuscaExecucao(){ //buscar -> decodificar -> executar
        //começo busca
        lerMemoria();
        for(this.numInstrucao = 0; this.numInstrucao < palavras.size(); this.numInstrucao++){ //enquanto tiver palavra para ler na memória
            pc.enderecoInstrucao = this.numInstrucao;
            mar.enderecoInstrucao = pc.enderecoInstrucao;
            mbr.instrucao = palavras.get(this.numInstrucao);
            ir.instrucao = mbr.instrucao;
            //fim busca começo decodificação
            uc.decode(palavras, pc.enderecoInstrucao);//função para separar os operandos
            ula.realizaOperac(uc.op1, uc.op2, uc.opcode);
        }
        //     if(opcode != null){
        //     mar.enderecoInstrucao = operação desejada pelo UC
        //     mbr.dado = dado apontado pelo mar.enderecoInstrucao
        //     acc.dado = mbr.dado
        //     }
        //     chama o a ULA para fazer a operação
        //     encerra o ciclo de busca decoficação e instrução
        // }
    }

    public ArrayList<String> lerMemoria() { // 4 opcode, 6 primeiro operando, 6 segundo operando
        try {
            Scanner sc = new Scanner(new File("C:\\Faculdade\\AOC\\Trab1AOC\\memoria.txt"));
            while (sc.hasNextLine()) {
                palavras.add(sc.nextLine().trim());
            }
            sc.close();
        } catch (Exception error) {
            System.out.println("Erro: " + error);
        }
        return palavras;
    }

    public int converteOperandoComplemento2(String operando) {
        int res;
        String opF = new String(); // Strings são imutaveis em java, é necessario ter um mediador
        for (int i = 5; i >= 0; i--) {
            opF = operando.charAt(i) + opF;
            if (operando.charAt(i) == '1') {
                for (int j = i - 1; j >= 0; j--) {
                    if (operando.charAt(j) == '1') {
                        opF = '0' + opF;
                    }
                    if (operando.charAt(j) == '0') {
                        opF = '1' + opF;
                    }
                }
                break;
            }
        }
        // if (operando.charAt(0) == 1) {
        //     opF = opF + '-';
        // } else if (operando.charAt(0) == 0) {
        //     opF = opF + '+';
        // }
        // oper2 = Integer.parseInt(opF);
        res = Integer.parseInt(opF, 2);
        return res;
    }

}

// for (int i = 0; i < palavra.size(); i++) {

// System.out.println(palavra.get(i));
// }
// int a = 35;
// String b = Integer.toBinaryString(a);
// return b;

// if (opcode.charAt(0) == '0') {
// opc = opc + 4;
// }

// if (opcode.charAt(1) == '1') {
// opc = opc + 3;
// }

// if (opcode.charAt(2) == '1') {
// opc = opc + 2;
// }

// if (opcode.charAt(3) == '1') {
// opc = opc + 1;
// }

// public String converteOperando(String operando) {
// int valor = 0;
// char sinal;
// String valorS;
// String sinalF = new String();
// String res;

// if (operando.charAt(0) == '1') {
// sinal = '-';
// sinalF = String.valueOf(sinal);
// }

// if (operando.charAt(0) == '0') {
// sinal = '+';
// sinalF = String.valueOf(sinal);
// }

// if (operando.charAt(1) == '1') {
// valor = valor + 16;
// }

// if (operando.charAt(2) == '1') {
// valor = valor + 8;
// }

// if (operando.charAt(3) == '1') {
// valor = valor + 4;
// }

// if (operando.charAt(4) == '1') {
// valor = valor + 2;
// }

// if (operando.charAt(5) == '1') {
// valor = valor + 1;
// }
// valorS = Integer.toString(valor);
// res = sinalF.concat(valorS);
// return res;


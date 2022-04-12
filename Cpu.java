import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import registradores.*;

public class Cpu {
    Acc acc = new Acc();
    Ir ir = new Ir();
    Mar mar = new Mar();
    Mbr mbr = new Mbr();
    Overflow of = new Overflow();
    Pc pc = new Pc();
    Uc uc = new Uc();
    Ula ula = new Ula();
    ArrayList<String> palavras = new ArrayList<String>();

    public ArrayList<String> lerPalavra() {
        try {
            Scanner sc = new Scanner(new File("G:\\Meu Drive\\4 semestre\\Arq\\trab01\\memoria.txt"));
            while (sc.hasNextLine()) {
                palavras.add(sc.nextLine().trim());
            }

            sc.close();
        } catch (Exception error) {
            System.out.println("Erro: " + error);
        }
        return palavras;
    }

    public int convertOperando(String operando) {
        int oper=0;

        oper = Integer.parseInt(operando, 2);
        return oper;
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

    public int convertOpcode(String opcode) {
        int opc = 0;

        opc = Integer.parseInt(opcode, 2);
        return opc;

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
// }
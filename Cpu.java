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

    public String converteOperando(String operando) {
        int valor = 0;
        char sinal;
        String valorS;
        String sinalF;

        if (operando.charAt(0) == '1') {
            sinal = '-';
            sinalF = String.valueOf(sinal);
        }

        if (operando.charAt(0) == '0') {
            sinal = '+';
            sinalF = String.valueOf(sinal);
        }

        if (operando.charAt(1) == '1') {
            valor = valor + 16;
        }

        if (operando.charAt(2) == '1') {
            valor = valor + 8;
        }

        if (operando.charAt(3) == '1') {
            valor = valor + 4;
        }

        if (operando.charAt(4) == '1') {
            valor = valor + 2;
        }

        if (operando.charAt(5) == '1') {
            valor = valor + 1;
        }
        valorS = Integer.toString(valor);
        return valorS;

        // valorS = String.parseInt(operando, 2);
    }

    public String convertOpcode(String opcode) {
        int opc = 0;
        String opcS;

        if (opcode.charAt(0) == '0') {
            opc = opc + 4;
        }

        if (opcode.charAt(1) == '1') {
            opc = opc + 3;
        }

        if (opcode.charAt(2) == '1') {
            opc = opc + 2;
        }

        if (opcode.charAt(3) == '1') {
            opc = opc + 1;
        }

        opcS = Integer.toString(opc);
        return opcS;
    }
}

// for (int i = 0; i < palavra.size(); i++) {

// System.out.println(palavra.get(i));
// }
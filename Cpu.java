import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import registradores.*;

public class Cpu {
    public int numInstrucao = 1;
    public Acc acc = new Acc();
    public Ir ir = new Ir();
    public Mar mar = new Mar();
    public Mbr mbr = new Mbr();
    public Overflow of = new Overflow();
    public Pc pc = new Pc();
    public Uc uc = new Uc();
    public Ula ula = new Ula();
    public ArrayList<String> palavras = new ArrayList<String>();

    public void cicloDeBuscaExecucao(){ //carregar a palavra -> decodificar -> executar
        // while(FileReader("memoria.txt") =! null){ //enquanto tiver palavra para ler
        //     pc.enderecoInstrucao = numInstrucao;
        //     mar.enderecoInstrucao = pc.enderecoInstrucao;
        //     ler a "numInstrucao" linha da memoria.txt
        //     mbr.instrucao = Buffer da linha lida
        //     ir.instrucao = mbr.instrucao;
        //     aqui termina o ciclo de busca e começa o de decodificação
        //     numInstrucao++;
        //     uc.eax = ir.instrucao;
        //     if(uc.eax == instrucao){
        //     mar.enderecoInstrucao = operação desejada pelo UC
        //     mbr.dado = dado apontado pelo mar.enderecoInstrucao
        //     acc.dado = mbr.dado
        //     }
        //     chama o a ULA para fazer a operação
        //     encerra o ciclo de busca decoficação e instrução
        // }
    }

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
        String sinalF; //esta em amarelo pois todos "sinalF" estão dentro de "if"

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
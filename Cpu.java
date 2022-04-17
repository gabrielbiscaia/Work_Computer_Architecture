import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
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
        lerMemoria1();
        for(this.numInstrucao = 0; this.numInstrucao < palavras.size(); this.numInstrucao++){//enquanto tiver palavra para ler na memória
            //começo busca
            pc.enderecoInstrucao = this.numInstrucao;
            mar.enderecoInstrucao = pc.enderecoInstrucao;
            mbr.instrucao = palavras.get(this.numInstrucao);
            ir.instrucao = mbr.instrucao;
            //fim busca começo decodificação
            uc.decode(palavras, pc.enderecoInstrucao);
            //fim decodificação começo execução
            acc.dado = ula.realizaOperac(uc.op1, uc.op2, uc.opcode);
            mbr.dado = acc.dado;
            escreveMemoria2(mbr.dado);
            //fim execução
        }
    }

    public ArrayList<String> lerMemoria1() {
        try {
            Scanner sc = new Scanner(new File("C:\\Faculdade\\AOC\\Trab1AOC\\memoria1.txt"));
            while (sc.hasNextLine()) {
                palavras.add(sc.nextLine().trim());
            }
            sc.close();
        } catch (Exception error) {
            System.out.println("Erro: " + error);
        }
        return palavras;
    }

    public void escreveMemoria2(String dado){
        try{
            FileWriter escritor  = new FileWriter("memoria2.txt");
            escritor.write(dado);
            escritor.close();
            System.out.println("Dado armazenado na 'memoria2' com sucesso!");
        }catch (Exception error){
            System.out.println("Erro: "+error);
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import registradores.*;

public class Cpu {
    public int clock;
    public Acc acc = new Acc();
    public Ir ir = new Ir();
    public Mar mar = new Mar();
    public Mbr mbr = new Mbr();
    public Overflow of = new Overflow();
    public Pc pc = new Pc();
    public Uc uc = new Uc();
    public Ula ula = new Ula();
    public ArrayList<String> palavras = new ArrayList<String>();
    
    public void cicloDeBuscaExecucao() throws InterruptedException{ //buscar -> decodificar -> executar
        lerMemoria1();
        pipeline();
    }

    public String buscarInstrucao(int numInstrucao){
        pc.enderecoInstrucao = numInstrucao;
        mar.enderecoInstrucao = pc.enderecoInstrucao;
        mbr.instrucao = palavras.get(numInstrucao);
        ir.instrucao = mbr.instrucao;

        return ir.instrucao;
    }

    public void executarInstrucao(int numInstrucao){
        if(numInstrucao < palavras.size()){
            acc.dado = ula.realizaOperac(uc.op1[numInstrucao], uc.op2[numInstrucao], uc.opcode[numInstrucao], numInstrucao);
            System.out.println(acc.dado); //resultado
            mbr.dado = acc.dado;
        }
        
    }

    public void pipeline() throws InterruptedException{
        String fi; //Buscar instrução
        ArrayList<String> di; //Decodar instrução
        //int co; //Calcular operandos
        //int fo; //Buscar operação
        //String ei; //executar instrução // não precisa da variavel
        String wo; //escrever resultado
        for(this.clock = 0; this.clock < (palavras.size()+3); this.clock++){ //palavras.size()+3 pois depois que acabar a busca ele ainda roda 3 vezes
            System.out.println("===== Clock "+this.clock+" =====");

            //busca
            if(clock < palavras.size()){ //para ele ler apenas o número de palavras, já que o programa após ler o numero de palavras vai rodar mais 3 vezes para terminar todos processos.
                fi = buscarInstrucao(clock);
                System.out.println("FI = "+fi);
            }else{
                System.out.println("FI = Vazio");
            }

            //decode
            if((clock-1) >= 0){ //se a instrução for negativa não executa e retorna "Vazio"
                di = uc.decode(palavras, (clock -1));
                if(di.size() == 0){ //esse if é que  ele retorna null
                    System.out.println("DI = Vazio");
                }else{ //caso tenha instrução ele retorna ela quebradinha
                    System.out.println("DI = "+di);
                }
            }else{
                System.out.println("DI = Vazio");
            }
            
            //execução da instrução
            if(((clock-2) >= 0) && ((clock-2 < palavras.size()))){ //se a instrução for negativa ou caso a instrução seja vazia não executa e retorna "Vazio"
                System.out.println("EI = ");
                executarInstrucao(clock-2);
            }else{
                System.out.println("EI = Vazio");
            }

            //escrever resultado na memoria
            if((clock-3) >= 0){ //se a instrução for negativa não executa e retorna "Vazio"
                wo = escreveMemoria2(clock-3);
                System.out.println("WO = "+wo);
            }else{
                System.out.println("WO = Vazio");
            }

            TimeUnit.MILLISECONDS.sleep(3000);
        }
    }

    public ArrayList<String> lerMemoria1() {
        try {
            Scanner sc = new Scanner(new File("C:\\Faculdade\\AOC\\Trab2AOC\\memoria1.txt"));
            while (sc.hasNextLine()) {
                palavras.add(sc.nextLine().trim());
            }
            sc.close();
        } catch (Exception error) {
            System.out.println("Erro: " + error);
        }
        return palavras;
    }

    public String escreveMemoria2(int numInstrucao){
        try{
            PrintWriter escritor  = new PrintWriter(new FileWriter("memoria2.txt", true));
            escritor.append(ula.resultados[numInstrucao] +"\n");
            escritor.close();
            return ula.resultados[numInstrucao];
        }catch (Exception error){
            System.out.println("Erro: "+error);
            return "Erro ao escrever na memoria";
        }
    }
}
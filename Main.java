import registradores.*;
public class Main {
    public static void main(String[] args) {
        Cpu cpu = new Cpu();
        Uc uc = new Uc();
        Ula ula = new Ula();
        // cpu.lerPalavra();
        // System.out.println(cpu.converteOperando("111100"));
        // uc.lerPalavra(cpu.lerMemoria());
        System.out.println(ula.realizaOperac("111111","000010","0001"));
        System.out.println(ula.realizaOperac("000100","000011","0010"));
        System.out.println(ula.realizaOperac("000100","001110","0011"));

        
    }
}

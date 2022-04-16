import registradores.*;
public class Main {
    public static void main(String[] args) {
        Cpu cpu = new Cpu();
        Uc uc = new Uc();
        // cpu.lerPalavra();
        // System.out.println(cpu.converteOperando("111100"));
        // System.out.print(cpu.convertOpcode("1110"));
        System.out.println(cpu.lerMemoria());
        
        
    }
}

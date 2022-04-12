public class Main {
    public static void main(String[] args) {
        Cpu cpu = new Cpu();
        // cpu.lerPalavra();
        System.out.println(cpu.convertOperando("100111"));
        System.out.println(cpu.convertOperando("111010"));
        // System.out.println(cpu.converteOperandoComplemento2("111010"));
        //negativo(soma e sub) chamar c2 else chamar normal
        String teste = Integer.toBinaryString(-6);
        System.out.println(teste);
        // System.out.print(cpu.convertOpcode("1110"));
        // System.out.println(cpu.lerPalavra());
    }
}

package registradores;

public class Ula { // Unidade lógica aritmética
    public String res = new String();
    public Overflow ov = new Overflow();
    public boolean vai_um = false;

    public String realizaOperac(String eax, String ebx, String opcode) {
        this.vai_um = false;
        switch (opcode) {
            case "0001":
                System.out.println("\nRealizando uma Soma:");
                eax = converteOperandoComplemento2(eax);
                ebx = converteOperandoComplemento2(ebx);
                System.out.println(eax);
                System.out.println(ebx);
                System.out.println("----------");
                this.res = somaBinaria(eax, ebx, false);
                return this.res;

            case "0010":
                System.out.println("\nRealizando uma subtração:");
                eax = converteOperandoComplemento2(eax);
                ebx = converteOperandoComplemento2(ebx);
                System.out.println(eax);
                System.out.println(ebx);
                System.out.println("----------");
                this.res = subBinaria(eax, ebx);
                return this.res;

            case "0011":
                System.out.println("\nRealizando uma multiplicação:");
                System.out.println(eax + " (" + Integer.parseInt(eax, 2) + ")" + " X");
                System.out.println(ebx + " (" + Integer.parseInt(ebx, 2) + ")");
                System.out.println("----------");
                this.res = multBinaria(eax, ebx);
                return this.res;

            case "0100":
                System.out.println("\nRealizando uma divisão:");
                System.out.println(eax + " (" + Integer.parseInt(eax, 2) + ")" + " /");
                System.out.println(ebx + " (" + Integer.parseInt(ebx, 2) + ")");
                System.out.println("----------");
                this.res = divisaoBinaria(eax, ebx);
                return this.res;

            default:
                System.out.println("**Instrução inválida**");

        }
        return this.res;
    }

    public String somaBinaria(String eax, String ebx, boolean mult) {
        this.res = "";
        if (eax.length() != ebx.length()) {
            do {
                eax = '0' + eax;
            } while (eax.length() < ebx.length());
        }

        for (int i = eax.length() - 1; i >= 0; i--) {
            if (!this.vai_um) {
                if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                    this.res = '1' + this.res;
                }

                else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                    this.res = '1' + this.res;
                }

                else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                    this.res = '0' + this.res;
                }

                else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                    this.res = '0' + this.res;
                    this.vai_um = true;
                }
            } else {
                if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                    this.res = '0' + this.res;
                } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                    this.res = '0' + this.res;
                } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                    this.res = '1' + this.res;
                    this.vai_um = false;
                } else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                    this.res = '1' + this.res;
                }
            }
            if (i == 0 && vai_um == true) {
                this.res = '1' + this.res;
                vai_um = false;
            }
        }
        if (res.length() > eax.length()&& mult == false)
            this.ov.sinalizaOverflow();
        return this.res;
    }

    public String subBinaria(String eax, String ebx) {
        this.res = "";
        for (int i = eax.length() - 1; i >= 0; i--) {
            if (!this.vai_um) {
                if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                    this.res = '1' + this.res;
                }

                else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                    this.res = '1' + this.res;
                    this.vai_um = true;
                }

                else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                    this.res = '0' + this.res;
                }

                else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                    this.res = '0' + this.res;
                }
            }

            else {
                if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                    this.res = '0' + this.res;
                    this.vai_um = false;
                } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                    this.res = '0' + this.res;
                } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                    this.res = '1' + this.res;
                } else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                    this.res = '1' + this.res;
                }
            }
        }
        return this.res;
    }

    public String multBinaria(String eax, String ebx) {
        int count = 0; // serve para adicionar 0's no final de cada numero
        int comparador = eax.length();
        String aux = "000000";
        for (int i = 5; i >= 0; i--) { // verifica cada posição
            if (ebx.charAt(i) == '1') {
                for (int j = 0; j < count; j++) { // adiciona 0's em eax
                    eax = eax + '0';
                }
                aux = somaBinaria(aux, eax, true); // chama os pares para soma
                count = 0;
            }
            count = count + 1;

        }
        if (res.length() > comparador)
            this.ov.sinalizaOverflow();
        return aux;
    }

    public String divisaoBinaria(String eax, String ebx) {
        int a = Integer.parseInt(eax, 2);
        int b = Integer.parseInt(ebx, 2);
        int c = a / b;
        this.res = Integer.toBinaryString(c);
        while (this.res.length() < eax.length()) {
            this.res = '0' + this.res;
        }
        return this.res;
    }

    public String converteOperandoComplemento2(String operando) {
        String opF = new String();
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
        return opF;
    }

}
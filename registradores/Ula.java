package registradores;

import java.util.ArrayList;

public class Ula { // Unidade lógica aritmética
    public String realizaOperac(String eax, String ebx, String opcode) {
        String res = new String();
        Overflow ov = new Overflow();
        boolean vai_um = false;
        ArrayList<String> aux_mult = new ArrayList<String>();
        switch (opcode) {
            case "0001":
            System.out.println("\nRealizando uma Soma.");
            System.out.println(eax+" +");
            System.out.println(ebx);
            System.out.println("-------");
                for (int i = 5; i >= 0; i--) {

                    if (!vai_um) {
                        if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                            res = '1' + res;
                        }

                        else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                            res = '1' + res;
                        }

                        else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                            res = '0' + res;
                        }

                        else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                            res = '0' + res;
                            vai_um = true;
                        }
                    } else {
                        if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                            res = '0' + res;
                        } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                            res = '0' + res;
                        } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                            res = '1' + res;
                            vai_um = false;
                        } else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                            res = '1' + res;
                        }
                    }
                    if (i == 0 && vai_um == true) {
                        ov.sinalizaOverflow();
                        res = '1' + res;
                    }
                }
                break;

            case "0010":
            System.out.println("\nRealizando uma subtração:");
            System.out.println(eax+" -");
            System.out.println(ebx);
            System.out.println("-------");
                for (int i = 5; i >= 0; i--) {
                    if (!vai_um) {
                        if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                            res = '1' + res;
                        }

                        else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                            res = '1' + res;
                            vai_um = true;
                        }

                        else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                            res = '0' + res;
                        }

                        else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                            res = '0' + res;
                        }
                    }

                    else {
                        if (eax.charAt(i) == '1' && ebx.charAt(i) == '0') {
                            res = '0' + res;
                            vai_um = false;
                        } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '1') {
                            res = '0' + res;
                        } else if (eax.charAt(i) == '0' && ebx.charAt(i) == '0') {
                            res = '1' + res;
                        } else if (eax.charAt(i) == '1' && ebx.charAt(i) == '1') {
                            res = '1' + res;
                        }
                    }
                }
                break;

            case "0011":
            System.out.println("\nRealizando uma Multiplicação:");
            System.out.println(eax +" x");
            System.out.println(ebx);
                for (int i = 5; i >=0; i--) {
                    if (ebx.charAt(i) == '0') {
                        aux_mult.add("000000");
                    } 
                    else {
                        aux_mult.add(eax);
                    }
                }
                for (int j = 0; j<6; j++){
                    
                }

                break;

            case "0100":
                break;

        }
        return res;
    }
}

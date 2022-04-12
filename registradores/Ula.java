package registradores;

public class Ula {
    public int realizaOperac(int eax, int ebx, String opcode) {
        switch (opcode) {
            case "sub":
                return eax - ebx;
            case "mult":
                return eax * ebx;
            case "div":
                return eax / ebx;
            case "adic":
                return eax + ebx;
            default:
                return eax + ebx;
        }
    }
}

//usar complemento de dois

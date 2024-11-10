public class ControladorDeLetrasJaDigitadas implements Cloneable {
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas() {
        this.letrasJaDigitadas = ""; 
    }

    public boolean isJaDigitada(char letra) {
        return letrasJaDigitadas.indexOf(letra) != -1;
    }

    public void registre(char letra) throws Exception {
        if (isJaDigitada(letra)) {
            throw new Exception("Letra já digitada: " + letra);
        }
        letrasJaDigitadas += letra; 
    }

    public String toString() {
        return String.join(",", letrasJaDigitadas.split(""));
    }

    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj==null) return false;
        if (!(obj.getClass()==this.getClass())) return false;

        ControladorDeLetrasJaDigitadas Cl = (ControladorDeLetrasJaDigitadas) obj;

        if (Cl.letrasJaDigitadas != this.letrasJaDigitadas) return false;

        return true;
    }

    public int hashCode() {
        int ret = 1;
        ret = ret*2 + ((String)this.letrasJaDigitadas).hashCode();

        if (ret<0) ret=-ret;

        return ret;
    }

    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas) throws Exception {
        if (controladorDeLetrasJaDigitadas == null) {
            throw new Exception("Objeto nulo fornecido para cópia.");
        }
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone() {
        try {
            return new ControladorDeLetrasJaDigitadas(this);
        } catch (Exception e) {
            return null; 
        }
    }
}

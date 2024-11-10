public class ControladorDeErros implements Cloneable {
    private int qtdMax, qtdErr = 0;

    public ControladorDeErros(int qtdMax) throws Exception {
        if (qtdMax <= 0) throw new Exception("Quantidade inválida");
        this.qtdMax = qtdMax;
    }

    public void registreUmErro() throws Exception {
        if (this.qtdErr == this.qtdMax) throw new Exception("Errou além do máximo");
        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros() {
        return this.qtdErr == this.qtdMax;
    }

    public String toString() {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj==null) return false;
        if (!(obj.getClass()==this.getClass())) return false;


        ControladorDeErros Ce = (ControladorDeErros) obj;

        if (Ce.qtdErr != this.qtdErr) return false;

        return true;
    }

    public int hashCode() {
        int ret = 1;
        ret = ret*2 + ((Integer)this.qtdErr).hashCode();

        if (ret<0) ret=-ret;

        return ret;
    }

    public ControladorDeErros(ControladorDeErros c) throws Exception {
        if (c == null) throw new Exception("Objeto nulo fornecido para cópia.");
        this.qtdMax = c.qtdMax;
        this.qtdErr = c.qtdErr;
    }

    public Object clone() {
        try {
            return new ControladorDeErros(this);
        } catch (Exception e) {
            return null;
        }
    }
}

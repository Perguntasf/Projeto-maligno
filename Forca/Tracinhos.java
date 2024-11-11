public class Tracinhos implements Cloneable {
    private char texto[];

    public Tracinhos(int qtd) throws Exception {
        if (qtd <= 0) {
            throw new Exception("Quantidade deve ser positiva.");
        }
        this.texto = new char[qtd];
        for (int i = 0; i < this.texto.length; i++) {
            this.texto[i] = '_';
        }
    }

    public void revele(int posicao, char letra) throws Exception {
        if (posicao < 0 || posicao >= this.texto.length) {
            throw new Exception("Posição inválida.");
        }
        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos() {
        for (char c : this.texto) {
            if (c == '_') {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c : this.texto) {
            sb.append(c).append(' ');
        }
        return sb.toString().trim();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tracinhos tr = (Tracinhos) obj;
        if (this.texto.length != tr.texto.length) {
            return false;
        }
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] != tr.texto[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int result = 17;
        for (char c : this.texto) {
            result = 31 * result + c;
        }
        return result;
    }

    public Tracinhos(Tracinhos t) throws Exception {
        if (t == null || t.texto == null) {
            throw new Exception("Objeto inválido para cópia.");
        }
        this.texto = new char[t.texto.length];
        for (int i = 0; i < t.texto.length; i++) {
            this.texto[i] = t.texto[i];
        }
    }

    public Object clone() {
        Tracinhos copia = null;
        try {
            copia = new Tracinhos(this);
        } catch (Exception e) {
            // Tratamento de exceção, se necessário
        }
        return copia;
    }
}

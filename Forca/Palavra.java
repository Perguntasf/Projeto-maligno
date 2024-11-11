public class Palavra implements Comparable<Palavra> {
    private String texto;

    public Palavra(String texto) throws Exception {
        if (texto == null || texto.isEmpty()) {
            throw new Exception("Texto não pode ser nulo ou vazio.");
        }
        this.texto = texto;
    }

    public int getQuantidade(char letra) {
        int quantidade = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == letra) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception {
        int ocorrencias = 0;
        for (int pos = 0; pos < this.texto.length(); pos++) {
            if (this.texto.charAt(pos) == letra) {
                if (ocorrencias == i) {
                    return pos;
                }
                ocorrencias++;
            }
        }
        throw new Exception("A " + (i + 1) + "ª ocorrência de '" + letra + "' não foi encontrada.");
    }

    public int getTamanho() {
        return this.texto.length();
    }

    public String toString() {
        return this.texto;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Palavra palavra = (Palavra) obj;
        return this.texto.equals(palavra.texto);
    }

    public int hashCode() {
        return this.texto.hashCode();
    }

    public int compareTo(Palavra palavra) {
        return this.texto.compareTo(palavra.texto);
    }
}

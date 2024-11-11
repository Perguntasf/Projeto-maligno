public class TesteForca {
    public static void main(String[] args) {
        try {
            // Teste da classe Palavra
            System.out.println("=== Teste da classe Palavra ===");
            Palavra palavra = new Palavra("TESTE");
            System.out.println("Palavra: " + palavra);
            System.out.println("Quantidade de 'T': " + palavra.getQuantidade('T'));
            System.out.println("Posição da 1ª ocorrência de 'T': " + palavra.getPosicaoDaIezimaOcorrencia(0, 'T'));
            System.out.println("Tamanho: " + palavra.getTamanho());
            System.out.println();

            // Teste da classe ControladorDeErros
            System.out.println("=== Teste da classe ControladorDeErros ===");
            ControladorDeErros erros = new ControladorDeErros(3);
            System.out.println("Erros iniciais: " + erros);
            erros.registreUmErro();
            erros.registreUmErro();
            System.out.println("Após dois erros: " + erros);
            System.out.println("Atingido máximo de erros? " + erros.isAtingidoMaximoDeErros());
            erros.registreUmErro();
            System.out.println("Após terceiro erro: " + erros);
            System.out.println("Atingido máximo de erros? " + erros.isAtingidoMaximoDeErros());
            System.out.println();

            // Teste da classe ControladorDeLetrasJaDigitadas
            System.out.println("=== Teste da classe ControladorDeLetrasJaDigitadas ===");
            ControladorDeLetrasJaDigitadas letrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            letrasJaDigitadas.registre('A');
            letrasJaDigitadas.registre('B');
            System.out.println("Letras digitadas: " + letrasJaDigitadas);
            System.out.println("Letra 'A' já foi digitada? " + letrasJaDigitadas.isJaDigitada('A'));
            System.out.println("Letra 'C' já foi digitada? " + letrasJaDigitadas.isJaDigitada('C'));
            System.out.println();

            // Teste da classe Tracinhos
            System.out.println("=== Teste da classe Tracinhos ===");
            Tracinhos tracinhos = new Tracinhos(5);
            System.out.println("Tracinhos iniciais: " + tracinhos);
            tracinhos.revele(0, 'T');
            tracinhos.revele(2, 'S');
            System.out.println("Após revelar posições: " + tracinhos);
            System.out.println("Ainda com tracinhos? " + tracinhos.isAindaComTracinhos());
            System.out.println();

            // Teste da classe BancoDePalavras
            System.out.println("=== Teste da classe BancoDePalavras ===");
            Palavra palavraSorteada = BancoDePalavras.getPalavraSorteada();
            System.out.println("Palavra sorteada: " + palavraSorteada);
            System.out.println();

            // Teste da classe Teclado
            System.out.println("=== Teste da classe Teclado ===");
            System.out.print("Digite um caractere para teste: ");
            char caractere = Teclado.getUmChar();
            System.out.println("Caractere lido: " + caractere);

        } catch (Exception e) {
            System.err.println("Erro durante o teste: " + e.getMessage());
        }
    }
}

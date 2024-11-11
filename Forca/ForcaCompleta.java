import java.io.*;

public class ForcaCompleta {
    public static void main(String[] args) {
        char continuar;

        do {
            Palavra palavra = BancoDePalavras.getPalavraSorteada();
            Tracinhos tracinhos = null;

            try {
                tracinhos = new Tracinhos(palavra.getTamanho());
            } catch (Exception erro) {
                System.out.println("Erro ao inicializar os tracinhos: " + erro.getMessage());
            }

            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            ControladorDeErros controladorDeErros = null;
            try {
                controladorDeErros = new ControladorDeErros((int)(palavra.getTamanho() * 0.6));
            } catch (Exception erro) {
                System.out.println("Erro ao inicializar o controlador de erros: " + erro.getMessage());
            }

            while (tracinhos.isAindaComTracinhos() && !controladorDeErros.isAtingidoMaximoDeErros()) {
                System.out.println("Palavra: " + tracinhos);
                System.out.println("Letras digitadas: " + controladorDeLetrasJaDigitadas);
                System.out.println("Erros: " + controladorDeErros);

                try {
                    System.out.print("Digite uma letra: ");
                    char letra = Character.toUpperCase(Teclado.getUmChar());

                    if (controladorDeLetrasJaDigitadas.isJaDigitada(letra)) {
                        System.out.println("Essa letra já foi digitada!");
                    } else {
                        controladorDeLetrasJaDigitadas.registre(letra);
                        int qtd = palavra.getQuantidade(letra);

                        if (qtd == 0) {
                            System.out.println("A palavra não contém essa letra.");
                            controladorDeErros.registreUmErro();
                        } else {
                            for (int i = 0; i < qtd; i++) {
                                int posicao = palavra.getPosicaoDaIezimaOcorrencia(i, letra);
                                tracinhos.revele(posicao, letra);
                            }
                            System.out.println("Boa! A letra está na palavra.");
                        }
                    }
                } catch (Exception erro) {
                    System.out.println("Erro: " + erro.getMessage());
                }
            }

            if (controladorDeErros.isAtingidoMaximoDeErros()) {
                System.out.println("Você perdeu! A palavra era: " + palavra);
            } else {
                System.out.println("Parabéns! Você acertou a palavra: " + palavra);
            }

            continuar = perguntarSeContinua();

        } while (continuar == 'S');
    }

    private static char perguntarSeContinua() {
        char continuar = ' ';
        while (continuar != 'S' && continuar != 'N') {
            try {
                System.out.print("Deseja jogar novamente? (S/N): ");
                continuar = Character.toUpperCase(Teclado.getUmChar());
                if (continuar != 'S' && continuar != 'N') {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao ler resposta: " + e.getMessage());
            }
        }
        return continuar;
    }
}

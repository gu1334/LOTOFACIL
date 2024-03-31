import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Loteria {

    public static void main(String[] args) {
        menu(); // Inicia o menu principal
    }

    // Método para exibir o menu e processar as opções
    private static void menu() {
        int opcao = -1;
        Scanner in = new Scanner(System.in);

        // Loop do menu principal
        do {
            System.out.println("******************");
            System.out.println(" Menu LOTOFÁCIL: ");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("******************");

            // Obtém a opção do usuário
            opcao = in.nextInt();

            // Processa a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    System.out.println("Opção escolhida 1");
                    opcao1(); // Chama o método para a opção 1
                    break;
                case 2:
                    System.out.println("Opção escolhida 2");
                    opcao2(); // Chama o método para a opção 2
                    break;
                case 3:
                    System.out.println("Opção escolhida 3");
                    opcao3(); // Chama o método para a opção 3
                    break;
                case 0:
                    System.out.println("Opção escolhida 0");
                    //sair
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida."); // Mensagem de erro para opção inválida
            }
        } while (opcao != 0); // Loop continua até o usuário escolher a opção de sair (0)
    }

    // Método para a opção 1: Apostar de 0 a 100
    private static void opcao1() {
        Random aleatorio = new Random();
        Scanner scn = new Scanner(System.in);

        // Gerar um número aleatório entre 0 e 100
        int numeroAleatorio = aleatorio.nextInt(101);

        // Pedir ao usuário para digitar um número
        System.out.println("Digite um número entre 0 e 100: ");
        int numero = scn.nextInt();

        // Verificar se o número digitado é igual ao número aleatório
        if (numero == numeroAleatorio) {
            System.out.println("Parabéns! Você ganhou R$ 1.000,00!");
        } else {
            System.out.println("Que pena! O número sorteado foi: " + numeroAleatorio);
        }

        // Verificar se o número digitado é válido (entre 0 e 100)
        if (numero < 0 || numero > 100) {
            System.out.println("Aposta inválida. Por favor, digite um número entre 0 e 100.");
        }
    }

    // Método para a opção 2: Apostar de A à Z
    private static void opcao2() {
        // Solicita ao usuário que digite uma letra de A a Z
        System.out.println("Digite uma letra de A a Z: ");

        try {
            // Lê o próximo caractere do sistema de entrada e converte para maiúscula
            int letra = Character.toUpperCase(System.in.read());

            // Letra premiada definida
            char letraPremiada = 'G';

            // Verifica se o caractere lido é uma letra do alfabeto
            if (Character.isLetter((char) letra)) {
                // Se for uma letra, verifica se é a letra premiada
                if (letraPremiada == letra) {
                    // Se for a letra premiada, exibe uma mensagem informando o prêmio
                    System.out.println("Parabéns! Você ganhou R$ 500,00 reais.");
                } else {
                    // Se não for a letra premiada, informa ao usuário qual era a letra premiada
                    System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
                }
            } else {
                // Se não for uma letra, informa ao usuário que ele deve digitar uma letra de A a Z
                System.out.println("Aposta inválida. Por favor, digite uma letra de A a Z.");
            }
        } catch (IOException e) {
            // Se ocorrer um erro de entrada, exibe uma mensagem de erro
            System.out.println("Erro de entrada: " + e.getMessage());
        }
    }

    // Método para a opção 3: Apostar em par ou ímpar
    private static void opcao3() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Digite um numero ");
        int numero = scn.nextInt();

        // Verifica se o número digitado é par ou ímpar
        int imparPar = numero % 2;
        if (imparPar == 0) {
            // Se for par, o usuário ganha R$ 100,00
            System.out.println("Você ganhou R$ 100,00 reais.");
        } else {
            // Se for ímpar, informa ao usuário que a premiação é para números pares
            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}

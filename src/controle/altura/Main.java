package controle.altura;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Pessoa[] pessoas = new Pessoa[15];
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    static boolean cadastrado = false;

    public static void menu() {
        System.out.println("\n======MENU======\n");
        System.out.println("1.Cadastrar os 15 registros.");
        System.out.println("2.Apresentar os registros das pessoas com 1.50 m ou menores.");
        System.out.println("3.Apresentar os registros das pessoas maiores que 1.50 m.");
        System.out.println("4.Apresentar os registros das pessoas com mais de 1.50 m e menos de 2.0 m.");
        System.out.println("5.Apresentar todos os registros com a média extraída de todas as alturas armazenadas.");
        System.out.println("6.Sair do programa.\n");
    }

    public static boolean verificarCadastrado() {
        if (!cadastrado) {
            System.out.println("\nRealize o cadastro primeiro.\n");
            return false;
        }
        return true;
    }

    public static void realizarCadastro() {
        System.out.println("\nCadastro a seguir:\n");
        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("Cadastro " + (i + 1));

            System.out.println("Nome: ");
            String nomePessoa = scanner.nextLine();

            double alturaPessoa;
            while (true) {
                System.out.println("Altura (ex: 1.75): ");
                if (scanner.hasNextDouble()) {
                    alturaPessoa = scanner.nextDouble();
                    scanner.nextLine();
                    if (alturaPessoa > 0) break;
                    System.out.println("A altura deve ser maior que zero.");
                } else {
                    System.out.println("Valor inválido, tente de novo.");
                    scanner.nextLine();
                }
            }
            System.out.println(" ");

            pessoas[i] = new Pessoa(nomePessoa, alturaPessoa);
        }
        cadastrado = true;
    }

    public static double calcularMediaDasAlturas() {
        double somaAlturas = 0;
        for (Pessoa p : pessoas) {
            somaAlturas += p.getAltura();
        }
        return somaAlturas / pessoas.length;
    }

    public static void pessoasMenoresOuIguaisA150cm() {
        if (!verificarCadastrado()) return;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getAltura() <= 1.50) {
                System.out.println("Nome: " + pessoas[i].getNome());
                System.out.println("Altura: " + pessoas[i].getAltura());
                System.out.println(" ");
            }
        }
    }

    public static void pessoasMaiores150() {
        if (!verificarCadastrado()) return;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getAltura() > 1.50) {
                System.out.println("Nome: " + pessoas[i].getNome());
                System.out.println("Altura: " + pessoas[i].getAltura());
                System.out.println(" ");
            }
        }
    }

    public static void pessoasEntre150E200() {
        if (!verificarCadastrado()) return;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getAltura() > 1.50 && pessoas[i].getAltura() < 2.00) {
                System.out.println("Nome: " + pessoas[i].getNome());
                System.out.println("Altura: " + pessoas[i].getAltura());
                System.out.println(" ");
            }
        }
    }

    public static void exibirCadastros() {
        if (!verificarCadastrado()) return;

        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("Nome: " + pessoas[i].getNome());
            System.out.println("Altura: " + pessoas[i].getAltura());
            System.out.println(" ");
        }
        System.out.printf("MÉDIA DE TODAS AS ALTURAS: %.2f m%n", calcularMediaDasAlturas());
    }

    public static void main(String[] args) {
        int opcao;

        do {
            menu();
            System.out.println("\n\nEscolha uma opção: ");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("\nOpção inválida!\n");
                opcao = 0;
                continue;
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarCadastro();
                    break;

                case 2:
                    pessoasMenoresOuIguaisA150cm();
                    break;

                case 3:
                    pessoasMaiores150();
                    break;

                case 4:
                    pessoasEntre150E200();
                    break;

                case 5:
                    exibirCadastros();
                    break;

                case 6:
                    System.out.println("\nSaindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
                    break;
            }
        } while (opcao != 6);
    }
}
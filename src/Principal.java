import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==== Conversor de Moedas ====");
            System.out.println("1 - Real para Dólar");
            System.out.println("2 - Dólar para Real");
            System.out.println("3 - Real para Euro");
            System.out.println("4 - Euro para Real");
            System.out.println("5 - Real para Libra");
            System.out.println("6 - Libra para Real");
            System.out.println("7 - Real para Peso Argentino");
            System.out.println("8 - Peso Argentino para Real");
            System.out.println("0 - Sair");
            System.out.println("Escolha a opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Até logo!");
                break;
            }

            String de = "";
            String para = "";

            switch (opcao) {
                case 1: de = "BRL"; para = "USD"; break;
                case 2: de = "USD"; para = "BRL"; break;
                case 3: de = "BRL"; para = "EUR"; break;
                case 4: de = "EUR"; para = "BRL"; break;
                case 5: de = "BRL"; para = "GBP"; break;
                case 6: de = "GBP"; para = "BRL"; break;
                case 7: de = "BRL"; para = "ARS"; break;
                case 8: de = "ARS"; para = "BRL"; break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
                    continue;
            }
            System.out.println("Digite o valor a converter: ");
            double valor = scanner.nextDouble();

            double taxa = Conversor.consultar(de, para);

            if (taxa > 0) {
                double convertido = valor * taxa;
                System.out.printf("Valor original: %.2f %s\n", valor, de);
                System.out.printf("Valor convertido: %.2f %s\n", convertido, para);
                System.out.printf("Taxa de conversão (%s -> %s): %.4f\n", de, para, taxa);

                String registro = String.format("Convertido de %.2f %s para %.2f %s (taxa %.4f)", valor, de, convertido, para, taxa);
                System.out.println(registro);

            } else {
                System.out.println("Não foi possível obter a taxa de conversão");
            }

            int escolha;
            do {
                System.out.println("\nO que deseja fazer?");
                System.out.println("1 - Fazer nova conversão");
                System.out.println("2 - Sair");
                System.out.println("Escolha uma opção: ");
                escolha = scanner.nextInt();

                if (escolha == 1) {
                    break;
                } else if (escolha == 2) {
                    System.out.println("Até logo");
                    continuar = false;
                } else {
                    System.out.println("Opção inválida. Tente novamente!");
                }
            } while (escolha != 1 && escolha != 2);
        }
        scanner.close();
    }
}

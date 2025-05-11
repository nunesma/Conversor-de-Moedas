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
        }
    }
}

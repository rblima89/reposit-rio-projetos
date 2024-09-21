package primeiroB.SegundaAtividade;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class SistemaConversor {

    // Valores e símbolos para conversão de números inteiros para números romanos
    private static final int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    // Moedas e suas respectivas taxas de câmbio em relação ao USD
    private static final String[] moedas = {"USD", "EUR", "JPY", "GBP", "BRL"};
    private static final double[] taxasCambio = {1.0, 0.85, 110.0, 0.75, 5.4};

    // Método para conversão de números inteiros para números romanos
    public static String toRoman(int numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("Número fora do intervalo (1-3999).");
        }
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                resultado.append(simbolos[i]);
                numero -= valores[i];
            }
        }
        
        return resultado.toString();
    }

    // Método para localizar o índice de uma moeda nos arrays
    public static int findCurrencyIndex(String currency) {
        for (int i = 0; i < moedas.length; i++) {
            if (moedas[i].equals(currency)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Moeda não suportada: " + currency);
    }

    // Método para conversão de moedas
    public static double convert(double amount, String fromCurrency, String toCurrency) {
        int fromIndex = findCurrencyIndex(fromCurrency);
        int toIndex = findCurrencyIndex(toCurrency);
        
        double amountInUSD = amount / taxasCambio[fromIndex];
        return amountInUSD * taxasCambio[toIndex];
    }

    // Menu principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Converter número inteiro para número romano");
            System.out.println("2. Converter moeda");
            System.out.println("3. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite um número para converter para números romanos (1-3999): ");
                    int numero = scanner.nextInt();
                    try {
                        String romano = toRoman(numero);
                        System.out.println("O número " + numero + " em números romanos é: " + romano);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 2:
                    System.out.print("Digite o valor: ");
                    double valor = scanner.nextDouble();
                    System.out.print("Digite a moeda de origem (USD, EUR, JPY, GBP, BRL): ");
                    String de = scanner.next().toUpperCase();
                    System.out.print("Digite a moeda de destino (USD, EUR, JPY, GBP, BRL): ");
                    String para = scanner.next().toUpperCase();
                    
                    try {
                        double convertido = convert(valor, de, para);
                        NumberFormat formatoBRL = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                        System.out.println(valor + " " + de + " em " + para + ": " + formatoBRL.format(convertido));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}

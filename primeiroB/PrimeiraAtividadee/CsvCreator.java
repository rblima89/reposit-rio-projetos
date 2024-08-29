package primeiroB.PrimeiraAtividadee;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome Para o arquivo: ");
        String fileName = scanner.nextLine();

        System.out.print("Digite o nome da primeira coluna: ");
        String column1 = scanner.nextLine();
        System.out.print("Digite o nome da segunda coluna: ");
        String column2 = scanner.nextLine();
        System.out.print("Digite o nome da terceira coluna: ");
        String column3 = scanner.nextLine();

        System.out.print("Deseja adicionar mais colunas? (sim/não): ");
        String addMoreColumns = scanner.nextLine();

        StringBuilder header = new StringBuilder(column1 + "," + column2 + "," + column3);
        while (addMoreColumns.equalsIgnoreCase("sim")) {
            System.out.print("Digite o nome da próxima coluna: ");
            String nextColumn = scanner.nextLine();
            header.append(",").append(nextColumn);
            System.out.print("Deseja adicionar mais colunas? (sim/não): ");
            addMoreColumns = scanner.nextLine();
        }
        try (FileWriter writer = new FileWriter(fileName + ".csv")) {
            writer.write(header.toString() + "\n");
            
            System.out.print("Quantas linhas de dados você deseja inserir? ");
            int numRows = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numRows; i++) {
                System.out.println("Inserindo dados para a linha " + (i + 1) + ":");
                StringBuilder row = new StringBuilder();
                String[] columns = header.toString().split(",");

                for (int j = 0; j < columns.length; j++) {
                    System.out.print("Digite o valor da coluna " + columns[j] + ": ");
                    String value = scanner.nextLine();
                    if (j == 0) {
                        row.append(value);
                    } else {
                        row.append(",").append(value);
                    }
                }
                writer.write(row.toString() + "\n");
            }
            System.out.println("Arquivo CSV '" + fileName + ".csv' criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
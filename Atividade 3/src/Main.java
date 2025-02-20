import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Contribuinte> contribuintes = new ArrayList<>();

        System.out.print("Quantos contribuintes deseja cadastrar? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nDados do contribuinte #" + (i + 1) + ":");
            System.out.print("Pessoa Física ou Jurídica (f/j)? ");
            char tipo = scanner.next().charAt(0);
            scanner.nextLine();

            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Renda Anual: ");
            double rendaAnual = scanner.nextDouble();

            if (tipo == 'f' || tipo == 'F') {
                System.out.print("Gastos com Saúde: ");
                double gastosSaude = scanner.nextDouble();
                contribuintes.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else if (tipo == 'j' || tipo == 'J') {
                System.out.print("Número de Funcionários: ");
                int numFuncionarios = scanner.nextInt();
                contribuintes.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
            }
        }

        scanner.close();

        System.out.println("\nImpostos pagos:");
        double totalImposto = 0;
        for (Contribuinte c : contribuintes) {
            double imposto = c.calcularImposto();
            System.out.println(c.getNome() + ": R$ " + String.format("%.2f", imposto));
            totalImposto += imposto;
        }

        System.out.println("\nTotal de impostos arrecadados: R$ " + String.format("%.2f", totalImposto));
    }
}

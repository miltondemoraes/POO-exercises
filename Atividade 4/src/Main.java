import java.util.Scanner;

class BankException extends Exception {
    public BankException(String message) {
        super(message);
    }
}

class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account(int number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws BankException {
        if (amount > withdrawLimit) {
            throw new BankException("Erro: O valor do saque excede o limite permitido.");
        }
        if (amount > balance) {
            throw new BankException("Erro: Saldo insuficiente.");
        }
        balance -= amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite os dados da conta:");
            System.out.print("Número da conta: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Titular da conta: ");
            String holder = scanner.nextLine();
            System.out.print("Saldo inicial: ");
            double balance = scanner.nextDouble();
            System.out.print("Limite de saque: ");
            double withdrawLimit = scanner.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Digite o valor para saque: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);
            System.out.println("Saque realizado com sucesso. Novo saldo: " + account.getBalance());
        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
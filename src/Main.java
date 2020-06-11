import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner nameInput = new Scanner(System.in);
        Scanner valueInput = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<Account>();
        boolean run = true, validation;
        int option = 0, agency;

        while (run) {
            System.out.println("--------------------------------------");
            System.out.println("Menu");
            System.out.println("1 - Abrir conta corrente");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Consultar saldo");
            System.out.println("5 - Contas abertas");
            System.out.println("6 - Contas com saldo zerado");
            System.out.println("7 - Sair");
            System.out.println("--------------------------------------");
            option = valueInput.nextInt();

            switch (option) {
                case 1:
                    if (accounts.size() > 10) {
                        System.out.println("Número máximo de contas atingido :(");
                    }
                    System.out.println("Digite o seu nome: ");
                    String name = nameInput.nextLine();
                    System.out.println("Digite o número da agência");
                    agency = valueInput.nextInt();

                    validation = haveAgency(accounts, agency);

                    if (validation) {
                        Account user = new Account(agency, name);
                        accounts.add(user);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Já existe uma conta com essa agência");
                        System.out.println("Utilize outra combinação!");
                    }
                    break;

                case 2:
                    System.out.println("Informe o número da agência: ");
                    agency = valueInput.nextInt();

                    validation = haveAgency(accounts, agency);
                    if (!validation) {
                        System.out.println("Quanto deseja depositar: ");
                        Double value = valueInput.nextDouble();
                        String message = withdrawAndDeposit(accounts, option, value, agency);
                        System.out.println(message);
                    } else {
                        System.out.println("Não foi possível realizar a operação");
                    }
                    break;

                case 3:
                    System.out.println("Digite a sua agência: ");
                    agency = valueInput.nextInt();
                    validation = haveAgency(accounts, agency);

                    if (!validation) {
                        System.out.println("Quanto deseja sacar: ");
                        Double value = valueInput.nextDouble();
                        String message = withdrawAndDeposit(accounts, option, value, agency);
                        System.out.println(message);
                    } else {
                        System.out.println("Não foi possível realizar a operação");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da sua agência: ");
                    agency = valueInput.nextInt();

                    validation = haveAgency(accounts, agency);
                    if (!validation) {
                        for (Account user : accounts) {
                            if (user.getAgency() == agency) {
                                System.out.println("Seu saldo é " + "R$" + user.getFunds());
                            }
                        }
                    } else {
                        System.out.println("Não existe essa conta...");
                    }
                    break;

                case 5:
                    System.out.println(accounts);
                    break;

                case 6:
                    for (Account user : accounts) {
                        if (user.getFunds() == 0) {
                            System.out.println(user);
                        }
                    }
                    break;

                case 7:
                    run = false;
                    System.out.println("Sessão encerrada...");
                    break;
                default:
                    System.out.println("Digite um valor dentro do intervalo...");
                    break;
            }
        }
    }

    public static boolean haveAgency(ArrayList<Account> accounts, int agency)
    {
        boolean isValid = true;
        for (Account user : accounts) {
            if (user.getAgency() == agency) {
                isValid = false;
            }
        }
        return isValid;
    }

    public static String withdrawAndDeposit(ArrayList<Account> accounts, int option, Double value, int agency)
    {
        String message = "";
        if (option == 2) {
            for (Account user : accounts) {
                if (user.getAgency() == agency && value > 0) {
                    user.deposit(value);
                    message = "Operação realizada com sucesso!";
                } else {
                    message = "Não foi possível realizar a operação";
                }
            }
        } else {
            for (Account user : accounts) {
                if (user.getAgency() == agency && value <= user.getFunds()) {
                    user.withdraw(value);
                    message = "Operação realizada com sucesso!";
                } else {
                    message = "Não foi possível realizar a operação";
                }
            }
        }
        return message;
    }
}





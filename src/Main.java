import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner nameInput = new Scanner(System.in);
        Scanner valueInput = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<Account>();
        boolean run = true;
        int option = 0;

        while (run) {
            System.out.println("--------------------------------------");
            System.out.println("Menu");
            System.out.println("1 - Abrir conta corrente");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("1 - Consultar saldo");
            System.out.println("1 - Contas com saldo zerado");
            System.out.println("7 - Sair");
            option = valueInput.nextInt();

            if (option == 1 && accounts.size() < 10) {
                boolean run2 = true;
                while (run2) {

                    System.out.println("Digite o seu nome: ");
                    String name = nameInput.nextLine();
                    System.out.println("Digite o número da agência");
                    int agency = valueInput.nextInt();

                    boolean validation = haveAgency(accounts, agency);

                    if (validation) {
                        Account user = new Account(agency, name);
                        accounts.add(user);
                        System.out.println("Conta criada com sucesso!");
                        run2 = false;
                    } else {
                        System.out.println("Já existe uma conta com essa agência");
                        System.out.println("Utilize outra combinação!");
                        run2 = false;
                    }
                }
            }

            if (option == 2) {
                boolean run3 = true;
                System.out.println("Informe o número da agência: ");
                int agency = valueInput.nextInt();
                while (run3) {
                    boolean verify = verification(accounts, agency);
                    if (verify) {
                        System.out.println("Quanto deseja depositar: ");
                        Double value = valueInput.nextDouble();
                        for (Account user : accounts) {
                            if (user.getAgency() == agency && value > 0) {
                                user.setFunds(value);
                                System.out.println("Valor depositado com sucesso!");
                                run3 = false;
                                break;
                            } else {
                                System.out.println("Não foi possível realizar a operação...");
                                run3 = false;
                                break;
                            }
                        }
                    } else {
                        System.out.println("Não foi possível realizar a operação");
                        run3 = false;
                    }
                }

            }
            switch (option) {
                case 7:
                    run = false;
                    System.out.println(accounts + "\n");
                    System.out.println("Sessão encerrada...");
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

    public static boolean verification(ArrayList<Account> accounts, int agency)
    {
        boolean isValid = false;
        for (Account user : accounts) {
            if (user.getAgency() == agency) {
                isValid = true;
            }
        }
        return isValid;
    }
}



import java.util.*;

public class bank {
    static ArrayList<account> obj = new ArrayList<account>();

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();

            String[] result = command.split(" ");

            String code = result[0];
            String accountNumber = result[1];

            String customerName = "";
            if (result.length == 3) {
                customerName = result[2];
            }

            if (code.equals("CREATE")) {
                int x = check_account(accountNumber);
                if (x == 0) {
                    account output = create(accountNumber, customerName);
                    obj.add(output);
                } else
                    System.out.println("Account already exists");

            } else if (code.equals("DEPOSIT")) {
                int amount = Integer.parseInt(customerName);
                // System.out.println(check_account(accountNumber));
                if (check_account(accountNumber) == 1) {
                    account temp = get_account_number(accountNumber);
                    deposit(amount, temp);
                } else
                    System.out.println("Account dose not exist");
            } else if (code.equals("WITHDRAW")) {
                int amount = Integer.parseInt(customerName);
                if (check_account(accountNumber) == 1) {
                    account temp = get_account_number(accountNumber);
                    withdraw(amount, temp);
                } else
                    System.out.println("Account dose nOt exist");
            } else if (code.equals("BALANCE")) {

                if (check_account(accountNumber) == 1) {
                    account temp = get_account_number(accountNumber);
                    balance(temp);
                } else
                    System.out.println("Account dose nit exist");
            }
        }
    }

    static int check_account(String accountNumber) {
        int flag = 0;
        for (int i = 0; i < obj.size(); i++) {
            if (accountNumber.equals(obj.get(i).account_Number)) {
                flag = 1;
                break;
            }

        }
        return flag;
    }

    static account get_account_number(String accountNumber) {
        int flag = 0;
        for (int i = 0; i < obj.size(); i++) {
            if (accountNumber.equals(obj.get(i).account_Number)) {
                flag = 1;
                return obj.get(i);
            }
        }
        return null;
    }

    static account create(String accountNumber, String customerName) {
        account a1 = new account(accountNumber, customerName);
        return a1;
    }

    static void deposit(int amount, account temp) {
        if (amount > 0)
            temp.balance += amount;

    }

    static void withdraw(int amount, account temp) {
        if (amount > 0) {
            if (amount < temp.balance) {
                temp.balance -= amount;
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

    static void balance(account temp) {
        System.out.println(temp.customer_Name + " " + temp.balance);
    }
}

class account {
    String account_Number;
    String customer_Name;
    long balance = 0;

    account(String accountNumber, String customerName) {
        this.account_Number = accountNumber;
        this.customer_Name = customerName;
    }

}
public class Main {

    public static void main(String[] args) {

        BankAccount johnsAccount = new BankAccount(567800, 62500,"John","blabla@dgd.net","08564732");
        System.out.println(johnsAccount.getAccountNumber());
        System.out.println(johnsAccount.getEmail());
        johnsAccount.withdraw(50.0);
        johnsAccount.deposit(280.0);
        johnsAccount.withdraw(130.0);


    }
}

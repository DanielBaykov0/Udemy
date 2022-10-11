public class BankAccount {

    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount () {
        System.out.println("Empty constructor");
    }
    public BankAccount ( int accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }





    public void deposit (double depositAmount) {
        this.balance += depositAmount;
    }
    public void withdraw (double withdrawAmount) {
        if (balance - withdrawAmount < 0) {
            System.out.println(balance + " is available.");
        } else {
            balance -= withdrawAmount;
            System.out.println(withdrawAmount + " withdrawn amount. Remaining balance is " + balance);
        }
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public String getCustomerName () {
        return customerName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}

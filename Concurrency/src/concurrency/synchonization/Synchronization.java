package concurrency.synchonization;

public class Synchronization {

    public static void main(String[] args) {

        BankAccount companyAccount = new BankAccount("Tom", 10000);

        Thread thread1 = new Thread(() -> companyAccount.withdraw(2500));
        Thread thread2 = new Thread(() -> companyAccount.deposit(5000));
        Thread thread3 = new Thread(() -> companyAccount.setName("Tim"));
        Thread thread4 = new Thread(() -> companyAccount.withdraw(5000));

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + companyAccount.getBalance());
    }
}

class BankAccount {

    private final Object lockName = new Object();
    private final Object lockBalance = new Object();
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (lockName) {
            this.name = name;
            System.out.println("Updated name = " + this.name);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        try {
            System.out.println("Deposit - talking to the teller at the bank...");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (lockBalance) {
            double origBalance = balance;
            balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
            addPromoDollars(amount);
        }
    }

    private void addPromoDollars(double amount) {
        if (amount >= 5000) {
            synchronized (lockBalance) {
                System.out.println("Congratulations, your earned a promotional deposit.");
                balance += 25;
            }
        }
    }

    public synchronized void withdraw(double amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double origBalance = balance;
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        } else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                    " : INSUFFICIENT FUNDS!", origBalance, amount);
        }
    }
}

package Bankaccount;

class Account {
    //Attributes
    private int accountNumber;
    private String accountHolderName;
    protected double balance;

    //Encapsulation
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Method
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
}

//Inheritance
class SavingsAccount extends Account {
    //Overriding
    
    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

//Inheritance
class CurrentAccount extends Account {
    private final double overdraftLimit = 50000;

    //Overriding
    
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Transaction denied: Insufficient funds, Maximum overdraft limit is " + overdraftLimit);
        }
    }
}

//Inheritance
class FixedDepositAccount extends Account {
    //Method
    public double calculateInterest(double rateOfInterest, int timePeriod) {
        double interest = balance * rateOfInterest * timePeriod / 100;
        return interest; 
    }
}

public class BankA {
    public static void main(String[] args) {
        //Polymorphism
        Account account1 = new SavingsAccount();
        account1.setAccountNumber(1001);
        account1.setAccountHolderName("John Doe");
        account1.setBalance(10000);
        account1.withdraw(5000);
        System.out.println("Savings Account Information");
        System.out.println("Account Number: " + account1.getAccountNumber());
        System.out.println("Account Holder Name: " + account1.getAccountHolderName());
        System.out.println("Balance: " + account1.getBalance());
        System.out.println();

        Account account2 = new CurrentAccount();
        account2.setAccountNumber(1002);
        account2.setAccountHolderName("kevin");
        account2.setBalance(30000);
        account2.withdraw(28000);
        System.out.println("Current Account Information");
        System.out.println("Account Number: " + account2.getAccountNumber());
        System.out.println("Account Holder Name: " + account2.getAccountHolderName());
        System.out.println("Balance: " + account2.getBalance());
        System.out.println();

        Account account3 = new FixedDepositAccount();
        account3.setAccountNumber(5678);
        account3.setAccountHolderName("Leah"
        		+ "");
        account3.setBalance(30000);
        double interest = ((FixedDepositAccount) account3).calculateInterest(5, 2);
        account3.deposit(interest);
        System.out.println("Fixed Deposit Account Information");
        System.out.println("Account Number: " + account3.getAccountNumber());
        System.out.println("Account Holder Name: " + account3.getAccountHolderName());
        System.out.println("Balance: " + account3.getBalance());
    }
}



                
package myy803.testing.junit.fixture_patterns;

class BankAccount {

    private String owner;
    private double balance;

    BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit");
        }
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Not enough funds");
        }
        balance -= amount;
    }

    double getBalance() {
        return balance;
    }
}

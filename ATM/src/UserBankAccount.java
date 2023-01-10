public class UserBankAccount {
    int balance;

    public int getBalance() {
        return balance;
    }

    public void withdrawBalance(int amount) {
        this.balance = this.balance - amount;
    }
}

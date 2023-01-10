import java.time.LocalDate;

public class Card {
    private int cardNumber;
    private int cvv;
    private LocalDate expiryDate;
    private String cardHolderName;
    private UserBankAccount userBankAccount;

    private static int PIN_NUMBER = 123112;

    public boolean isCorrectPINEntered(int pin) {
        if (pin == PIN_NUMBER) {
            return true;
        }
        return false;
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public int getBankBalance() {
        return userBankAccount.getBalance();
    }

    public void deductBankBalance(int amount) {
        userBankAccount.withdrawBalance(amount);
    }
}

public abstract class ATMState {

    // insertCard
    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS! Something went wrong");
    }

    // authenticatePin
    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("OOPS! Something went wrong");
    }

    // selectOperation
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        System.out.println("OOPS! Something went wrong");
    }

    // cashWithdrawal
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmount) {
        System.out.println("OOPS! Something went wrong");
    }

    // displayBalance
    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS! Something went wrong");
    }

    // returnCard
    public void returnCard() {
        System.out.println("OOPS! Something went wrong");
    }

    // exit
    public void exit(ATM atm) {
        System.out.println("OOPS! Something went wrong");
    }
}

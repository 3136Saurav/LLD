public class SelectOperationState extends ATMState {
    public SelectOperationState() {
        showOperations();
    }

    public void selectOperation(ATM atmObject, Card card, TransactionType transactionType) {
        switch (transactionType) {
            case CASH_WITHDRAWAL:
                atmObject.setCurrentATMState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atmObject.setCurrentATMState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid Option");
                exit(atmObject);
        }
    }

    public void showOperations() {
        System.out.println("Please select the operations: ");
        TransactionType.showAllTransactionTypes();
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit!");
    }

    public void returnCard() {
        System.out.println("Please collect your card!");
    }
}

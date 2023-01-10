public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the withdrawal amount");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmount) {
        if (withdrawalAmount > atm.getAtmBalance()) {
            System.out.println("Insufficient Funds in the ATM");
            exit(atm);
        } else if (withdrawalAmount > card.getBankBalance()) {
            System.out.println("Insufficient Balance in the card");
            exit(atm);
        } else {
            card.deductBankBalance(withdrawalAmount);
            atm.deductATMBalance(withdrawalAmount);

            CashWithdrawProcessor processor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            processor.withdraw(atm, withdrawalAmount);
            exit(atm);

        }
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card!");
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit!");
    }
}

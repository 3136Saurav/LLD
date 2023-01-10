public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 123112);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2700);

        atmRoom.atm.printCurrentATMStatus();


    }

    private void initialize() {
        atm = ATM.getAtmObject();
        atm.setAtmBalance(3500, 1, 2, 5);
    
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setUserBankAccount(createUserBankAccount());
        return card;
    }

    private UserBankAccount createUserBankAccount() {
        UserBankAccount userBankAccount = new UserBankAccount();
        userBankAccount.balance = 3000;

        return userBankAccount;
    }

}

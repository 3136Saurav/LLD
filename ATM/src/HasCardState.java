public class HasCardState extends ATMState {
    public HasCardState() {
        System.out.println("Enter your pin number");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);

        if (isCorrectPinEntered) {
            atm.setCurrentATMState(new SelectOperationState());
        } else {
            System.out.println("Invalid Pin!");
            exit(atm);
        }
    }

    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit!");
    }

    public void returnCard() {
        System.out.println("Please collect your card");
    }

}

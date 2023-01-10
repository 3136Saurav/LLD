public class ATM {
    private static ATM atmObject = new ATM();
    private ATM() {

    }

    ATMState currentATMState;

    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    public static ATM getAtmObject() {
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }

    public void deductATMBalance(int amount) {
        this.atmBalance = this.atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number) {
        this.noOfTwoThousandNotes = this.noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        this.noOfFiveHundredNotes = this.noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        this.noOfOneHundredNotes = this.noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus() {
        System.out.println("Balance  : " + atmBalance);
        System.out.println("2K  Notes: " + noOfTwoThousandNotes);
        System.out.println("500 Notes: " + noOfFiveHundredNotes);
        System.out.println("100 Notes: " + noOfOneHundredNotes);
    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }
}

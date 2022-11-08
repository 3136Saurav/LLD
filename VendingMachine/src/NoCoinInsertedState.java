public class NoCoinInsertedState implements VendingMachineState {
    VendingMachine vendingMachine;

    public NoCoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.setAmount(amount);
        vendingMachine.setState(new CoinInsertedAndChooseItem(vendingMachine));
    }

    @Override
    public void chooseItem(String position) {
        throw new IllegalStateException("Please insert the coin first!!");
    }

    @Override
    public void dispenseItem() {
        throw new IllegalStateException("Please insert the coin first!!");
    }
}

public class DispenseState implements VendingMachineState{
    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        throw new IllegalStateException("You are in dispense state! Not Allowed");
    }

    @Override
    public void chooseItem(String position) {
        throw new IllegalStateException("You are in dispense state! Not Allowed");
    }

    @Override
    public void dispenseItem() {
        vendingMachine.updateInventory();
        System.out.println("Please collect your Product: " + vendingMachine.getProduct().getName() + " - Rs. " + vendingMachine.getProduct().getPrice());
        vendingMachine.calculateChangeAndReturn();

        vendingMachine.resetState();
        vendingMachine.setAmount(0);
        vendingMachine.setProduct(null);
        vendingMachine.setState(new NoCoinInsertedState(vendingMachine));
    }
}

public class CoinInsertedAndChooseItem implements VendingMachineState {
    VendingMachine vendingMachine;

    public CoinInsertedAndChooseItem(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.setAmount(vendingMachine.getAmount() + amount);
    }

    @Override
    public void chooseItem(String position) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProductAt(position);
        if (!vendingMachine.isValidPosition(position)) {
            throw new IllegalArgumentException("Not a valid choice!!");
        }

        if (!vendingMachine.hasSufficientAmount(product.getPrice())) {
            throw new IllegalArgumentException("Please give more coins!!");
        }

        if (!vendingMachine.getInventory().hasSufficientQuantityOfProduct(product)) {
            throw new IllegalArgumentException("Sorry! Product is not available");
        }

        vendingMachine.setProduct(product);
        vendingMachine.setState(new DispenseState(vendingMachine));
    }

    @Override
    public void dispenseItem() {
        throw new IllegalArgumentException("Please choose item");
    }
}

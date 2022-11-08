public interface VendingMachineState {
    void insertCoin(int amount);

    void chooseItem(String position);

    void dispenseItem();
}

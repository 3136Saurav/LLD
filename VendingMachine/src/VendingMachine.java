class VendingMachine {
    int numberOfAisles;
    VendingMachineState state;
    int amount;
    Inventory inventory;
    Product product;

    public VendingMachine(int numberOfAisles, Inventory inventory) {
        this.numberOfAisles = numberOfAisles;
        this.state = new NoCoinInsertedState(this);
        this.amount = 0;
        this.inventory = inventory;
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void insertCoin(int amount) {
        this.getState().insertCoin(amount);
    }

    public void chooseItem(String position) {
        this.getState().chooseItem(position);
        this.getState().dispenseItem();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean hasSufficientAmount(int priceOfProduct) {
        if (priceOfProduct <= this.amount) {
            return true;
        } else {
            return false;
        }
    }

    public void updateInventory() {
        Inventory inventory = getInventory();
        inventory.decrementQuantityOfProduct(product);
    }

    public void calculateChangeAndReturn() {
        if (getAmount() <= product.getPrice()) return;
        System.out.println("Your Change : " + (amount - product.getPrice()));
    }

    public void resetState() {
        setProduct(null);
        setAmount(0);
        setState(new NoCoinInsertedState(this));
    }

    public boolean isValidPosition(String position) {
        return inventory.getPositionToProductMap().containsKey(position);
    }
}

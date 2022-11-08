import java.util.*;

public class Main {
    private static final int NUMBER_OF_AISLES = 3;

    public static void main(String[] args) {
        Inventory inventory = createInventory();

        VendingMachine vendingMachine = new VendingMachine(NUMBER_OF_AISLES, inventory);

        simulateUserInteraction(vendingMachine);
    }

    private static void simulateUserInteraction(VendingMachine vendingMachine) {
        vendingMachine.insertCoin(30);
        vendingMachine.chooseItem("B2");
        vendingMachine.dispenseItem();
    }


    private static Inventory createInventory() {
        Inventory inventory = new Inventory();
        Map<Product, Integer> productFrequencyMap = new HashMap<>();
        Map<String, Product> productToPositionMap = new HashMap<>();

        Product doritos = new Product("Doritos", "Chips", 20);
        Product redBull = new Product("Red Bull", "Energy Drink", 80);
        Product dairyMilk = new Product("Dairy Milk", "Chocolate", 70);
        Product pretzels = new Product("Pretzels", "Pretzels", 40);
        Product cheetos = new Product("Cheetos", "Chips", 30);
        Product cocaCola = new Product("Coca Cola", "Soft Drink", 20);
        Product seltzer = new Product("Seltzer", "High Drink", 50);
        Product lays = new Product("Lays", "Chips", 20);
        Product jalapeno = new Product("Jalapeno", "Wafers", 60);

        productFrequencyMap.put(doritos, 4);
        productFrequencyMap.put(redBull, 3);
        productFrequencyMap.put(dairyMilk, 2);
        productFrequencyMap.put(pretzels, 6);
        productFrequencyMap.put(cheetos, 1);
        productFrequencyMap.put(cocaCola, 5);
        productFrequencyMap.put(seltzer, 3);
        productFrequencyMap.put(lays, 7);
        productFrequencyMap.put(jalapeno, 3);

        productToPositionMap.put("A1", doritos);
        productToPositionMap.put("A2", redBull);
        productToPositionMap.put("A3", dairyMilk);
        productToPositionMap.put("B1", pretzels);
        productToPositionMap.put("B2", cheetos);
        productToPositionMap.put("B3", cocaCola);
        productToPositionMap.put("C1", seltzer);
        productToPositionMap.put("C2", lays);
        productToPositionMap.put("C3", jalapeno);

        inventory.setProductToPositionMap(productToPositionMap);
        inventory.setProductFrequencyMap(productFrequencyMap);

        return inventory;
    }

}

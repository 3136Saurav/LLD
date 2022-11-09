import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Product, Integer> productFrequencyMap;
    Map<String, Product> positionToProductMap;
    
    public Inventory() {
        productFrequencyMap = new HashMap<>();
        positionToProductMap = new HashMap<>();
    }

    public Map<Product, Integer> getProductFrequencyMap() {
        return productFrequencyMap;
    }

    public void setProductFrequencyMap(Map<Product, Integer> productFrequencyMap) {
        this.productFrequencyMap = productFrequencyMap;
    }

    public Map<String, Product> getPositionToProductMap() {
        return positionToProductMap;
    }

    public void setPositionToProductMap(Map<String, Product> positionToProductMap) {
        this.positionToProductMap = positionToProductMap;
    }

    public Product getProductAt(String position) {
        if (!positionToProductMap.containsKey(position)) {
            return null;
        }
        
        Product chosenProduct = positionToProductMap.get(position);
        return chosenProduct;
    }

    public boolean hasSufficientQuantityOfProduct(Product product) {
        if (!productFrequencyMap.containsKey(product)) {
            return false;
        }

        int count = productFrequencyMap.get(product);
        return count > 0;
    }

    public void decrementQuantityOfProduct(Product product) {
        if (!productFrequencyMap.containsKey(product)) {
            return;
        }

        productFrequencyMap.put(product, productFrequencyMap.get(product) - 1);
        if (productFrequencyMap.get(product) == 0) {
            productFrequencyMap.remove(product);
            positionToProductMap.remove(product);
        }
    }
}

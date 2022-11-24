public class Corn extends BasePizza {
    BasePizza basePizza;

    public Corn(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 15;
    }
}

public class Cheese extends ToppingDecorator{
    BasePizza basePizza;

    public Cheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 20;
    }
}

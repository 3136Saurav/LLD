import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        BasePizza pizza = new Mushroom(new Corn(new Cheese(new Margherita())));
        System.out.println(pizza.getCost());

    }

}

package Pizza;
import java.util.*;

interface Food {
    double calculate(); // subtotal
}

/** ===== Decorator 基础 ===== */
abstract class FoodDecorator implements Food {
    protected final Food food;
    FoodDecorator(Food food) {
        if (food == null) throw new IllegalArgumentException("food is null");
        this.food = food;
    }
    @Override
    public double calculate() { return food.calculate(); }
}

/** ===== Pizza Base ===== */
abstract class Pizza implements Food {
    protected final int size; // 1,2,3
    Pizza(int size) { this.size = size; }

    protected abstract double basePrice();

    protected double sizeMultiplier() {
        switch (size) {
            case 1: return 0.8;
            case 2: return 1.0;
            case 3: return 1.5;
            default: throw new IllegalArgumentException("Invalid size: " + size);
        }
    }

    @Override
    public double calculate() {
        return basePrice() * sizeMultiplier();
    }
}

class HawaiiPizza extends Pizza {
    HawaiiPizza(int size) { super(size); }
    @Override protected double basePrice() { return 10.0; }
}

class MixPizza extends Pizza {
    MixPizza(int size) { super(size); }
    @Override protected double basePrice() { return 12.0; }
}

/** ===== Toppings Decorators ===== */
class PepoTopping extends FoodDecorator {
    PepoTopping(Food food) { super(food); }
    @Override public double calculate() { return food.calculate() + 2.0; }
}

class SausageTopping extends FoodDecorator {
    SausageTopping(Food food) { super(food); }
    @Override public double calculate() { return food.calculate() + 3.0; }
}

/** ===== Snack / Drink 也实现 Food ===== */
class SimpleItem implements Food {
    private final String name;
    private final double unitPrice;
    private final int qty;

    SimpleItem(String name, double unitPrice, int qty) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    @Override
    public double calculate() {
        return unitPrice * qty;
    }
}

/** ===== Coupon Strategy ===== */
interface CouponStrategy {
    double apply(double subtotal);
}

class NoCoupon implements CouponStrategy {
    @Override public double apply(double subtotal) { return subtotal; }
}

class AAACoupon implements CouponStrategy {
    @Override public double apply(double subtotal) {
        return subtotal > 10 ? subtotal * 0.9 : subtotal;
    }
}

class BBBCoupon implements CouponStrategy {
    @Override public double apply(double subtotal) {
        return subtotal > 100 ? subtotal * 0.8 : subtotal;
    }
}

class CouponFactory {
    private static final Map<String, CouponStrategy> MAP;
    static {
        Map<String, CouponStrategy> m = new HashMap<String, CouponStrategy>();
        m.put("AAA", new AAACoupon());
        m.put("BBB", new BBBCoupon());
        MAP = Collections.unmodifiableMap(m);
    }

    static CouponStrategy fromCode(String code) {
        if (code == null || code.trim().isEmpty()) return new NoCoupon();
        CouponStrategy c = MAP.get(code);
        if (c == null) throw new IllegalArgumentException("Invalid coupon: " + code);
        return c;
    }
}

/** ===== Order：组合多种 Food，并在最后应用 CouponStrategy ===== */
class Order {
    private final List<Food> items = new ArrayList<Food>();
    private CouponStrategy coupon = new NoCoupon();

    public void add(Food item) { items.add(item); }

    public void applyCoupon(String code) {
        this.coupon = CouponFactory.fromCode(code);
    }

    public double subtotal() {
        double sum = 0.0;
        for (Food f : items) sum += f.calculate();
        return sum;
    }

    public double total() {
        return coupon.apply(subtotal());
    }
}

/** ===== Demo ===== */
public class PizzaOrderSystemV2 {
    public static void main(String[] args) {
        Food pizza = new HawaiiPizza(2);
        pizza = new PepoTopping(pizza);
        pizza = new SausageTopping(pizza);

        Food drink = new SimpleItem("Coke", 2.0, 2);
        Food snack = new SimpleItem("Garlic Bread", 4.5, 1);

        Order order = new Order();
        order.add(pizza);
        order.add(drink);
        order.add(snack);

        order.applyCoupon("AAA");

        System.out.println("Subtotal = " + order.subtotal());
        System.out.println("Total    = " + order.total());
    }
}

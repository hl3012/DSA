package Pizza;
import java.util.*;


interface Food {
    double calculatePrice();
}


abstract class Pizza implements Food {
    int size;
    Pizza(int size) {
        this.size = size;
    }

    abstract double typeBasePrice();
    double sizeMultiplier() {
        switch(size) {
            case 1: return 0.8;
            case 2: return 1;
            case 3: return 1.5;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    @Override
    public double calculatePrice() {
        return typeBasePrice()*sizeMultiplier();
    }
}

abstract class PizzaDecorator implements Food {
    Food food;
    PizzaDecorator(Food food) {
        this.food=food;
    }

    @Override
    public double calculatePrice() {
        return food.calculatePrice();
    }
}

class MushRoomToppings extends PizzaDecorator {
    MushRoomToppings(Food food) {
        super(food);
    }

    @Override
    public double calculatePrice() {
        return food.calculatePrice()+1;
    }
}

class SimpleItem implements Food {
    int qty;
    double unit;
    SimpleItem(int qty, double unit) {
        this.qty=qty;
        this.unit=unit;
    }
    @Override
    public double calculatePrice() {
        return qty*unit;
    }
}


class HawaiiPizza extends Pizza {
    HawaiiPizza(int size) {
        super(size);
    }

    @Override
    double typeBasePrice(){
        return 10;
    }
}

class MixedPizza extends Pizza {
    MixedPizza(int size) {
        super(size);
    }

    @Override
    double typeBasePrice(){
        return 15;
    }
}

interface CouponStrategy {
    double apply(double subtotal);
}

class AAACoupon implements CouponStrategy {
    @Override
    public double apply(double subtotal) {
        return subtotal>30? subtotal*0.8:subtotal;
    }
}

class BBBCoupon implements CouponStrategy {
    @Override
    public double apply(double subtotal) {
        return subtotal>50? subtotal*0.7:subtotal;
    }
}

class NoCoupon implements CouponStrategy {
    @Override
    public double apply(double subtotal) {
        return subtotal;
    }
}

class CouponFactory {
    private static final Map<String, CouponStrategy> MAP =
    new HashMap<String, CouponStrategy>() {{
        put("AAA", new AAACoupon());
        put("BBB", new BBBCoupon());
    }};

    static CouponStrategy generateCoupon(String code) {
        if(code==null||code.equals("")) return new NoCoupon();
        CouponStrategy c = MAP.get(code);
        return c == null ? new NoCoupon() : c;
    }
}

class Order {
    List<Food> items = new ArrayList<>();
    CouponStrategy cs = new NoCoupon();
    public void setCoupon(CouponStrategy coupon) {
        this.cs=coupon;
    }
    public void add(Food food) {
        items.add(food);
    }

    public double subtotalPrice() {
        double sum=0;
        for(Food f:items) sum+=f.calculatePrice();
        return sum;
    }

    public double total() {
        return cs.apply(subtotalPrice());
    }
}


class PizzaOrderSystem {
    public static void main(String[] args) {
        Food pizza = new HawaiiPizza(2);
        pizza = new MushRoomToppings(pizza);
        SimpleItem s = new SimpleItem(5, 4);
        Order order = new Order();
        order.add(pizza);
        order.add(s);
        
        CouponStrategy coupon =CouponFactory.generateCoupon("AAA");
        coupon.apply(order.subtotalPrice());
        
        System.out.println(coupon.apply(order.subtotalPrice()));

    }
}


// interface Food {
//     double calculate();
// }

// abstract class PizzaDecorator implements Food {  //可以是任何东西
//     Food food;
//     PizzaDecorator(Food food) {
//         if (food == null) throw new IllegalArgumentException("food is null");
//         this.food=food;
//     }

//     @Override
//     public double calculate() {
//         return food.calculate();
//     }
// }

// abstract class Pizza implements Food {
//     int size; //1, 2, 3

//     Pizza (int size) {
//         this.size = size;
//     }

//     abstract double basePrice();

//     double sizeMultiplier() {
//         switch (size) {
//             case 1: return 0.8;
//             case 2: return 1.0;
//             case 3: return 1.5;
//             default:
//                 throw new IllegalArgumentException("Invalid size: " + size);
//         }
//     }

//     @Override
//     public double calculate() {
//         return basePrice() * sizeMultiplier();
//     }
// }

// class HawaiiPizza extends Pizza {
//     HawaiiPizza(int size) {
//         super(size); 
//     }

//     @Override
//     double basePrice() {
//         return 10;
//     }
// }

// class MixPizza extends Pizza {  
//     MixPizza(int size) {
//         super(size); 
//     }

//     @Override
//     double basePrice() {
//         return 12;
//     }
// }


// class PepoToppings extends PizzaDecorator {
//     PepoToppings(Food food) {
//         super(food);
//     }
    
//     @Override
//     public double calculate() {
//         return this.food.calculate()+1;
//     }
// }

// class SauageToppings extends PizzaDecorator {
//     SauageToppings(Food food) {
//         super(food);
//     }
    
//     @Override
//     public double calculate() {
//         return this.food.calculate()+3;
//     }
// }

// class SimpleItem implements Food {
//     double unitPrice;
//     int qty;

//     SimpleItem(double unitPrice, int qty) {
//         this.unitPrice = unitPrice;
//         this.qty = qty;
//     }

//     @Override
//     public double calculate() { return unitPrice * qty; }
// }

// interface CouponStrategy {
//     double apply(double subtotal);
// }

// class NoCoupon implements CouponStrategy {
//     public double apply(double subtotal) { return subtotal; }
// }

// class AAACoupon implements CouponStrategy {
//     public double apply(double subtotal) {
//         return subtotal > 10 ? subtotal * 0.9 : subtotal;
//     }
// }

// class BBBCoupon implements CouponStrategy {
//     public double apply(double subtotal) {
//         return subtotal > 50 ? subtotal * 0.8 : subtotal;
//     } 
// }

// class Order {
//     private final List<Food> items = new ArrayList<Food>();
//     private CouponStrategy coupon = new NoCoupon(); // 默认无券

//     public void add(Food item) { items.add(item); }

//     public void setCoupon(CouponStrategy coupon) {
//         this.coupon = (coupon == null) ? new NoCoupon() : coupon;
//     }

//     public double subtotal() {
//         double sum = 0.0;
//         for (Food f : items) sum += f.calculate();
//         return sum;
//     }

//     public double total() {
//         return coupon.apply(subtotal());
//     }
// }

// class PizzaOrderSystem {
//     public static void main(String[] args) {
//         Food pizza = new HawaiiPizza(2);
//         pizza = new PepoToppings(pizza);
//         pizza = new SauageToppings(pizza);

//         Food drink = new SimpleItem(2.0, 2);
//         Order order = new Order();
//         order.add(pizza);
//         order.add(drink);

//         order.setCoupon(new AAACoupon());

//         System.out.println("Subtotal=" + order.subtotal());
//         System.out.println("Total=" + order.total());
//     }
// }

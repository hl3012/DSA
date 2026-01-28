
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Tesla", "Red");
        myCar.displayInfo();
        myCar.accelerate(0);
        myCar.brake();
        myCar.displayInfo();
    }
}

class Car {
    private String brand;
    private String color;
    private int speed;
    
    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0;
    }
    
    public void accelerate(int increase) {
        speed += increase;
        System.out.println(brand + " accelarate " + speed + " km/h");
    }
    
    public void brake() {
        speed = 0;
        System.out.println(brand + " stopped");
    }
    
    public void displayInfo() {
        System.out.println("brand: " + brand + ", color: " + color + ", speed: " + speed + " km/h");
    }
    

    public String getBrand() { return brand; }
    public String getColor() { return color; }
    public int getSpeed() { return speed; }
}

class Vehicle {
    move() {
        throw new Error("move() must be implemented");
    }
}

class Car extends Vehicle {
    constructor(brand) {
        super();
        this.brand = brand;
    }
    move() {
        console.log(`${this.brand} car is moving`);
    }
}

class Bike extends Vehicle {
    move() {
        console.log(`bike is moving`);
    }
}

class Garage {
    #vehicles =[];

    addVehicle(vehicle) {
        
    }
}
from abc import ABC, abstractmethod

# abastract class
class Drive(ABC):
    @abstractmethod
    def drive(self):
        pass
    
# interface
class Electric(ABC):
    @abstractmethod
    def charge(self):
        pass


class Car(Drive, ABC):
    wheels=4
    def __init__(self, brand, model):
        self.brand=brand
        self.model=model
        
  
    
        
class ElectricCar(Car, Electric):
    def __init__(self, brand, model):
        super().__init__(brand, model)
        
    def charge(self):
        print("charging the electric car")
        
    def drive(self):
        print("driving the electric car")
    
class gasCar(Car):
    def __init__(self, brand, model):
        super().__init__(brand, model)
        
    def drive(self):
        print("driving the gas car")
        
def main():
    car1= ElectricCar("tesla", "model 3")
    car2 = gasCar("tesla", "")
    print(car1.brand==car2.brand)
    car1.charge()
    car1.drive()
    car2.drive()
    vehicles=[car1, car2]
    for v in vehicles:
        v.drive()
    print(car1.wheels)
    print(car2.wheels)
    print(car1.brand)
    print(car1.wheels+car2.wheels)
    
if __name__=="__main__":
    main()


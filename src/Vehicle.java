public class Vehicle {
    void speedUp(){
        System.out.println("Vehicle accelerating");
    }
}

class Car extends Vehicle{
    @Override
    void speedUp(){
        System.out.println("Car accelerating by 22 units");
    }
    void drift(){
        System.out.println("Performing a drift!");
    }
}
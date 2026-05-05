public class Main{
    public static void main(String[] args){
        Vehicle myVehicle = new Car();
        myVehicle.speedUp(); // Output: Vehicle accelerating
    
        Car car = (Car) myVehicle;
        car.drift();   // Output: Performing a drift!
    }
}
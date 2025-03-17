package Records;

public class Carmain {
    public static void main(String[] args){
        Car car = new Car("231G1234","Joe Bloggs");
        System.out.println(car);
        System.out.println(car.getOwner());
        System.out.println(car.getRegNumber());

        CarRecord carRecord = new CarRecord("231G4321","Mary Bloggs");
        System.out.println(carRecord);
        System.out.println(carRecord.owner());
        System.out.println(carRecord.regNumber());

        System.out.println(carRecord.isNewCar());
        System.out.println(carRecord.createBlankCarRecord());
    }
}

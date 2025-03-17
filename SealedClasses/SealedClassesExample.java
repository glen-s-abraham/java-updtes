package SealedClasses;

sealed interface Drivable permits Vehicle{

    
}

sealed class Vehicle implements Drivable permits Car{

}


//Permitted type Car does not declare SealedClasses.Vehicle as a direct supertype
//The class Car with a sealed direct supertype Vehicle should be declared either final, sealed, or non-sealed
// class Car{

    
// } 


sealed class Car extends Vehicle permits Ford, Volvo{

}

final class Ford extends Car{}
final class Volvo extends Car{}

public class SealedClassesExample {

    
}
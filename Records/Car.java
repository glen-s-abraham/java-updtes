package Records;

public class Car {
    private String regNumber;
    private String owner;

    // Default constructor
    public Car() {
    }

    // Parameterized constructor
    public Car(String regNumber, String owner) {
        this.regNumber = regNumber;
        this.owner = owner;
    }

    // Getter for regNumber
    public String getRegNumber() {
        return regNumber;
    }

    // Setter for regNumber
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    // Getter for owner
    public String getOwner() {
        return owner;
    }

    // Setter for owner
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Optional: Overridden toString method for easy printing
    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}

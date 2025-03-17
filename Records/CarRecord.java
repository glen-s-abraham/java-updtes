package Records;

//Record created to subsctitute the Car POJO.
record CarRecord(String regNumber, String owner) {
    public static final String currentYear = "23";

    // Canonical Constructor
    // public CarRecord(String regNumber, String owner) {
    // if (regNumber.length() <= 4) {
    // throw new IllegalArgumentException();
    // }
    // this.regNumber = regNumber;
    // this.owner = owner;
    // }

    // Non canonical constructor
    public CarRecord() {
        this("     ", "");

    }

    // Compact constructors
    public CarRecord {
        if (regNumber.length() <= 4) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNewCar() {
        return regNumber().substring(0, 2).equals(currentYear);
    }

    public static CarRecord createBlankCarRecord() {
        return new CarRecord("     ", "");
    }

    @Override
    public String owner(){
        return owner.toUpperCase();
    }
}

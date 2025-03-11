package PrivateInterfaceMethods;

interface InefficientTennis {
    static void forehand() {
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into ready position");
    }

    default void backhand() {
        System.out.println("Move into position");
        System.out.println("Hitting a backhand");
        System.out.println("Move back into ready position");
    }

    default void smash() {
        System.out.println("Move into position");
        System.out.println("Hitting a smash");
        System.out.println("Move back into ready position");
    }

}

interface Tennis {
    private static void hit(String stroke) {
        System.out.println("Move into position");
        System.out.println("Hitting a " + stroke);
        System.out.println("Move back into ready position");
    }

    static void forehand() {
        hit("forehand");
    }

    default void backhand() {
        hit("backhand");
    }

    private void smash() {
        hit("smash");
    }
}

class ProfessionalTennis implements Tennis{

}

public class SportTest {
    public static void main(String[] args) {
       Tennis tennis = new ProfessionalTennis();
       tennis.backhand();
       Tennis.forehand();
    }
}

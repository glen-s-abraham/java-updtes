package Lambdas;
public class Lambda {

    public static void main(String[] args) {
        I lambdaI = ()->{
            System.out.println("Test lambda");
        };
        lambdaI.m();
    }
}
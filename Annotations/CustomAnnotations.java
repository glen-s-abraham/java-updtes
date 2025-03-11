package Annotations;

enum Device {
    LAPTOP, PHONE
}

@interface Human {
}

@interface OnWeb {
    int startTime() default 9;

    int hoursPerDay();

    int PEAK_TIME_START = 19;
    public static final int PEAK_TIME_END = 22;

    String name() default "SK";

    Device consume() default Device.LAPTOP;

    Class humanOrBot() default Human.class;

    Human extraInfo() default @Human;

    String[] sites() default { "S", "K" };
}

@OnWeb(hoursPerDay = 6)
@Human
class Student {
}

@OnWeb(hoursPerDay = 3, startTime = 18)
@Human
class Worker {
}

public class CustomAnnotations {

}

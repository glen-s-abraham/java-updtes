package Annotations;

@interface Team {
    String value() default "Soccer";

    int numPlayers() default 2;
}

class Sport {
    @Team(numPlayers = 6, value = "Volleyball")
    void beach() {
    };

    @Team(value = "Tennis")
    void strawberriesAndCream() {
    };

    @Team("Curling")
    void slow() {
    };
}

@interface Quiz {
    String[] topics();
}

class Competitor {
    @Quiz(topics = { "General Knowledge", "Music" })
    String favouriteTopic;
    @Quiz(topics = { "Sports" })
    String leastFavouriteTopic;
    @Quiz(topics = "Sports")
    String leastOtherFavouriteTopic;
}

@interface Colours {
    String[] value(); // "value" element AND an array
}

class TestRainbow {
    @Colours(value = { "Red" })
    String colour1; // all details provided i.e. "value" and array {}
    @Colours(value = "Red")
    String colour2; // shorthand for single element array i.e. {} omitted
    @Colours({ "Red" })
    String colour3; // shorthand for "value" element i.e. "value=" omitted, array {} included
    @Colours("Red")
    String colour4; // shorthand for both "value" element and single element array
                    // - "value=" omitted and array {} omitted
}

public class Shorthand {
    public static void main(String[] args) {

    }
}

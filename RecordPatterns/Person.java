package RecordPatterns;

public record Person(String name, Integer age) {
}

enum Ability {
    WEAK, AVEAGE, STRONG
}

record Player(Person person, Ability ability) {
}

record Doubles(Player player1, Player player2) {
}

record Pair<T>(T x, T y) {
}
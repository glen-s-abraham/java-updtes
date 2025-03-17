package SwitchExpression;

enum Direction {NORTH,SOUTH,EAST,WEST}

public class SwitchExpressions {
    public static void main(String[] args) {
        Direction d = Direction.NORTH;

        int numletters = 0;
        switch (d) {
            case NORTH:
            case SOUTH:
                numletters=5;
                break;
            case EAST:
            case WEST:
                numletters=4;
                break;
        }
        System.out.println(numletters);


        System.out.println(switch(d){
            case NORTH,SOUTH -> 5;
            default -> 4;
        });
    }
}

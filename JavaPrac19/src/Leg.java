public class Leg {
    private final String side;
    public Leg(char side) {
        if (side == 'R') {
            this.side = "right";
        }
        else if (side == 'L') {
            this.side = "left";
        }
        else {
            this.side = "undefined";
        }
    }

    public void step() {
        System.out.println("Step with "+side+" leg");
    }
}

public class Hand {
    private final String side;

    public Hand(char side) {
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

    public void grab(String item) {
        System.out.println("Grabbed "+item+" with "+side+" hand");
    }
    public void lift(String item) {
        System.out.println("Lifted "+item+" with "+side+" hand");
    }
}

public class Human {
    private String name;
    private int age;
    private Head head = new Head();
    private Leg legR = new Leg('R'), legL = new Leg('L');
    private Hand handR = new Hand('R'), handL = new Hand('L');

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setHairStyle(String hair, String hairColor) {
        head.setHair(hair);
        head.setHairColor(hairColor);
    }
    public String getHairStyle() { return head.getHair()+" "+head.getHairColor(); }

    public void walk() {
        legR.step();
        legL.step();
        System.out.println("And so it goes...");
    }

    public void agree() {
        System.out.print(this.name+" agreed and made ");
        head.nod();
    }

    public void decline() {
        System.out.print(this.name+" declined with ");
        head.shake();
    }

    public void grab(char hand, String item) {
        if (hand == 'R') { handR.grab(item); }
        else { handL.grab(item); }
    }

    public void lift(char hand, String item) {
        if (hand == 'R') { handR.lift(item); }
        else { handL.lift(item); }
    }
}

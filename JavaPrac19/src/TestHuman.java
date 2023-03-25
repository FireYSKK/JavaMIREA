public class TestHuman {
    public static void main(String[] args) {
        Human human = new Human("Ivan", 20);
        human.setHairStyle("Short", "blonde");
        System.out.println(human.getHairStyle());
        human.walk();
        human.grab('R', "pen");
        human.lift('L', "box");
        human.agree();
        human.decline();
    }
}

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        ChairFactory chairFactory = new ChairFactory();

        client.sit();

        client.setChair(chairFactory.createVictorianChair());
        System.out.println("Викторианскому стулу " + ((VictorianChair) client.chair).getAge() + " лет");

        client.setChair(chairFactory.createMagicChair());
        ((MagicChair) client.chair).doMagic();

        client.setChair(chairFactory.createFunctionalChair());
        System.out.println("Стул умеет считать: 3 + 16 = " + ((FunctionalChair) client.chair).sum(3, 16));

    }
}
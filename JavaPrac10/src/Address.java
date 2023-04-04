import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String building;
    private String frame;
    private String flat;

    public Address(){}

//    public Address(String address){
//        address = address.trim();
//        // Реализация через split
//        String[] strings = address.split(", ");
//        country = strings[0];
//        region  = strings[1];
//        city    = strings[2];
//        street  = strings[3];
//        building   = strings[4];
//        frame   = strings[5];
//        flat    = strings[6];
//    }

    public Address(String address) {
        address = address.trim();
        // Реализация через StringTokenizer
        StringTokenizer strings = new StringTokenizer(address, " -.,:", false);
        country  = strings.nextToken();
        region   = strings.nextToken();
        city     = strings.nextToken();
        street   = strings.nextToken();
        building = strings.nextToken();
        frame    = strings.nextToken();
        flat     = strings.nextToken();
    }

    @Override
    public String toString() {
        return country + ", " + region + ", " + city + ", " + street + ", " + building + ", " + frame + ", " + flat;
    }

    public void test() {
        Address address1 = new Address("Russia. Moscow: Moscow- Vernadskogo- 78: 1: IVC103");
        System.out.println(address1);

        Address address2 = new Address("Russia, Moscow, Moscow, Yugorskiy, 22, 2, 55");
        System.out.println(address2);

        Address address3 = new Address("Japan. Tokyo::: Chiyoda., Sotokanda, 14-- 2, 1");
        System.out.println(address3);

        Address address4 = new Address("Ireland Dublin Portobello Walworth 3 1 10");
        System.out.println(address4);
    }
}
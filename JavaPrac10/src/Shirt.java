import java.util.StringTokenizer;

public class Shirt {
    private String id;
    private String type;
    private String color;
    private String size;

    public Shirt(){}

    public Shirt(String shirt) {
        String[] strings = new String[4];
        strings = shirt.split(",");
        id    = strings[0];
        type  = strings[1];
        color = strings[2];
        size  = strings[3];
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public void test() {
        String[] strings = new String[11];
        strings[0]  = "S001,Black Polo Shirt,Black,XL";
        strings[1]  = "S002,Black Polo Shirt,Black,L";
        strings[2]  = "S003,Blue Polo Shirt,Blue,XL";
        strings[3]  = "S004,Blue Polo Shirt,Blue,M";
        strings[4]  = "S005,Tan Polo Shirt,Tan,XL";
        strings[5]  = "S006,Black T-Shirt,Black,XL";
        strings[6]  = "S007,White T-Shirt,White,XL";
        strings[7]  = "S008,White T-Shirt,White,L";
        strings[8]  = "S009,Green T-Shirt,Green,S";
        strings[9]  = "S010,Orange T-Shirt,Orange,S";
        strings[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt[] shirts = new Shirt[11];

        for (int i = 0; i < strings.length; i++) {
            shirts[i] = new Shirt(strings[i]);
        }

        for (Shirt shirt : shirts) {
            System.out.println(shirt.toString());
        }
    }
}
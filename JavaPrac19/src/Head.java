public class Head {
    private String hair;
    private String hairColor;
    public Head(String hair, String hairColor) {
        this.hair = hair;
        this.hairColor = hairColor;
    }
    public Head() {
        this.hair = "Bald";
        this.hairColor = "None";
    }
    public void setHair(String newHair) {
        this.hair = newHair;
    }
    public void setHairColor(String newHairColor) {
        this.hairColor = newHairColor;
    }
    public String getHair() {
        return hair;
    }
    public String getHairColor() {
        return hairColor;
    }

    public void nod() {
        System.out.println("Headnod");
    }
    public void shake() {
        System.out.println("Headshake");
    }
}

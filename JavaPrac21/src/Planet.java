public class Planet implements Nameable{
    private String name;

    public Planet(String name){
        setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

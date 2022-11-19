final class Dish implements Item{
    private final String title;
    private final String description;
    private final int price;

    public Dish(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Dish(String title, String description) {
        this.title = title;
        this.description = description;
        price = 0;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
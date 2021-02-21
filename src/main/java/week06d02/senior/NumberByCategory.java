package week06d02.senior;

public class NumberByCategory {

    private Category category;

    private int number;

    public NumberByCategory(Category category, int number) {
        this.category = category;
        this.number = number;
    }

    public Category getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }
}

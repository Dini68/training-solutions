package introconstructors;

public class RestaurantMain {

    public static void main(String[] args) {


        Restaurant restaurant = new Restaurant("Gulliver Étterem", 20);

        System.out.println(restaurant.getName());
        System.out.println(restaurant.getCapacity() + " fő fér el.");
        System.out.println(restaurant.getMenu());
    }
}

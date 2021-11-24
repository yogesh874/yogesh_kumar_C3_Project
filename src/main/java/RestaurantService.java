import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

   public int getTotalSum(List<Item> li){

        return li.stream().map(item -> (int)item.getPrice()).mapToInt(i -> i).sum();
    }

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
    	
    	return restaurants.stream().filter(v -> v.getName().equals(restaurantName)).findFirst().orElseThrow(() -> new restaurantNotFoundException("Restaurant not  found"));
        
     
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}

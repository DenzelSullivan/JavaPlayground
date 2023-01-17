import java.util.ArrayList;
import java.util.HashMap;

public class MapExample {

    public static void main(String[] args){
        ArrayList<String> array = new ArrayList<>();
        array.add("This");
        array.add("That");
        array.add("They");
        array.add("This");
        array.add("This");

        MapExample exampleMap = new MapExample();

        for (String value: array) {
            exampleMap.updateMap(value);
        }

        exampleMap.printMap();
    }

    private HashMap<String, Integer> map = new HashMap<>();

    private void updateMap(String key){
        boolean hasValue = map.containsKey(key);
        if (hasValue){
            Integer value = map.get(key);
            value++;
            map.put(key, value);
        } else {
            map.put(key, 1);
        }
    }

    private void printMapValue(String key){
        System.out.println(key + ": " + map.get(key));
    }

    private void printMap(){
        for(String key : map.keySet()){
            printMapValue(key);
        }
    }
}

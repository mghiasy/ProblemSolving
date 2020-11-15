
import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        Map< Integer, String> map=new HashMap<Integer, String>();
        map.put(101, "Hemendra");
        map.put(99, "Andrew");
        map.put(103, "Anish");
        map.put(18, "Mohan");
        map.put(11, "Christine");
        map.put(109, "Rebeca");
        map.put(111, "David");
        map.put(19, "Rahim");
        map.put(10, "Krishna");

       List<Map.Entry<Integer,String>> sortedList= new ArrayList<>(map.entrySet());
        Collections.sort(sortedList,Map.Entry.comparingByValue());

    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PagingAndSortList {
    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // Write your code here
        int startIndex= itemsPerPage*(pageNumber-1);
        int endIndex = (itemsPerPage+ startIndex -1) > items.size() ? items.size() : (itemsPerPage+ startIndex -1);


        Comparator<List<String>> aa= (entry1, entry2) -> {
            if (sortParameter == 0) {
                if (sortOrder == 0) {
                    return entry1.get(sortParameter).compareTo(entry2.get(sortParameter));
                }
                return entry2.get(sortParameter).compareTo(entry1.get(sortParameter));
            } else {
                if (sortOrder == 0) {
                    return Integer.parseInt(entry1.get(sortParameter)) - Integer.parseInt(entry2.get(sortParameter));
                }
                return Integer.parseInt(entry2.get(sortParameter)) - Integer.parseInt(entry1.get(sortParameter));
            }
        };
        Collections.sort(items,aa);
        List<String> tempList = new ArrayList<>();
        for(int i=startIndex; i<= endIndex;++i){

            tempList.add(items.get(i).get(0));
        }

        return tempList;
    }

    public static void main(String[] args) {
        List<List<String>> xx = new ArrayList<>();
        List<String> x = new ArrayList<>();
        x.add("item1"); x.add("45"); x.add("22");
        xx.add(x);

        List<String> x2 = new ArrayList<>();
        x2.add("item2"); x2.add("98"); x2.add("32");
        xx.add(x2);

        List<String> x3 = new ArrayList<>();
        x3.add("item3"); x3.add("12"); x3.add("322");
        xx.add(x3);
        System.out.println(fetchItemsToDisplay(xx, 1,0,3,1));
    }
}

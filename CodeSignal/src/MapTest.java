package Amazon;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {

        System.out.println("OASDFGH".replace('O', 'T'));
        System.out.println("Welcome to geeksforgeeks".replaceAll("eek","TT"));
        System.out.println("Maryam1234GGH".replaceAll("[^A-Za-z]",""));//not A-Z and not a-z
        Map<String,Double> empMapTest = Map.of("David",122.2,"John",122.2,"Mark",90.1);
        System.out.println("Welcome to geeksforgeeks".replaceFirst("geek","Mari"));
        Map<String,Double> empMapTest2 = new HashMap<>();
        empMapTest2.putAll(empMapTest);

        if(empMapTest2.isEmpty()) {
            System.out.println("emp");
        }
        if(!empMapTest2.isEmpty()) {
            System.out.println("noemp");
        }
        for(Map.Entry<String,Double> entry: empMapTest2.entrySet()){
            System.out.println(entry.getKey() +"=>"+entry.getValue());
        }

        //----------set -------------------------
        Set<Integer> see = new HashSet<>() ;
        System.out.println("-------------Hash table--------------");
        see.add(1);
        Set<String> see2 = new HashSet<String>(Arrays.asList("12", "12", "12"));
        Set<String> see3= Stream.of("AL", "AL", "AL").collect(Collectors.toSet());
        for(String item:see2){
            System.out.println(item);
        }
        boolean b =see2.addAll(see3);
        System.out.println("-------------see2--------------");
        for(String item:see2){
            System.out.println(item);
        }
        boolean cc =see2.containsAll(see3);
        see2.removeAll(see3);
        System.out.println("-------------see2--------------");
        for(String item:see2){
            System.out.println(item);
        }
        System.out.println(cc);


        //----------hashtable -------------------------
        Hashtable<Integer,String> ht=new Hashtable<Integer,String>(); //remove repeated
        ht.put(101," ajay");
        ht.put(101,"Vijay");
        ht.put(102,"Ravi");
        ht.put(103,"Vijay");
        //ht.put(null,null);
        System.out.println("-------------Hash table--------------");
        for (Map.Entry m:ht.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        //----------------hashmap--------------------------------
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(100,"Amit");
        hm.put(104,"Amit");  // hash map allows duplicate values
        hm.put(101,"Vijay");
        hm.put(102,"Rahul");
        hm.put(null,null);
        hm.put(null,"222");
        System.out.println("-----------Hash map-----------");
        for (Map.Entry m:hm.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        //----------------linkedhashmap--------------------------------
        HashMap<Integer,String> lhm=new LinkedHashMap<Integer,String>();
        lhm.put(100,"Amit");
        lhm.put(104,"Amit");  // hash map allows duplicate values
        lhm.put(101,"Vijay");
        lhm.put(102,"Rahul");
        System.out.println("-----------linkedhashmap -----------");
        for (Map.Entry m:lhm.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }




    }
}

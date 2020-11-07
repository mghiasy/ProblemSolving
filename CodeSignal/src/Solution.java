import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Main class should be named 'Solution'
class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/root/customers/data.csv"));
        int countryCstNo=0, cityCount = 0;
        String countryName="";
        Map<String, Integer> cityMap = new TreeMap<>();
        Map<String, Integer> countryMap = new TreeMap<>();
        // Comparator<String> c = Comparator.comparing((String s1, String s2) -> s1.compareTo(s2));
        Map<String, Integer> contractMap = new TreeMap<>(new Comparator<String>(){
            public int compare(String o1, String o2){
                return o2.compareTo(o1);
            }
        });
        Set<String> ids = new HashSet<>();
        String line;
        while((line = br.readLine()) != null){
            String[] value = line.split(",");
            if(value[0].equals("ID")){
                continue;
            }
            ids.add(value[0]);
            cityMap.put(value[2], cityMap.getOrDefault(value[2], 0) + 1);
            countryMap.put(value[3], countryMap.getOrDefault(value[3], 0) + 1);
            // contractMap.put(value[3], contractMap.getOrDefault(value[3], value[6]) + value[6]));
            if(!contractMap.containsKey(value[3])){
                contractMap.put(value[3],Integer.valueOf(value[6]));
            }
            else{
                contractMap.put(value[3],contractMap.get(value[3])+Integer.valueOf(value[6]));
            }
        }
        for(Map.Entry<String, Integer> entry: contractMap.entrySet()){
            if(entry.getValue()>countryCstNo){
                countryCstNo = entry.getValue();
                countryName = entry.getKey();
            }
        }
        System.out.println("Total customers:");
        System.out.println(ids.size());
        System.out.println("Customers by city:");
        for(Map.Entry<String, Integer> entry: cityMap.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
            if(entry.getValue()>=1) cityCount++;
        }
        System.out.println("Customers by country:");
        for(Map.Entry<String, Integer> entry: countryMap.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println("Country with the largest number of customers' contracts:");
        // for(Map.Entry<String, Integer> entry: contractMap.entrySet()){
        //     System.out.println(entry.getKey()+": "+entry.getValue());
        // }
        System.out.println(countryName+" ("+countryCstNo+ " contracts)");

        System.out.println("Unique cities with at least one customer:");
        System.out.println(cityCount);
    }


}
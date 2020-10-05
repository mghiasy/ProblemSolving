package HackerRank;

import java.util.*;

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        List<String>subsetList=new ArrayList<>();
        int count=0;
        for (int startPoint=0;startPoint<s.length();++startPoint){
            for(int endpoint=startPoint;endpoint<s.length();++endpoint){
                subsetList.add(s.substring(startPoint,endpoint+1));
            }
        }
        List<int[]> tempList = new ArrayList<>();
        int[] temp ;
        String item ="";
        for (int i=0;i<subsetList.size();++i){
            temp =new int[29];
            item = subsetList.get(i);
            for(char c:item.toCharArray()){
                temp[(int)c-97]++;
            }
            tempList.add(temp);
        }
        for (int i=0;i<tempList.size();++i){
            for(int j=i+1;j<tempList.size();++j){
                if(Arrays.equals(tempList.get(i),tempList.get(j)))count++;
            }
        }
        return count;

//    for(int i=1; i<=s.length();++i) {
//        if(mapSubsets.containsValue(i)) {
//            int tempId= i;
//            List<String> sameLenghttemp = mapSubsets.entrySet().stream().filter(x->x.getValue()==tempId).map(z->z.getKey()).collect(Collectors.toList());
//            List<String> temp,temp2 = new ArrayList<>();
//
//            if(sameLenghttemp.size()>1) {
//                for (int j = 0; j < sameLenghttemp.size(); ++j) {
//                    temp =Arrays.asList(sameLenghttemp.get(j).split(""));
//                    for (int k = j + 1; k < sameLenghttemp.size(); ++k) {
//                        temp2 =Arrays.asList(sameLenghttemp.get(k).split(""));
//                        if(temp.containsAll(temp2))
//                        { count++;}
//                    }
//                }
//            }
//        }
//    }

    }

    public static void main(String[] args) {
        String s = "abba";
        sherlockAndAnagrams(s);
    }
}

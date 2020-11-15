package HackerRank;

import java.util.*;
//time : O(n^2+ n^2+ n)=O(2n^2+n)  => o(n^2)
//Space: O(2n)=O(n+2n+n)=O(4n) =>O(n)
public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        int minDeletion=0;
        Map<String,Integer> aMap=new HashMap<>();//space:O(n)
        for (String item: a.split("")) {//O(n^2) //space:O(2n)
            if(aMap.containsKey(item)){
                aMap.put(item,aMap.get(item)+1);
            }
            else{
                aMap.put(item,1);
            }
        }
        Map<String,Integer> bMap=new HashMap<>();//space:O(n)
        for (String item: b.split("")) {//O(n^2)
            if(bMap.containsKey(item)){
                bMap.put(item,bMap.get(item)+1);
            }
            else{
                bMap.put(item,1);
            }
        }
        int tempValue=0;
        for (Map.Entry<String,Integer> aEntry:aMap.entrySet()) {//O(n)
            if(!bMap.containsKey(aEntry.getKey())){
                minDeletion+=aEntry.getValue();
            }
            else {
                tempValue=bMap.get(aEntry.getKey());
                if(aEntry.getValue()!=tempValue){
                    minDeletion=minDeletion+Math.abs(aEntry.getValue()-tempValue);
                }
            }
        }
        for (Map.Entry<String,Integer> bEntry:bMap.entrySet()) {
            if(!aMap.containsKey(bEntry.getKey())){
                minDeletion+=bEntry.getValue();
            }
        }
        return minDeletion;
    }

    public static void main(String[] args) {
        String a="fcrxzwscanmligyxyvym";
        String b= "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(makeAnagram(a,b));
    }
}

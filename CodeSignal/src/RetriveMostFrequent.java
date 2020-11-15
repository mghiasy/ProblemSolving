package Amazon;

import java.util.*;

public class RetriveMostFrequent {
    public static List<String> retrieveMostFrequentlyUsedWords(String helpText, List<String> wordsToExclude){
        //modify helpText and remove any number and special character except character '(for the words like can't)
        String modifiedHelpText = helpText.toLowerCase().replaceAll("[^a-zA-Z']", " ");
        //sometime create two white spaces -->change it to one space.
        String modifiedHelpText2 = modifiedHelpText.replace("  ", " ");
        List<String> helpTextArray = Arrays.asList(modifiedHelpText2.split(" "));
        Map<String, Integer> map = new HashMap<>();

        //create map , Key = text , value = repeat count
        //O(n*m)
        for(String item :helpTextArray){//o(n)
                if (!wordsToExclude.contains(item))//O(m)
                    map.put(item, map.getOrDefault(item, 0) + 1);
        }
        //create a List of string for result
        List<String> resultStr= new ArrayList<>();
        //loop over map entries and add every item which value>1 to result list
        for (Map.Entry<String,Integer> entry : map.entrySet())//O(n)
        {
            if(entry.getValue()>1){
                resultStr.add(entry.getKey());
            }
        }

        return  resultStr;
    }

    public static void main(String[] args) {
        //[BIG, PURCHASE, ITEM, ORDER, JACK]
        String helptext="Purchase order item Help cannot find item item is too much part of purchase need fix email purchase";
        String helptx="Purchase jack. jack order item can't find item item is too much part of purchase need fix"+
                "for image item delivered too fast purchase order too big is purchase order coming? Too big why";
        List<String>  wordsToExclude= Arrays.asList("help", "fix","too","is", "of");
        //retriveMostFrequent(helptx,wordsToExclude);
        //List<String> wordsToExclude = Arrays.asList("help", "fix", "too", "is", "of");
        System.out.println(retrieveMostFrequentlyUsedWords(
                "Purchase jack. jack order item can't find item item is too much part of purchase need fix for image item delivered too fast purchase order too big is purchase order coming? Too big why",
                wordsToExclude));

    }
}

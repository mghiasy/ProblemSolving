package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReorderLogFiles {

    //with out stringBuilder:
    //Runtime: 21 ms, faster than 8.33% of Java online submissions for Reorder Data in Log Files.
    //Memory Usage: 40.4 MB, less than 41.88% of Java online submissions for Reorder Data in Log Files.

    //with sb:
    //Runtime: 14 ms, faster than 21.21% of Java online submissions for Reorder Data in Log Files.
    //Memory Usage: 40.3 MB, less than 44.30% of Java online submissions for Reorder Data in Log Files.
    public static String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new LinkedList<>();
        Map<String,String> letterLog= new TreeMap<>();
        String[] res= new String[logs.length];
        StringBuilder sb= new StringBuilder();
        for (int i=0;i<logs.length;++i){
            String[] splitStr = logs[i].split(" ",2);// ==> apply split method 1 time => create 2 sub string
            String identifier = splitStr[0], log = splitStr[1];
          //  String identifier= logs[i].substring(0,logs[i].indexOf(" "));//
            //String log=logs[i].substring(logs[i].indexOf(" ")+1);

            if(log.matches("[0-9 /s]+$")){ //or [0-9 ]+$ => to accept number and space
                digitLogs.add(logs[i]);
            }
            else{
                sb.append(log).append(" ").append(identifier);//use stringBuilder => not to create string in every concat
                letterLog.put(String.valueOf(sb),logs[i]);
                sb.setLength(0);//empty sb after every use
            }
        }
        int p =0;
        for(Map.Entry<String,String> entry:letterLog.entrySet()){
            res[p++]=entry.getValue();
        }
        for(String digit:digitLogs){
            res[p++]=digit;
        }
        return res;
    }

    public void main(String[] args) {
        String[] xx={"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        reorderLogFiles(xx);
    }
}

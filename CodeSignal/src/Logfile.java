package Amazon;

import java.util.*;

public class Logfile {
    class LogItem {
        String content;
        String id;

        LogItem(String content, String id) {
            this.content = content;
            this.id = id;
        }
    }
    public String[] reOrderLine(int logSize, List<String> logs) {
        String id = "";
        String content = "";
        List<String> numbersList = new ArrayList<>();
        List<LogItem> letterList = new ArrayList<>();
        //O(n^2)
        for (String log : logs) {//O(n * m^2)
            int index = log.indexOf(" ");//o(m)
            content = log.substring(index + 1);//o(m) -->m size of the longest string
            id = log.substring(0, index);
            if (content.substring(0, 1).matches("[0-9]+")) {
                //logLine.remove(temp);
                numbersList.add(log);
            } else {
                LogItem logItem = new LogItem(content, id);
                letterList.add(logItem);
            }
        }
        Comparator<LogItem> comp = (LogItem x, LogItem y) -> x.content.equals(y.content) ? x.id.compareTo(y.id) : x.content.toLowerCase().compareTo(y.content.toLowerCase());

        Collections.sort(letterList, comp);

        String[] returnArr = new String[logSize];
        int i=0;
        for (LogItem logItem : letterList) {
            returnArr[i++]=(logItem.id + " " + logItem.content);
        }
        for (String number : numbersList) {
            returnArr[i++]=number;
        }
        return returnArr;
    }

    public static void main(String[] args) {
        Logfile l = new Logfile();
        List<String> logfile = Arrays.asList("a1 9 2 3 1", "g1 act car", "Zo4 4 7", "ab1 off KEY dog", "a8 act Zoo",  "a2 Act car","a1 Act car");
        System.out.println(l.reOrderLine(10, logfile));
    }
}

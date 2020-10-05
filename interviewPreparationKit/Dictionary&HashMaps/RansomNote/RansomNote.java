package HackerRank;

import Amazon.Hacker1;

import java.util.LinkedHashMap;
import java.util.Map;

public class RansomNote {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> mapMag = new LinkedHashMap<>();
        for (int i = 0; i < magazine.length; ++i) {
            if (!mapMag.containsKey(magazine[i])) {
                mapMag.put(magazine[i], 1);
            } else {
                mapMag.put(magazine[i], mapMag.get(magazine[i]) + 1);
            }
        }
        Map<String, Integer> mapNote = new LinkedHashMap<>();
        for (int i = 0; i < note.length; ++i) {
            if (!mapNote.containsKey(note[i])) {
                mapNote.put(note[i], 1);
            } else {
                mapNote.put(note[i], mapNote.get(note[i]) + 1);
            }
        }
        Boolean res = true;
        for (Map.Entry<String, Integer> entryNote : mapNote.entrySet()) {
            // for(Map.Entry<String,Integer> entryMag:mapMag.entrySet()){
            if (mapMag.containsKey(entryNote.getKey())) {
                if (mapMag.get(entryNote.getKey()) < entryNote.getValue()) {
                    res = false;
                    break;
                }
            } else {
                res = false;
                break;
            }

            // }
        }
        if (res == true) System.out.println("Yes");
        else System.out.println("No");
    }
    public static void main(String[] args) {
        String[] magazine = ("give me one grand today night").split(" ");
        String[] note = ("give one grand today").split(" ");
        RansomNote h = new RansomNote();
        h.checkMagazine(magazine,note);
    }
}

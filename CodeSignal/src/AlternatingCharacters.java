package HackerRank;
//time O(n)
//Space O(n)
public class AlternatingCharacters {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int minCount = 0;
       // Map<String, Integer> lhm = new LinkedHashMap<>();
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i + 1) == s.charAt(i)) {
                //lhm.put(s.charAt(i),1);
                minCount++;
            }
        }
        return minCount;
    }

    public static void main(String[] args) {
        String s = "AAABBB";
        System.out.println(alternatingCharacters(s));
    }
}

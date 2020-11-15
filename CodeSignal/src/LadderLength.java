package ServiceNow;

import java.util.*;
class Pair{
    String key;
    int value;

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LadderLength {
    //considering words in wordlist as a nodes in graph where there is a edge if there is just 1 diff => preparation
    //=> return the shortest path from beginWord to endWord by BFS or DFS

    //time limit exceeded
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //preparation =>find all the possible generic/intermediate states
        wordList=new ArrayList<>(wordList);
        Map<String, Set<String>> adjMap = new HashMap<>();
        wordList.add(beginWord);
        int wordSize = beginWord.length();
        char[] wordChar = new char[wordSize];
        //O(N^2 * M)
        for (String word : wordList) { //M times => M= size of wordList
            adjMap.put(word, new HashSet<>());
            wordChar = word.toCharArray();
            for (int i = 0; i < wordSize; ++i) { //N times => N size of every word
                char tmp = wordChar[i];
                for (char c = 'a'; c <= 'z'; ++c) { //29 times
                    wordChar[i] = c;
                    if (wordList.contains(String.valueOf(wordChar)) && !word.equals(String.valueOf(wordChar))) { //N times
                        Set<String> strList = adjMap.get(word);
                        strList.add(String.valueOf(wordChar));
                        adjMap.put(word, strList);
                    }
                }
                wordChar[i]=tmp;
            }
        }
        Map<String, Boolean> visitedMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        visitedMap.put(beginWord, true);
        int level=10;
        //BFS => o(M+NodeCount)
        while (!queue.isEmpty()) {
            Pair tempWord = queue.poll(); //remove the top and return , if q is empty => return null
            level=tempWord.getValue();
            if (tempWord.getKey().equals(endWord)) {
                return level;
            }

            Set<String> tempList = adjMap.get(tempWord.getKey());
            for (String adj : tempList)
                if (!visitedMap.containsKey(adj)) {
                    queue.add(new Pair(adj,level+1));
                    visitedMap.put(adj,true);
                }
        }
        return 0;
    }

    //time limit exceeded
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //preparation =>find all the possible generic/intermediate states
        Set<String> set = new HashSet<>(wordList);
        set.add(beginWord);
        int wordSize = beginWord.length();
        char[] wordChar = new char[wordSize];
        Map<String, Boolean> visitedMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        visitedMap.put(beginWord, true);
        //BFS => o(M+NodeCount)
        while (!queue.isEmpty()) {
            Pair tempWord = queue.poll(); //remove the top and return , if q is empty => return null
            int level=tempWord.getValue();
            if (tempWord.getKey().equals(endWord)) {
                return level;
            }
            for (int i = 0; i < wordSize; ++i) { //N times => N size of every word
                for(String word:set){
                    if(!visitedMap.containsKey(word))
                    if(word.substring(0,i).equals(tempWord.getKey().substring(0,i)) && word.substring(i+1).equals(tempWord.getKey().substring(i+1))){
                        queue.add(new Pair(word,level+1));
                       visitedMap.put(word,true);
                    }
                }
            }
        }
        return 0;
    }
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int x =ladderLength2("hit","cog",Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(x);
    }
}

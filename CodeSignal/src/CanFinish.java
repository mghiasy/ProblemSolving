package LeetCode;

import java.sql.Array;
import java.util.*;

//dfs time complexity = o(M*N) m,.
public class CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //check the graph of prerequisites has loop or not
        Map<Integer, Set<Integer>> map = new HashMap<>(); //map of course and list of classes which are dependent
        List<Integer> vizitedList = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < prerequisites.length; ++i) {//for every node
            st.push(prerequisites[i][0]);
            while (!st.isEmpty()) {
                int temp = st.pop();
                if (!vizitedList.contains(temp)) {
                    vizitedList.add(temp);
                    for (int j = i; j < prerequisites.length; ++j) {
                        if (prerequisites[j][0] == temp){
                            st.push(prerequisites[j][1]);
                            if (!map.containsKey(prerequisites[i][0])) {
                                map.put(prerequisites[i][0], new HashSet<>(List.of(prerequisites[j][1])));
                            } else {
                                Set<Integer> tempList = map.get(prerequisites[i][0]);
                                tempList.add(prerequisites[j][1]);
                                map.put(prerequisites[i][0], tempList);
                            }
                        }
                    }
                }
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().contains(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] x = {{1,0},{2,0},{0,2}};
        System.out.println(canFinish(4, x));
    }
}

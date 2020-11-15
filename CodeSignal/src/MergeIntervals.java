package ServiceNow;

import java.util.*;


public class MergeIntervals {
    //time:O(n^2)
//space:O(n)
    //with change in main array
    //Runtime: 275 ms, faster than 5.10% of Java online submissions for Merge Intervals.
    //Memory Usage: 42.3 MB, less than 56.11% of Java online submissions for Merge Intervals.
    public static int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; ++i) {
            for (int j = i + 1; j < intervals.length; ++j) {
//                    if((intervals[i][0]!=-1 && intervals[j][0]!=-1) &&
//                            (intervals[j][0]<=intervals[i][1] && intervals[j][1]>=intervals[i][1])||
//                            (intervals[i][0]<=intervals[j][1] && intervals[i][1]>=intervals[j][1])){
//                        intervals[j]= new int[]{Math.min(intervals[i][0], intervals[j][0]),Math.max(intervals[i][1], intervals[j][1])};
//                        intervals[i]=new int[]{-1,-1};
//                    }
//                if((intervals[j][0]>intervals[i][0] && intervals[j][1]<intervals[i][1] )||
//                        (intervals[i][0]>intervals[j][0] && intervals[i][1]<intervals[j][1] )){
//                        intervals[i]= new int[]{Math.min(intervals[i][0], intervals[j][0]),Math.max(intervals[i][1], intervals[j][1])};
//                        intervals[j]=new int[]{-1,-1};
//                    }


                //Runtime: 139 ms, faster than 5.10% of Java online submissions for Merge Intervals.
                //Memory Usage: 42 MB, less than 82.57% of Java online submissions for Merge Intervals.
                if ((intervals[i][0] != -1 && intervals[j][0] != -1) &&
                        (intervals[j][0] <= intervals[i][1] && intervals[i][0] <= intervals[j][1])) {
                    intervals[j] = new int[]{Math.min(intervals[i][0], intervals[j][0]), Math.max(intervals[i][1], intervals[j][1])};
                    intervals[i] = new int[]{-1, -1};

                }
            }
        }
        int p = 0;
        for (int k = 0; k < intervals.length; ++k) {
            if (intervals[k][0] != -1)
                res[p++] = intervals[k];
        }
        return Arrays.copyOf(res, p);
    }


    //by sort
    //time: (nlogn) => for sort
    //space :o(n) for sort (if it is not in place)
    //Runtime: 6 ms, faster than 72.30% of Java online submissions for Merge Intervals.
    //Memory Usage: 42.3 MB, less than 56.34% of Java online submissions for Merge Intervals.
    public static int[][] merge2(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();
        //sort based on start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> mergedList = new LinkedList<>();
        for (int i = 0; i < intervals.length; ++i) {
            //if start of the current interval is before end of merged => should be merged
            if (mergedList.isEmpty() || (intervals[i][0] > mergedList.getLast()[1])) { //no overlap
                mergedList.add(intervals[i]);
            } else {//overlap =>change the end
                mergedList.getLast()[1] = Math.max(intervals[i][1], mergedList.getLast()[1]);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }


    public static void main(String[] args) {
        int[][] x = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        merge(x);
    }
}

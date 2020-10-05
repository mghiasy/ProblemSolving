package serviceNow;

import java.lang.reflect.Array;
import java.util.*;

//by graph
//every interval is a node, if there is overlap => there is a edge
//for every connected component => start = min(starts) , end = Max(ends)
public class MergeIntervalByGraph {
    //graph = map<node , LinkedList<Nodes>>
    private Map<int[], List<int[]>> edges;
    private Map<Integer, List<int[]>> nodesInComp;//list of nodes in same component => key= compNo
    private Set<int[]> visited;//for checking visited node , insert and isConsist() =>O(1)


    private boolean overlap(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }

    //build graph => there is edge between a, b iff overlap(a,b)=true
    private void buildGraph(int[][] intervals){
        edges= new HashMap<>();
        //init LinkedList of edges
        for(int[] interval:intervals){
            edges.put(interval,new LinkedList<>());
        }
        for(int[] interval:intervals){
            for(int[] interval2:intervals){
                if(overlap(interval,interval2)){
                   // numbersMap.put(num, numbersMap.getOrDefault(num,0) + 1);
                    //edges.put(interval, edges.getOrDefault(interval,new LinkedList<>()).add(interval2) );=>add returns boolean
                    edges.get(interval).add(interval2);//no need to put again => update inplace
                    //inserting directed edges in both directions to simulate undirected edges
                    edges.get(interval2).add(interval);
                }
            }
        }
    }

    //merge overlapped nodes in component
    private int[] mergesNode(List<int[]> nodes){
        int min= nodes.get(0)[0], max = nodes.get(0)[1];
        for(int[] node:nodes){
            min=Math.min(min,node[0]);
            max=Math.max(max,node[1]);
        }
        return new int[]{min,max};
    }

    //to get every node is belong to which component =>dfs
    private void markCompDfs(int[] interval,int compNo){
        Stack<int[]> stack = new Stack<>();
        stack.push(interval);
        while (!stack.isEmpty()){
            int[] node =stack.pop();
            if(!visited.contains(node)){
                visited.add(node);
                if(!nodesInComp.containsKey(node)){
                    nodesInComp.put(compNo,new ArrayList<>());
                }else {
                    nodesInComp.get(compNo).add(node);
                }
                for(int[] child:edges.get(node)){
                    stack.push(child);
                }
            }
        }
    }

    private void buildComponent(int[][] intervals){
        int compNo=0;
        nodesInComp= new HashMap<>();
        visited= new HashSet<>();
        for(int[] interval:intervals){
            if(!visited.contains(interval)){
                markCompDfs(interval,compNo);
                compNo++;
            }
        }
    }
    //time: (nlogn) => for sort
    //space :o(n) for sort (if it is not in place)

    public static int[][] merge3(int[][] intervals) {
        MergeIntervalByGraph mg = new MergeIntervalByGraph();

        List<int[]> mergedList = new ArrayList<>();
        mg.buildGraph(intervals);
        mg.buildComponent(intervals);

        //for every comp get the min and max => add them to merged list
        for (int comp=0;comp<mg.nodesInComp.size();++comp){
            mergedList.add(mg.mergesNode(mg.nodesInComp.get(comp)));
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }
}

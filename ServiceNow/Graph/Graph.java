package serviceNow;

import java.util.*;

public class Graph {
    Map<Integer, List<Integer>> graph;
    Map<Integer, List<Integer>> nodesInSameComp; //key=compNo
    Set<Integer> visitedNode;

    private void buildGraph(int[] nodes){
        graph= new HashMap<>();
        //init the Map
        for(int node:nodes){
            graph.put(node,new LinkedList<>());
        }
        for(int node:nodes){
            for(int node2:nodes){
                //if there is edge between them
                graph.get(node).add(node2);
                graph.get(node2).add(node);
            }
        }
    }

    private void buildComp(int[] nodes){
        visitedNode=new HashSet<>();
        nodesInSameComp= new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int compNo=0;
        stack.push(nodes[0]);
        while (!stack.isEmpty()){
            int node = stack.pop();
            if(!visitedNode.contains(node)){
                visitedNode.add(node);

                //add node to component
                if(!nodesInSameComp.containsKey(node)){
                    nodesInSameComp.put(compNo,new LinkedList<>());
                }
                else{
                    nodesInSameComp.get(compNo).add(node);
                }
                compNo++;
                //add adjacent to stack
                for(int adjNode:graph.get(node)){
                    stack.push(adjNode);
                }
            }
        }

    }




}

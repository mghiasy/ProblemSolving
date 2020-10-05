package ServiceNow;;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node.*/
class TreeNode {
    int val;
    ServiceNow.TreeNode left;
    ServiceNow.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, ServiceNow.TreeNode left, ServiceNow.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class FindTarget {
    //my solution =>not good
    // if k -currNode.val == currNode.val => we cannot decide to go to left or right
    public static boolean findTarget(ServiceNow.TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        ServiceNow.TreeNode currNode = root;
        while(currNode != null){
            if(set.contains(k-currNode.val)) return true;
            else if(k -currNode.val >currNode.val){
                set.add(currNode.val);
                currNode=currNode.right;
            }
            else if(k -currNode.val <currNode.val){
                set.add(currNode.val);
                currNode=currNode.left;
            }
        }
        return false;
    }
    //use hashset => add values to hash set
    //if contains k-node.val => return true

    //Time complexity : O(n). The entire tree is traversed only once in the worst case. Here, n refers to the number of nodes in the given tree.
    //Space complexity : O(n). The size of the set can grow up to n in the worst case.
    public boolean findTarget2(ServiceNow.TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findHelperMethod(set,root,k);
    }
    public boolean findHelperMethod(Set<Integer> set, ServiceNow.TreeNode node, int k){
        if(node == null) return false;
        if(set.add(k-node.val)== false) return true; // it exists in the set
        set.add(node.val);
        return findHelperMethod(set,node.left,k) || findHelperMethod(set,node.right,k);
    }

    public static void main(String[] args) {
        ServiceNow.TreeNode t = new ServiceNow.TreeNode();
        findTarget(t,1);
    }
}


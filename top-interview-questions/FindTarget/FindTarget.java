package ServiceNow;
/**
 * Definition for a binary tree node.*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }


public class FindTarget {
    //my solution =>should be tested
    public boolean findTarget(TreeNode root, int k) {
        TreeNode currNode = root;
        int tempSum=0;
        while(currNode != null){
            tempSum=currNode.val;
            if(k -currNode.val >currNode.val){
                currNode=currNode.right;
            }
            else if(k -currNode.val <currNode.val){
                currNode=currNode.left;
            }
            else return true;
            if(currNode != null) tempSum+=currNode.val;
            if(tempSum==k) return true;
        }
        return false;
    }
    //use hashset => add values to hash set
    //if contains k-node.val => return true

    //Time complexity : O(n). The entire tree is traversed only once in the worst case. Here, n refers to the number of nodes in the given tree.
    //Space complexity : O(n). The size of the set can grow up to n in the worst case.
    public boolean findTarget2(TreeNode root, int k) {
        TreeNode currNode = root;
        int tempSum=0;
        while(currNode != null){
            tempSum=currNode.val;
            if(k -currNode.val >currNode.val){
                currNode=currNode.right;
            }
            else if(k -currNode.val <currNode.val){
                currNode=currNode.left;
            }
            else return true;
            if(currNode != null) tempSum+=currNode.val;
            if(tempSum==k) return true;
        }
        return false;
    }
}


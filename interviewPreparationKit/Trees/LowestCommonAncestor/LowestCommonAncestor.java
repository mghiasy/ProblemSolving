package HackerRank;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
}
//time worseCase->O(n) Average->O(logn)
//Space O(n)
public class LowestCommonAncestor {
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        int minV= (v1<v2)? v1:v2;
        int maxV=(v1>v2)?v1:v2;
            if(minV>root.data){
                return lca(root.right,v1,v2);
            }
            else if(maxV<root.data){
               return lca(root.left,v1,v2);
            }
            return root;
    }
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

}


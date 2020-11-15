package Flexton;

public class PrintAntiClockWise_BST {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int height(Node root) {
        // Base condition
        if (root == null)
            return 0;

        // Compute the height of each subtree
        int lheight = height(root.left);
        int rheight = height(root.right);

        // Return the maximum of two
        //if there is no left/no right => height =0
        //when return will return 1
        return Math.max(lheight, rheight) + 1;
    }
    static void leftToRight(Node root, int level)
    {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.data + " ");

        else if (level > 1)
        {
            leftToRight(root.left, level - 1);
            leftToRight(root.right, level - 1);
        }
    }

    // Function to Print Nodes from right to left
    static void rightToLeft(Node root, int level)
    {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.data + " ");

        else if (level > 1)
        {
            rightToLeft(root.right, level - 1);
            rightToLeft(root.left, level - 1);
        }
    }
    static void antiClockWiseSpiral(Node root) {
        int i = 1;
        int j = height(root);

        // Flag to mark a change in the direction
        // of printing nodes
        int flag = 0;
        while (i <= j) {
            if (flag == 0)
            {
                rightToLeft(root, i);
                flag = 1;

                // Increment i
                i++;
            }

            // If flag is one print nodes
            // from left to right
            else {
                leftToRight(root, j);
                flag = 0;

                // Decrement j
                j--;
            }
        }
    }
}

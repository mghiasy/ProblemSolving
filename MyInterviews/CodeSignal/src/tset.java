import java.util.Stack;

public class tset {
    static int arr[] = {10, 20, 30, 50, 10, 70, 30};

    static void printMaxOfMin(int n)
    {
        int max=0;
        // Used to find previous and next smaller
        Stack<Integer> s = new Stack<>();

        // Arrays to store previous and next smaller
        int left[] = new int[n+1];
        int right[]  = new int[n+1];

        // Initialize elements of left[] and right[]
        for (int i=0; i<n; i++)
        {
            left[i] = -1;
            right[i] = n;
        }

        // Fill elements of left[] using logic discussed on
        // https://www.geeksforgeeks.org/next-greater-element/
        for (int i=0; i<n; i++)
        {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            if (!s.empty())
                left[i] = s.peek();

            s.push(i);
        }

        // Empty the stack as stack is
// going to be used for right[]
        while (!s.empty())
            s.pop();

        // Fill elements of right[] using same logic
        for (int i = n-1 ; i>=0 ; i-- )
        {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            if(!s.empty())
                right[i] = s.peek();

            s.push(i);
        }


    }

    // Driver method
    public static void main(String[] args)
    {
        printMaxOfMin(3);
    }
}

package LeetCode;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int lastItem = 0;
        for (int i = 1; i <= k; ++i) {//o(n*k)
            lastItem = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; --j) {
                nums[j] = nums[j - 1];
            }
            nums[0] = lastItem;
        }
    }

    //better solution
    public static void rotate2(int[] nums, int k) {
        int next = 0;
        int prev = 0;
        for (int j = 0; j < nums.length; ++j) {
            //prev = nums[j];
            next = (j + k) % nums.length;
            do {
                prev = nums[j];
                nums[j] = nums[next];
                next = prev;
            }
            while (j!=next);
            //nums[j] = temp;
        }
    }

    //best
    //O(n). n elements are reversed a total of three times.
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7};
        rotate2(x, 3);
    }
}

package LeetCode;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
            //the index which goes forward based on condition dont put it in for loop
            int i = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (nums[i] != nums[j]) {
                    //increase index when condition is true
                    i++;
                    nums[i] = nums[j];
                }
            }
        return i + 1;
    }

        public static void main (String[]args){
            int[] n = {1, 1, 1, 1, 1, 1};
            System.out.println(removeDuplicates(n));
        }
    }

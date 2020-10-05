//https://leetcode.com/problems/find-pivot-index/solution/
//where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
//
//If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
public class FindPivot {
        public int pivotIndex(int[] nums) {
            int sum = 0, leftsum = 0;
            for (int x: nums) sum += x;
            for (int i = 0; i < nums.length; ++i) {
                if (leftsum == sum - leftsum - nums[i]) return i;
                leftsum += nums[i];
            }
            return -1;
        }
}

package LeetCode;

public class Trap {
    //Brute force =>time :O(n^2) , space:O(1)
    //Runtime: 40 ms, faster than 7.47% of Java online submissions for Trapping Rain Water.
    //Memory Usage: 39.3 MB, less than 61.95% of Java online submissions for Trapping Rain Water.
    public static int trap(int[] height) {
        int maxLeft=0, maxRight=0;
        int sumTram=0;
        for(int i=1;i<height.length;++i){
            maxLeft=Math.max(height[i-1],maxLeft);
            maxRight=0;
            for(int j=height.length-2;j>=i;--j){
                maxRight=Math.max(height[j+1],maxRight);
            }
            sumTram+= (Math.min(maxLeft,maxRight) - height[i])>=0 ?(Math.min(maxLeft,maxRight) - height[i]) : 0;
        }
        return sumTram;
    }
//Dynamic Programming =>use array => save max and min in arrays ==> O(n)
//Runtime: 1 ms, faster than 95.54% of Java online submissions for Trapping Rain Water.
//Memory Usage: 39.6 MB, less than 45.98% of Java online submissions for Trapping Rain Water.
    public static int trap2(int[] height) {
        if(height.length==0) return 0;
        int[] maxLeft=new int[height.length], maxRight=new int[height.length];
        maxLeft[0]= height[0]; maxRight[height.length-1]= height[height.length-1];
        for(int i=1;i<height.length;++i) {
            maxLeft[i]= Math.max(maxLeft[i-1],height[i-1]);
        }
        for(int j=height.length-2;j>=0;--j){
            maxRight[j]=Math.max(height[j+1],maxRight[j+1]);
        }
        int sumTram=0;
        for(int k=1;k<height.length;++k){
            sumTram+= (Math.min(maxLeft[k],maxRight[k]) - height[k])>=0 ?(Math.min(maxLeft[k],maxRight[k]) - height[k]) : 0;
        }
        return sumTram;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

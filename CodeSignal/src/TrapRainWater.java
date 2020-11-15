package ServiceNow;

//for every node it will be Min(Max of the left heights,Max of the right heights) - its height
public class TrapRainWater {

    //Brute force

    //Runtime: 41 ms, faster than 7.52% of Java online submissions for Trapping Rain Water.
    //Memory Usage: 39.7 MB, less than 43.59% of Java online submissions for Trapping Rain Water.

    //time o(n^2)
    //space :O(1)
    public int trap(int[] height) {
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

    //Dynamic programming

    //Runtime: 1 ms, faster than 95.63% of Java online submissions for Trapping Rain Water.
    //Memory Usage: 39.3 MB, less than 65.02% of Java online submissions for Trapping Rain Water.

    //time :O(n)
    //space : o(n)
    public int trap2(int[] height) {
        int sumTrap=0;
        int[] leftMaxArray= new int[height.length];
        int[] RightMaxArray= new int[height.length];
        leftMaxArray[0]=height[0];
        RightMaxArray[height.length-1]=height[height.length-1];
        for(int i=0;i<height.length-1;++i){
            leftMaxArray[i+1]=Math.max(leftMaxArray[i],height[i]);
        }
        for(int i=height.length-1;i>0;--i){
            RightMaxArray[i-1]=Math.max(RightMaxArray[i],height[i]);
        }
//        int tempSum=0;
        for(int i=0;i<height.length;++i){
//            tempSum=Math.min(leftMaxArray[i],RightMaxArray[i]) - height[i];
//            if( tempSum>0){
//                sumTrap+=tempSum;
//            }
            //better solution

            sumTrap += Math.min(leftMaxArray[i],RightMaxArray[i]) - height[i] >0 ?
                        Math.min(leftMaxArray[i],RightMaxArray[i]) - height[i] :0;
        }
        return sumTrap;
    }
}

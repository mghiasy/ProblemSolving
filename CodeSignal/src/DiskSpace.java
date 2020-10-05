//get the max size of min size in the given window size
import java.util.*;
public class DiskSpace {
    public static int MaxOfMin(int x,List<Integer> s){
        if(x>s.size()) return 0;
        //we want to get the maximum of min of every windows
        int max = 0;
        for(int i=0;i<= s.size()-x;++i){
            int min=s.get(i);
            for(int j=i+1;j<i+x;++j){
                min= Math.min(min,s.get(i));
            }
            max=Math.max(max,min);
        }
        
        return max;
    }
//    public static int MaxOfMin2(int x, List<Integer> s){
//        int n = s.size();
//        if (n * x == 0) return 0;
//        if (x == 1) return nums;
//
//        // init deque and output
//        this.nums = nums;
//        int max_idx = 0;
//        for (int i = 0; i < x; i++) {
//            clean_deque(i, x);
//            deq.addLast(i);
//            // compute max in nums[:x]
//            if (nums[i] > nums[max_idx]) max_idx = i;
//        }
//        int [] output = new int[n - x + 1];
//        output[0] = nums[max_idx];
//
//        // build output
//        for (int i  = x; i < n; i++) {
//            clean_deque(i, x);
//            deq.addLast(i);
//            output[i - x + 1] = nums[deq.getFirst()];
//        }
//        return output;
//    }

    public static void main(String[] args) {
//        int[] arr ={-4,3,2,1};
//        System.out.println(m(arr));
        List x = new ArrayList();
        //x.add(3);
//        x.add(1000000000);
//        x.add(2);
//        x.add(5);
//        x.add(4);
//        x.add(6);
//        x.add(8);

        x.add(8);
        x.add(2);
        x.add(4);


//        Map<String, Integer> map = new ....
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < string.length; i++){
//            if(map.containsKey(String.valueOf(string.charAt(i)))){
//
//            }
//        }


        System.out.println((MaxOfMin(2,x)));
    }
}

package ServiceNow;
import java.util.*;

public class ReverseArray {
    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        Integer[] arr1 = arr.toArray(new Integer[arr.size()]);
        // Write your code here
        for(int i = 0; i < operations.size();++i){
            List<Integer> opt= operations.get(i);
            int start= opt.get(0);
            int end = opt.get(1);
            Integer[] temp =  new Integer[end-start+1];
            //List<Integer> temp = arr.stream().skip(start).limit(end-start).collect(Collectors.toList());
            System.arraycopy(arr1, start, temp, 0, end-start+1);
            temp = reverseArr(temp);
            System.arraycopy(temp, 0, arr1, start, end-start+1);
            int xx=0;
        }
        return Arrays.asList(arr1);
    }

    public static Integer[] reverseArr(Integer[] arr){
        int temp;
        for(int i = 0; i < arr.length / 2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> xx= Arrays.asList(new Integer[]{5, 3, 2, 1, 3});
        List<List<Integer>> op= new ArrayList<>();
        op.add(Arrays.asList(new Integer[]{0,1}));
        op.add(Arrays.asList(new Integer[]{1,3}));
    performOperations(xx,op);
    }
}

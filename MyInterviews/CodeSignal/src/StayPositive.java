import java.util.Arrays;
//the min number to add the first item => so that the leat amount in sequential add is at least 1
public class StayPositive {
    public static int stayPositive(int[] arr){
        int[] newArr= new int[arr.length];
        newArr[0]=0;
        for(int i=1;i<arr.length;++i){
            newArr[i] =arr[i]+newArr[i-1];
        }
        int result=0;
        Arrays.sort(newArr);
        if(newArr[0] <1){

        }
        return 0;
    }

    ///
    public int minStartValue(int[] nums) {
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp = Math.max(1, tmp - nums[i]);
        }
        return tmp;
    }
}

import java.util.*;
//Palindrome is a string which if you reverse it will be the same
public class CheckPalindrome {
    /*boolean checkPalindrome(String inputString) {
        int n = inputString.length()-1;
        int mid1 =0,mid2=0;

        //az ==> len=2 ==> n=1 (1%2==1) => mid1=0,mid2=1
        //123 4 5678. ==> len=8 , n=7 => mid1=3,mid2=4
        //aaa b aaaa ==>len=8 , n=7 => mid1=3,mid2=4

        if(inputString.length()%2 == 0) { //if the count is even
            mid1=n/2; mid2=n/2+1;
        }
        else {//if the count is odd
            //1234 5 6789 ==> len=9
            mid1=n/2-1; mid2= n/2+1;
        }
        for(int i=0,j=n;i<=mid1 && j>=mid2;++i,--j){
            if(inputString.charAt(i) != inputString.charAt(j)) return false;
        }
        return true;
    }*/
    static int maxAbsDiff(List<Integer> px)
    {

//        // To store the minimum and the maximum
//        // elements from the array
//        int minEle = arr[0];
//        int maxEle = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            minEle = Math.min(minEle, arr[i]);
//            maxEle = Math.max(maxEle, arr[i]);
//        }
//
//        return (minEle);
        int [] arr = new int[px.size()];
        int count =0;
        arr[0] =0;
        for(int i=1;i<px.size();++i){
            if(px.get(i) > px.get(i-1)){
                arr[i] =arr[i-1]+1;
            }
            else{
                int j=i;
                while (px.get(j) <px.get(j-1) && j>1){
                    j--;
                }
                if (j>1){
                    arr[i] =arr[i-1]+1;
                }
            }
        }
        for (int num : arr){
            count+=num;
        }
        return count>0?count :-1;
    }

    // Driver code
    public static void main(String[] args)
    {
        List<Integer> arr = new ArrayList<>();
        arr.add(7);
        arr.add(1);
        arr.add(2);
        arr.add(5);
       // int[] arr = { 7, 1, 2, 5 };

        System.out.print(maxAbsDiff(arr));
    }
}

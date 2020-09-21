public class CheckPalindrome {
    boolean checkPalindrome(String inputString) {
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
    }
}

package ServiceNow;

import java.util.*;

public class DivisibleString {
    public static int method(int n, int k) {
        Set<String> setTest = new HashSet<>();
        String st = String.valueOf(n);
        //st.substring(begin, end) => end in inclusive => return end-begin elements
//        System.out.println(st.substring(0,1)); //return 1 =>1-0 element
//        System.out.println(st.substring(0,2));//return 12 =>2-0 elements
        System.out.println("********");
        if(st.length() < k)
            return 0;
        int len = st.length();
        for(int i =0; i<len-k+1; i++) {//+1 because end is inclusive
            String t = st.substring(i,i+k);
            //length = end-begin = i+k-i=k ==> the exact size that we need
            if(!t.equals("") && !t.equals("0") && n%Integer.parseInt(t)==0) {
                setTest.add(t);
            }
        }
        return setTest.size();
    }

    public static void main(String[] args) {
        System.out.println(method(555,1));
        System.out.println(method(120,2));
        System.out.println(method(10,1));

        //Test on Paper:

        //120,2.   Len-k=3-2=1
        //I=0=>120.sub(0,1) => 12         120%12 ==0 “YES”
        //I=1=> 120.sub(1,2)=>20          120%20==0 “YES”
        //——————
        //555,1.  Len-k = 3-1=2
        //I=0=> 555.sub(0,0+1-1)= 555.sub(0,0)=5.      555%5 ==0 “YES”
        //I=1 =>555.sub(1,1+1-1) = 555.sub(1,1) = 5    555%5 ==0 “YES”
        //I=2 =>555.sub(2,2+1-1) = 555.sub(2,2)=5.      555%5 ==0 “YES”
    }
}

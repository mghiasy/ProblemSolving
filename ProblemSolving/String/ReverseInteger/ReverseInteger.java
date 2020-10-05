package LeetCode;

import java.util.Stack;

public class ReverseInteger {
    public static int reverse(int x) {
        double res = 0;
        int multiple = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int digitCount = String.valueOf(x).length();
        while (x > 0) {
            res += (x % 10) * Math.pow(10, digitCount - 1);
            x = x / 10;
            digitCount--;
        }
        if (res > Integer.MAX_VALUE)res=0;
        return (int) res * multiple;
    }
    public static int reverse3(int x) {
        double res=0;
        int digit=0;
        while (x != 0) {
            digit=x%10;
            res = res * 10+digit;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE || res< Integer.MIN_VALUE)res=0;
        return (int) res;
    }
    //use stack
    public static int reverse2(int x) {
        int multiple = x > 0 ? 1 : -1;
        x = Math.abs(x);
        String str = String.valueOf(x);
        String resStr = "";
        Stack<Character> s = new Stack<>();
        for(char c: str.toCharArray()){
            s.push(c);
        }
        while (!s.isEmpty()){
            resStr+=s.pop();
        }
        int resInt=Integer.parseInt(resStr);
        if ( resInt> Integer.MAX_VALUE)resInt=0;
        return resInt* multiple;
    }

    public static void main(String[] args) {
        System.out.println(reverse3(-2147483648));
    }
}

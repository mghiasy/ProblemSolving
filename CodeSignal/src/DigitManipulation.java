public class DigitManipulation {
    int digitsManipulations(int n) {
        String str = String.valueOf(n);
        String[] strArr=str.split("");
        int prod=1, sum=0;
        for(String s :strArr){
            prod *= Integer.parseInt(s);
            sum +=Integer.parseInt(s);
        }
        return prod-sum;
    }
}

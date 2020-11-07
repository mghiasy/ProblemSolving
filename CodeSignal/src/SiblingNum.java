import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SiblingNum {
    public static int greatestSibling(int N){
        String s = String.valueOf(N);
        String[] str= String.valueOf(N).split("");
        Arrays.sort(str, Comparator.reverseOrder());
        String res=Arrays.stream(str).collect(Collectors.joining());
        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        greatestSibling(123451);
    }
}

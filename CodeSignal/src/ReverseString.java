import java.util.HashMap;
import java.util.Map;

public class ReverseString {
    private static void reverseString(String input){
        String[] strArray= input.split("");
        StringBuilder sb = new StringBuilder();
        int j=0;
        for(int i=strArray.length-1;i>=0;--i){
            if(j %2 ==1){
                sb.append(strArray[i].toUpperCase());
                ++j;
            }
            else{
                sb.append(strArray[i].toLowerCase());
                ++j;
            }
        }
        System.out.println(sb.toString());
    }
    private static void loadData(String input){
        //for array
        int[] array = new int[5];
        array[0] = 0;
        array[1] = 1;
        for (int i = 0; i < 5; ++i) {
            //do sth for element
            array[i] = i;
        }

        //for map
        Map<String, Integer> map = new HashMap<>();
        map.put("strr1", 1);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //do sth for entry
        }
    }

    public static void main(String[] args) {
        reverseString("abcdefg");
    }
}

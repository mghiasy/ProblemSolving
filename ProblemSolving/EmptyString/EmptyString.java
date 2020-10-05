package Test;
//Check if a string can become empty by recursively deleting a given sub-string
public class EmptyString {
    public static String emptyString (String str){
        String[] StrArr= str.split("\n");
        String result="";
        for(String strItem:StrArr) {
            while (strItem.length() > 0) {
                int idx = strItem.indexOf("100");
                if (idx == -1) break;
                strItem = strItem.replace("100", "");
            }
            result +="\n"+((strItem.length() == 0)? "yes" :"no");
        }
        return result.substring(1);

    }

    public static void main(String[] args) {
        String s ="101000\n" +
                "1010001";
        System.out.println(emptyString(s));
    }
}

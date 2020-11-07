public class ReverseSenetence {

    public static String reverse(String input){
        String[] strArray= input.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i= strArray.length-1; i>=0;--i){
            if(i==strArray.length-1){
                sb.append(strArray[i], 0, strArray.length-1);
            }
            else {
                sb.append(" ");
                sb.append(strArray[i]);
            }
        }
        sb.append(". ");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("My car is Red."));
        System.out.println(reverse(""));
        System.out.println(reverse(null));
        System.out.println(reverse("My"));
        System.out.println(reverse("My>?  "));
        System.out.println(reverse("My>? 12346 - 678"));
        System.out.println(reverse("My car is Red"));
        System.out.println(reverse("<p >"));
        System.out.println(reverse("Select * "));
        System.out.println(reverse("My car is Redjhvhbkjnlkjnkl ojnihniuhiu iuhiuhn"));
    }
}

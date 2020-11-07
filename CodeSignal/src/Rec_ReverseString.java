public class Rec_ReverseString {

    public String reverse(String str){
        return reverse(str.substring(1)) + str.charAt(0); //substring(1) => remove the first one
        //reverse("Hello")
        //(reverse("ello")) + "H"
        //((reverse("llo")) + "e") + "H"
        //(((reverse("lo")) + "l") + "e") + "H"
        //((((reverse("o")) + "l") + "l") + "e") + "H"
        //(((("o") + "l") + "l") + "e") + "H"
        //"olleH"
    }
}

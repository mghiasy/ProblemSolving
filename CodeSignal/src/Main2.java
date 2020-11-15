import Amazon.Logfile;


import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
//        Emp a = new Emp("AA");
//        Emp b = new Emp("BB");
//        System.out.println("first val --------------");
//        System.out.println("a :"+a.getName() +"b : "+b.getName());
//        swap(a,b);
//        System.out.println("after swap change reference val -----------------");
//        System.out.println("a: "+a.getName() +"b : "+b.getName());
//        ChangeVal(a,b);
//        System.out.println("after change val -----------------");
//        System.out.println("a: "+a.getName() +"b : "+b.getName());

    }

    private static void swap(Emp a, Emp b) {
        Emp temp = a;
        a=b;
        b=temp;
    }
    private static void ChangeVal(Emp a, Emp b) {
        a.setName("Ji");
        b.setName("Ma");
    }
}

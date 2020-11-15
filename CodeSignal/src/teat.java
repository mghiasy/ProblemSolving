package ServiceNow;
import java.util.*;

public class teat {
    public static void main(String args[]) {
        try {
            m(args);
        }
        catch (Exception e){
            System.out.println("exe");
        }
        m(args);
    }

    static int m(String[] args){
        return Integer.parseInt(args[0]);
    }
}


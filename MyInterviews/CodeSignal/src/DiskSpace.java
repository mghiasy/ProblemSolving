//get the max size of min size in the given window size
import java.util.*;
public class DiskSpace {
    public static int MaxOfMin(int x,List<Integer> s){
        if(x>s.size()) return 0;
        //List<Integer> list= new ArrayList<>();
        int max = 0;
        for(int i=0;i<= s.size()-x;++i){
            int min=s.get(i);
            for(int j=i+1;j<i+x;++j){
                min= Math.min(min,s.get(i));
            }
            //list.add(min);
            max=Math.max(max,min);
        }
       // Collections.sort(list,Collections.reverseOrder());

//        TreeSet<Integer> tree = new TreeSet<Integer>();
//        tree.first();
        
        return max;//list.get(0);
    }

    public static void main(String[] args) {
//        int[] arr ={-4,3,2,1};
//        System.out.println(m(arr));
        List x = new ArrayList();
        //x.add(3);
        x.add(1000000000);
//        x.add(2);
//        x.add(5);
//        x.add(4);
//        x.add(6);
//        x.add(8);

//        x.add(8);
//        x.add(2);
//        x.add(4);


        System.out.println((MaxOfMin(1,x)));
    }
}

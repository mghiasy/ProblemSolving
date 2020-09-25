import java.io.Serializable;
import java.util.*;
public class ttest{
    public static double  m(int x,List<Integer> s){
    List<Integer> list= new ArrayList<>();
    int min = Integer.MIN_VALUE;
    for(int i=0;i<= s.size()-x;++i){
       // Set<Integer> t= new TreeSet<>();
        min=s.get(i);
        for(int j=i+1;j<i+x;++j){
            //t.add(s.get(j));
            if(s.get(j)>min){
                min=s.get(j);
            }
        }
        list.add(min);
    }
//    Set<Integer> tt= new TreeSet<>();
//    for(Set<Integer> ss : list){
//        for(Integer item :ss){
//            tt.add(item);
//            break;
//        }
//    }
//    int xx = list.stream().max().getAsInt
    Collections.sort(list,Collections.reverseOrder());
//        int xx=tt.size();
//        double jj =tt.get(xx);
        return list.get(0);
    }

    public static void main(String[] args) {
//        int[] arr ={-4,3,2,1};
//        System.out.println(m(arr));
        List x = new ArrayList();
        //x.add(3);
      //  x.add(1000000000);
        x.add(2);
        x.add(5);
        x.add(4);
        x.add(6);
        x.add(8);

        System.out.println((m(2,x)));
    }
}

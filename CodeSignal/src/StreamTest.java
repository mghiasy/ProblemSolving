package Amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        System.out.println("--------------tt------------");
        //Stream.of("AA","BB").filter(ww->ww.toUpperCase()=="AA").forEach(q->System.out.println(q));

        Stream.empty();
    //Stream.iterate(1,i->i+2).skip(4).limit(4).forEach(i->System.out.println(i));
        //Comparator<Integer> comp = Comparator.comparing((x, y) -> y.compareTo(x));


        List<Integer> duration = Arrays.asList(new Integer[] {10, 3, 6, 4, 2});

        //duration.stream().sorted(comp).forEach(q->System.out.print(q+","));


        List<String> logfile=Arrays.asList("av 9 2 3 1","g1 Act car","zo4 4 7","ab1 off KEY dog","a8 act Zoo","a1 Act car");
        Comparator<String> comp2 = Comparator.comparing(String::new);
        String[] xx=logfile.stream().sorted(comp2).toArray(String[]::new);
        System.out.println(Arrays.toString(xx));


        List<Integer> ints=Arrays.asList(1,3,5,2,17);
        //new int with default value=0 and length = the number
        List<int[]> intArrays=ints.stream().map(int[]::new).collect(Collectors.toList());
        //change every int[] to array
        List<String>intArrStr=intArrays.stream().map(Arrays::toString).collect(Collectors.toList());
        System.out.println(intArrStr);
        Stream.of(1,2,3).map((n->n*n)).forEach(System.out::println);
        System.out.println("------------------");
        Stream.of(1,2,3).flatMap(n->Stream.of(n,n*n)).distinct().forEach(System.out::println);
    }
}

import java.util.*;

public class MaxOfMinContiguousArray {
    static ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    static List<Integer> numbs;

    public static void clean_deque(int i, int k) {

        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            int x=deq.getFirst();
            int xx=i - k;
            deq.removeFirst();
        }

        while (!deq.isEmpty() && numbs.get(i) < numbs.get(deq.getLast())) {
            int w=numbs.get(i);
            int ww=numbs.get(deq.getLast());
            deq.removeLast();
        }
    }

    public static int segment(int k, List<Integer> space) {
        numbs = space;
        int min_idx = 0;
        //put the first window to deq and find the min_index
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);// add index to deq
            if (space.get(i) < space.get(min_idx)) min_idx = i;
        }
        int result = space.get(min_idx);

        for (int i = k; i < space.size(); i++) {
            clean_deque(i, k);
            deq.addLast(i);
            result = Math.max(result, space.get(deq.getFirst()));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l= new ArrayList<>();
        l.add(8);
        l.add(2);
        l.add(4);
        l.add(6);
        l.add(5);
        l.add(4);
        l.add(7);
        l.add(8);
        l.add(4);
        System.out.println(segment(3,l));

    }
}


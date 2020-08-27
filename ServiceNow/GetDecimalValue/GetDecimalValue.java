package ServiceNow;

/**
 * Definition for singly-linked list. */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class GetDecimalValue {
    //time limit exceeded
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int listLength=0;
        while (curr != null) {
            listLength++;
        }

        int sum=0;
        while (listLength>0){
            sum +=(curr.val)* Math.pow(2,listLength);
            listLength--;
            curr=curr.next;
        }
        return sum;
    }
    //wrong Answer
    public int getDecimalValue2(ListNode head) {
        ListNode curr = head;
        int p=1,sum=0;
        while (curr != null){
            sum +=(curr.val)* p;
            p*=2;
            curr=curr.next;
        }
        return sum;
    }
//correct answer
    public int getDecimalValue3(ListNode head) {
        int res = 0;
        while (head != null) {
            res *= 2;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}



package HackerRank;
//time O(n)
//Space O(n)
   class  DoublyLinkedListNode {
      int data;
      DoublyLinkedListNode next;
      DoublyLinkedListNode prev;
      DoublyLinkedListNode(int data,DoublyLinkedListNode next,DoublyLinkedListNode prev){
          this.data=data;
          this.next=next;
          this.prev=prev;
      }
       DoublyLinkedListNode(int data){
           this.data=data;
       }
 }

public class InsertNodeInSortedDLL {
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newDDl = new DoublyLinkedListNode(data);
        DoublyLinkedListNode tempNode=null;
        DoublyLinkedListNode tempPrevNode=null;
        if (head == null) {
            head = newDDl;
        }
        else if(head.data>data) {
            newDDl.next=head;
            head.prev=newDDl;
            head=newDDl;
        }
        else {
            tempNode = head;
            while (tempNode.next != null && tempNode.data<data) {//O(n)
                tempPrevNode=tempNode;
                tempNode=tempNode.next;
            }
            if(tempNode.data>data){
                newDDl.next=tempNode;
                newDDl.prev=tempPrevNode;
                tempNode.prev=newDDl;
                tempPrevNode.next=newDDl;
            }
            else if(tempNode.next == null){
                tempNode.next=newDDl;
                newDDl.prev=tempNode;
                newDDl.next=null;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        DoublyLinkedListNode d = new DoublyLinkedListNode(2,null,null);
        DoublyLinkedListNode d2 = new DoublyLinkedListNode(3,null,d);
        DoublyLinkedListNode d3 = new DoublyLinkedListNode(4,null,d2);
        //DoublyLinkedListNode d4 = new DoublyLinkedListNode(4,null,d3);

        d.next=d2;
        d2.next=d3;
       // d3.next=d4;
        sortedInsert(d,1);
    }

}

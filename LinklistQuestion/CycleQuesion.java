package LinklistQuestion;

public class CycleQuesion {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  // to check whether it contain cycle or not
  public boolean hascycle(ListNode head){
      ListNode fast = head;
      ListNode slow = head;

      while(fast!=null && fast.next!=null){
          // we use "fast.next!=null" beacasue to make sure that fast.next.next really exist or not , beacuse
          // null ka next nhi hotaa
          fast= fast.next.next;
          slow= slow.next;
          if(fast==slow)
              return true;
          // we write if statemnet later beacause there  if we write it earlier then head is always equal to head before                       //interchangin
      }
      return false;

  }

  // to find the size of cycle
    public  int lengthcycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            // we use "fast.next!=null" beacasue to make sure that fast.next.next really exist or not , beacuse
            // null ka next nhi hotaa
            fast= fast.next.next;
            slow= slow.next;
            if(fast==slow)
            {
                ListNode temp = slow.next;
                int length=1;
                while(temp!=slow){
                    length++;
                    temp=temp.next;
                }
                return length;
            }
            // we write if statemnet later beacause there  if we write it earlier then head is always equal to head before                       //interchangin
        }
        return 0;
    }
}

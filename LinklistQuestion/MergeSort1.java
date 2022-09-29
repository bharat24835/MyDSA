package LinklistQuestion;

public class MergeSort1 {

    public ListNode sortlist(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortlist(head);
        ListNode right = sortlist(mid);
        return mergeTwoLists(left,right);
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
        }

    public class ListNode {
      int val;
      ListNode next;
      public ListNode() {}

      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

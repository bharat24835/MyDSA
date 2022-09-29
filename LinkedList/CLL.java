package LinkedList;

public class CLL {
    private  Node head;
    private  Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    // inset in CLL
    public  void  insert(int val){
     Node new_node = new Node(val);
     if(head==null){
         head=new_node;
         tail=new_node;
         return;
     }
     tail.next=new_node;
     new_node.next=head;
     tail=new_node;
     return;
    }

    // delete particular node from its value
    public void delete( int value){
        Node temp = head;
        if(temp==null){
            return;
        }
        if(temp.val==value){
            head=head.next;
            tail.next=head;
            return;
        }
        do{
            Node n = temp.next;
            if(n.val==value){
                temp.next=n.next;
                break;
            }
            temp=temp.next;
        }while (temp!=head); // pura cycle ka loop chala doo vahi better hai
        return;

    }
    // display
    public void display(){
       Node temp =head;
       if(head!=null){
           do {
               System.out.print(temp.val+ " --> ");
               temp=temp.next;
           }while (temp!=head);
       }
        System.out.println(" Head : ");
       return;
    }

    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}

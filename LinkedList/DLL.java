package LinkedList;

public class DLL {
   private Node head;
    //   insert at first index
    public void insertfirst(int a){
        Node new_node = new Node(a);
        new_node.next = head;
        new_node.prev=null;
        if(head!=null)
            head.prev= new_node;
        head= new_node;
        return;
    }

    //   insert at last index
    public void insertlast(int a){
        Node new_node= new Node(a);
        Node last_node = null;
        Node temp = head;
        if(temp==null)
            insertfirst(a);
        while(temp!=null){
            last_node=temp;
            temp=temp.next;
        }
        last_node.next=new_node;
        new_node.next=null;
        new_node.prev=last_node;
        return;

    }

    // insert value the desired value
    // here "value" is interger value not index
    public void insertafter(int value, int a){
        Node val_node  = find(value);
        if(val_node==null){
            System.out.println(" Does not exist : ");
            return;
        }
        if(val_node.next==null){
            insertlast(a);
            return;
        }

        Node new_node = new Node(a);
        new_node.next= val_node.next;
        val_node.next.prev= new_node;
        val_node.next=new_node;
        new_node.prev=val_node;
       return;

    }

    //    printing reverse
    public void displayreverse(){
        Node temp = head;
        Node last_node = null;
        // first traverse upto the last node
        while(temp!=null){
            last_node=temp;
            temp=temp.next;
        }
        // now we reach at last node
        while(last_node!=null){
            System.out.print(last_node.a+" --> ");
            last_node=last_node.prev;
        }
        System.out.println(" END: ");
        return;
    }

    //    printing
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.a+ " --> ");
            temp=temp.next;
        }
        System.out.println(" END: ");
    }

    // find the correct node from value:
    public Node find ( int value){
        Node temp  = head;
        while(temp!=null){
            if(temp.a == value){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }



       private class Node{
           int a;
           Node next;
           Node prev;

           public Node(int a, Node next, Node prev) {
               this.a = a;
               this.next = next;
               this.prev = prev;
           }

           public Node(int a) {
               this.a = a;
           }
       }
}

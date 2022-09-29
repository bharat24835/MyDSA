package LinkedList;

 class PractiseLinkedList {
     Node head;
     class Node{
         int a;
         Node next;
         Node( int a){
             this.a=a;
             this.next=null;
         }
     }
     // add the start of list function
     public void addfront(int a){
         Node new_node = new Node(a);
         if(head==null){
             head= new_node;
             return;
         }
         new_node.next= head;
         head = new_node;
         return;
     }
     // definig the function for add the element  at last
     public void addlast(int a){
         Node new_node = new Node(a);
         if(head==null){
             head=new Node(a);
             return;
         }
         new_node.next=null; // selecting null for new node:
         Node last = head;
         while (last.next!=null){
             last=last.next;
         }
         last.next=new_node;
         return;
     }
     // defining the function to print the list:
     public void print(){
         if(head==null){
             System.out.println(" List is empty: ");
             return;
         }
         Node last = head;
         while (last!=null){
             System.out.print(last.a+ " --> ");
             last=last.next;
         }
         System.out.print(" Null : ");

     }
     // adding the node after the particular node

     public static void main(String[] args) {
         PractiseLinkedList list = new PractiseLinkedList();
         list.addfront(5);
         list.addfront(4);
         list.addfront(3);
         list.print();
         System.out.println("");
         list.addlast(6);
         list.print();

     }
}

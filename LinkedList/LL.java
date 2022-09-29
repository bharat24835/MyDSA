package LinkedList;

 class LL {
     Node head;
     class Node {
         String data;
         Node next;
         Node(String data)
         {
             this.data=data;
             this.next=null;
         }

     }
     // add first
     public void addfirst(String data)
     {
         Node newNode= new Node(data);
         if(head==null){
            head=  newNode;
            return;
         }
         newNode.next = head;
         head = newNode;
     }
     public void addlast(String data){
         Node newnode = new Node(data);
         if(head==null){
             head = new Node(data);
             return;
         }
         newnode.next=null;

         Node currnode = head;

         while(currnode.next!=null){
             currnode=currnode.next;
         }
         currnode.next = newnode;
         return;

     }
     public void print(){

         if(head==null){
             System.out.println("List is empty: ");
             return;
         }
         Node currnode = head;

         while(currnode!=null){
             System.out.print(currnode.data + " --> ");
             currnode=currnode.next;
         }
         System.out.println("NULL : ");

     }

     public static void main(String[] args) {
         LL list = new LL();
         list.addfirst(" First ");
         list.addfirst(" Second ");
         list.addlast(" Third ");
         list.print();

     }
}

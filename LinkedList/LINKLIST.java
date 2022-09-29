package LinkedList;

import javax.swing.*;

public class LINKLIST {

    private Node head;
    private Node tail;
    private int size;

    public LINKLIST() {
        this.size = 0;
    }

    private class Node {
        private int a;
        private Node next;

        public Node(int a) {
            this.a = a;
        }

        public Node(int a, Node next) {
            this.a = a;
            this.next = next;
        }
    }
    // inset using recursion
    public void  insertRec(int val, int index){
           head = insertRec(val, index, head);
    }
    private Node insertRec(int val , int index,Node node){
        if(index==0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

        node.next= insertRec(val,index-1,node.next);
        return node;

    }
    public void addfirst(int a){
        Node new_node =new Node(a);
        new_node.next=head;
        head=new_node;
        //        if(head==null){
        //            head=new_node;
        //            return;
        //        } these lines have no sense over it
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void addLast(int a){
        Node new_node= new Node(a);
        if (tail==null){
            addfirst(a);
            return;
        }
        tail.next=new_node;
        tail=new_node;
        // line 44 and line 45 are going for me difficult to understand
        size++;
// agar tail node na ho , i.e  sirf head node hoo , then we have to travese in list upto (temp.next==null), then we will add
// public void addlast(int a){
//         Node new_node = new Node(a);
//         if(head==null){
//             head=new Node(a);
//             return;
//         }
//         new_node.next=null; // selecting null for new node:
//         Node last = head;
//         while (last.next!=null){
//             last=last.next;
//         }
//         last.next=new_node;
//         return;
//     }
    }
    public void display(){
        // there always need a variale that traveser the value
        // here we can't change the value of head
        // beacause head and tail are the part of teh structure
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.a + " --> ");
            temp=temp.next;
        }
        System.out.println(" END : ");

    }
    public void insertinto( int a, int index){
        if(index==0){
            addfirst(a);
            return;

        }
        if (index==size){
            addLast(a);
            return;
        }
        Node temp = head;
        for (int i = 1; i <index ; i++) {
            temp=temp.next;
        }
        Node new_node = new Node(a,temp.next);
        temp.next= new_node;
        size++;


    }
    public  int delelefirst(){
        if(head==null)
            tail=null;
        int val = head.a;
        head=head.next;
        size--;
        return val;

    }
    public int deletelast(){
       if(size<=1){
           return delelefirst();
       }
        int val = tail.a;
        Node secondlast = get(size-2);
        tail=secondlast;
        tail.next=null;
        size--;
        return val;
    }
    public int deleteindex(int index){
        if(index==0)
            return delelefirst();
        if(index==size-1)
            return deletelast();
        Node previousnode= get(index-1);
       Node successivenode= get(index+1);
       int val = get(index).a;
       previousnode.next=successivenode;
       return val;
    }
    // we write this get function to help this in when we want to delete a particular index Node
    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
       return temp;
    }
    // now we solve some question herer

    // removing duplicates from the list
    public void removeduplicates(){
       Node current_node  = head;
       while(current_node.next!=null){
           if( current_node.next!=null && current_node.a==current_node.next.a){

               current_node.next=current_node.next.next;
               size--;
           }
           else
               current_node=current_node.next;

        }
       // now update the tail
       tail=current_node;
       tail.next=null;
    }

    // merging two sorted list
    public static  LINKLIST merge(LINKLIST first, LINKLIST second){
        Node fcn = first.head;
        Node scn= second.head;
        LINKLIST ans = new LINKLIST();
         while(fcn!=null && scn!=null){
             if(fcn.a < scn.a){
                 ans.addLast(fcn.a);
                 fcn=fcn.next;
             }
             else {
                 ans.addLast(scn.a);
                 scn=scn.next;
             }
         }
         while (fcn!=null){
             ans.addLast(fcn.a);
             fcn=fcn.next;
         }
         while (scn!=null){
             ans.addLast(scn.a);
             scn=scn.next;
         }
         return ans;
    }

    // mergin two list of given node head , recursicely
    public static  Node mergeRecc(LINKLIST first, LINKLIST second){
        Node l1= first.head;
        Node l2 = second.head;
        return call(l1,l2);
    }
    public static Node call( Node l1, Node l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
       if(l1.a<l2.a){
           l1.next=call(l1.next,l2);
           return l1;
       }
       else
       {
           l2.next=call(l1,l2.next);
           return l2;
       }


    }

    // reversing the list

    public void reverse(Node temp){
             if(temp==tail) {
                 head=tail;
                 return ;
        }
             reverse(temp.next);

             tail.next=temp;

        // now parsing reversely
             tail=temp;
             tail.next=null;

    }

}

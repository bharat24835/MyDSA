package LinkedList;

public class New {
    public static void main(String[] args) {
        LINKLIST list  = new LINKLIST();
        list.addfirst(30);
        list.addfirst(20);
        list.addfirst(10);
        list.addfirst(5);
        list.addLast(40);
        list.insertinto(80,2);
        list.display();
        //System.out.println(list.delelefirst());
     //   list.display();
       // System.out.println(list.deletelast());
     //   list.display();
        System.out.println(list.deleteindex(3));
        list.display();

    }
}
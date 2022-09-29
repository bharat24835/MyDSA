package LinkedList;

public class new2 {
    public static void main(String[] args) {
       LINKLIST list = new LINKLIST();
      LINKLIST first= new LINKLIST();
      LINKLIST second= new LINKLIST();

      first.addLast(1);
      first.addLast(3);
      first.addLast(5);

      second.addLast(1);
      second.addLast(2);
      second.addLast(9);
      second.addLast(14);
      LINKLIST ans =LINKLIST.merge(first,second);
      ans.display();

    }
}

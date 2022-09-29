package StackAndQueue;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        /**
         * Your LRUCache object will be instantiated and called as such:
         * LRUCache obj = new LRUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
        LRUCache a = new LRUCache(3);
        a.put(1,1);
        a.put(2,2);
        a.put(3,3);
        System.out.println(a.get(2));
        System.out.println(a.get(2));
        a.display();
        a.put(4,4);
        a.display();



    }
}
class LRUCache {
    Node head= new Node(0,0), tail = new Node(0,0);
    Map<Integer , Node > map = new HashMap();
    int capacity;

     public LRUCache(int _capacity)  {// object function
        this.capacity = _capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key); // now node is our refernce pointer for key and key value
            remove(node);
            insert(node); // insert just after heap;
            return node.value;
        }
        else{
            return -1;
        }

    }


    public void display() {
            //Node current will point to head
            Node current = head;
            if(head == null) {
                System.out.println("List is empty");
                return;
            }
            System.out.println("Nodes of doubly linked list: ");
            while(current != null) {
                //Prints each node by incrementing the pointer.

                System.out.print(current.value + " ");
                current = current.next;
            }
    }


    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));

    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    class Node{
        Node prev, next;  // these are reference pointer
        int key, value; // these are integer datta types
        Node(int _key, int _value){ // constructor calling
            key = _key;
            value = _value;
        }
    }
}





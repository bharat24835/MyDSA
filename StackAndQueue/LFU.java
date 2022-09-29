package StackAndQueue;

import java.util.HashMap;
import java.util.Map;

public class LFU {
    public static void main(String[] args) {

        LFUCache q = new LFUCache(4);
        q.put(1,10);
        q.put(2,20);
        q.put(3,30);
        q.put(4,40);

        System.out.println("Getting number : " + q.get(1));
        System.out.println("Getting number : " + q.get(1));
        System.out.println("Getting number : " + q.get(1));
        q.display();



    }

}
class LFUCache {


    final int capacity;   // non changeable integer
    int curSize;
    int minF;


    Map<Integer , DLLNode> cache;
    Map<Integer , DoubleLinkedList> fMap;

    // capacity : total capacity of LFU cache
    // curSize : current size of LFU cache
    // minF : frequency of the last linked list (the min frequency of entire LFU cache)
    // cache: a hash map that has key to node mapping, which are used for storing all nodes by their keys
    // fMap:  a hash map that has key to linked list mapping which used for storing all double
    //        linked list mapping, which used for storing all double linked list by their frequencies


    public LFUCache(int capacity){ // constructor calling
        this.capacity = capacity;
        this.curSize = 0;
        this.minF = 0;


        this.cache = new HashMap<>();
        this.fMap = new HashMap<>();
    }


    class DLLNode{

        int key;
        int val;
        int f;
        DLLNode prev;
        DLLNode next;

        public DLLNode (int key, int val){
            this.key= key;
            this.val = val;
            this.f = 1;
        }
    }


    class DoubleLinkedList{
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList(){
            this.listSize =0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }


        // add new node into next to head and increase the size of list by 1
        public void addNode(DLLNode curNode){
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
            return;
        }



        // remove input node and decerase listsize by 1

        public void removeNode(DLLNode curNode){
            DLLNode nextNode = curNode.next;
            DLLNode prevNode = curNode.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
            return;
        }

    }
// this is closing of DoubleLinkedList
// this double linked list will work for whole LRU problem

    // add new node value by value and then update node frequency as well as relocate that node

    public int get(int key){ // here we are getting value from cache map (muneem ji)
        DLLNode curNode = cache.get(key);
        if(curNode==null){
            return -1;
        }

        updateNode(curNode); // we have access the curNode , now its frequency will increase
        return curNode.val;
    }

    public void updateNode(DLLNode curNode){
        int curF = curNode.f;
        DoubleLinkedList curList = fMap.get(curF); // fMap mai voh wali list loo jiski
        // frequency , curf hooo
        // from that frequency lsit remove that node
        curList.removeNode(curNode);

        // now we have to look for edge cases
        // if the cuurent list is the last list which has lowest frequency and current node is
        // the only node in that list, we need to remove the entire list and then increase minF
        // value by 1
        if(curF == minF && curList.listSize==0){
            minF++;
        }


        curNode.f++;

        // add current node to another list has current frequency +1
        // if we do not have the list with this frequency ,intialize it
        DoubleLinkedList newList = fMap.getOrDefault(curNode.f, new DoubleLinkedList());
        // getOrdefault used to get the value mapped with specified key. If no value is mapped with the provided key then the         //default value is returned.
        //look {new DoubleLinkedList()} is the default value


        newList.addNode(curNode); // adding node in doublelinkedlist
        fMap.put(curNode.f, newList);
        return;



    }

    public void put (int key , int value){
        //corner case : check cache capacity initialization
        if(capacity==0){
            return;
        }

        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else{
            curSize++;
            if(curSize > capacity)// we need to delete LRU guy from minF list
            {
                // get minF list
                DoubleLinkedList minFList = fMap.get(minF);
                cache.remove(minFList.tail.prev.key);
                minFList.removeNode(minFList.tail.prev);
                curSize--;
            }

            // reset minf  list to 1 because of adding new node;
            minF = 1;
            DLLNode newNode = new DLLNode(key, value);

            // getting the lsit of frequency 1 , and add new node into the list, as well as
            // into LFU cache
            DoubleLinkedList curList = fMap.getOrDefault(1,new DoubleLinkedList());
            curList.addNode(newNode);
            fMap.put(1, curList);
            cache.put(key, newNode);
            return;

        }

    }
    public void display(){

        int count =0;
        int i =minF;
        while(count!=capacity){
            if(fMap.containsKey(i) && fMap.get(i).listSize!=0) {
                DoubleLinkedList q = fMap.get(i);
                count=count+q.listSize-2;
                // if(q.listSize==0)
                //  continue;

                DLLNode m = q.head;
                System.out.println("This is the list of Frequency : " + i);
                while (m != null) {
                    System.out.println( m.key + " , " +  m.val);
                    m = m.next;
                }
            }
            i++;
        }
        return;

    }



}

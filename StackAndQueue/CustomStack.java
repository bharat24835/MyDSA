package StackAndQueue;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE =10;

    int ptr = -1;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public  CustomStack( int size){
        this.data = new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is Fulll ! ");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    private boolean isFull() {
        return ptr == data.length-1;// ptr is at last index
    }
    private boolean isEmpty(){
        return ptr ==-1; // ptr is at starting index
    }
    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Cannot pop from an empty stack");
        }
//        int removd = data[ptr];
//        ptr--;
//        return removd;
        return data[ptr--];
    }

    public int peek() throws Exception { // tell us what is at the top
        if(isEmpty()) {
            throw new Exception("Cannot peek from an empty stack");
        }
      return data[ptr];
    }
}


package StackAndQueue;

import java.util.LinkedList;
import java.util.Stack;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        MyQueue s = new MyQueue();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("");
        s.PrintStack();
        System.out.println("");
        System.out.println(s.pop());
        System.out.println("");
        System.out.println(s.pop());
        System.out.println("");
        s.PrintStack();

    }
}
class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.empty()){
            s1.push(s2.pop());
        }

    }

    public int pop() {
        if(s1.empty())
            return -1;
        return s1.pop();

    }

    public int peek() {
        if(s1.empty()){
            return -1;
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty();

    }

    public  void PrintStack()
    {

        Stack<Integer> temp = new Stack<Integer>();

        while (s1.empty() == false)
        {
            temp.push(s1.peek());
            s1.pop();
        }

        while (temp.empty() == false)
        {
            int t = temp.peek();
            System.out.print(t + " ");
            temp.pop();

            // To restore contents of
            // the original stack.
            s1.push(t);
        }
    }
}

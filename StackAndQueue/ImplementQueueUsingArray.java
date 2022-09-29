package StackAndQueue;

import java.util.LinkedList;
import java.util.Scanner;

public class ImplementQueueUsingArray {


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the capacity of arrAY : ");
        int n = in.nextInt();
        Queue q = new Queue(5);
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        q.display();

        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

        q.display();
        q.top();
        q.push(90);
        q.display();

    }
}


class Queue {

    public   int front , rear , capacity;
    public   int count;
    public   int[] a;

    Queue(int capacity) {  // constructor calling
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.count =0;
        a = new int[capacity];
    }

    public void push(int x) throws Exception {
        if(count==capacity){
            throw new Exception("Stack is full , if you want to push something m first pop it: ");
        }
        else{
            a[rear%capacity] =x;
            count++;
            rear++;
        }
    }

    public int pop() throws Exception {
        if(capacity==0){
            throw new Exception(" Stack is empty , so how we delete it SIr : ");

        }
        else {
            count--;
            return a[front++%capacity];

        }
    }

    public int top() throws Exception {
        if(capacity==0){
            throw new Exception("How we can calculate top elemtn from an empty stack: ");
        }
        else {
            return a[front%capacity];
        }
    }

    public void display() throws Exception {
        if(capacity==0){
            throw new Exception("List is empty: ");
        }
        else {
            for(int i = front; i<rear; i++  ){
                System.out.print(a[i%capacity] + " ");
            }
            System.out.println("");
        }
    }


}

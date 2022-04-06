package com.jirui.queue;


/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/25 15:01
 */
public class Link<T> {
    private Node tail;
    private Node head;
    private int size;

    public Link() {
        head = new Node(null,null);
        tail = new Node(null,null);
    }

    public boolean isEmpty(){
        return head.next==null;
    }


    public void push(T data){

        if(isEmpty())
        {
            this.tail.data = data;
            head.next = this.tail;

        }else{
            Node tail = this.tail;
            Node node = new Node(data, null);
            tail.next = node;
            this.tail = node;
        }
        this.size++;


    }

    public T pull(){
        if(isEmpty()){
            return null;
        }else{
            Node next = head.next;
            T data = next.data;
            head.next = next.next;
            this.size--;
            return data;

        }
    }
    public int getSize(){
        return this.size;
    }

    public void clean(){
        this.tail = new Node(null, null);
        this.head.next = null;
        this.size = 0;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Link<Integer> integerLink = new Link<>();
        System.out.println(integerLink.isEmpty());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        integerLink.push(1);
        integerLink.push(2);
        integerLink.push(3);
        integerLink.push(4);
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        integerLink.clean();
        integerLink.push(5);
        System.out.println("size:"+integerLink.getSize());
        integerLink.push(6);
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println("size:"+integerLink.getSize());
        System.out.println(integerLink.pull());
        System.out.println(integerLink.pull());
        System.out.println(integerLink.pull());
        System.out.println(integerLink.pull());
        System.out.println(integerLink.pull());
        System.out.println(integerLink.pull());
        System.out.println(integerLink.pull());
        System.out.println(integerLink.pull());


    }
}

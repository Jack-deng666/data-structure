package com.jirui.stack;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/25 11:16
 */
public class linkList<T> {
    public linkList() {
        // 初始化，并向栈添加默认数据
        insertList();
    }

    // 头结点
    private Node root = new Node(null,null);

    public boolean isEmpty(){
        return  root.next == null;
    }

    public void push(T value){
        Node node = new Node(value, null);
        if(isEmpty()){
            root.next = node;
        }else{
            Node next = root.next;
            root.next = node;
            node.next = next;
        }
    }

    public T pull(){
        if(isEmpty()){
            return null;
        }else{
            Node next = root.next;
            root.next = next.next;
            return next.data;
        }
    }


    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
    private void insertList(){
        int[] a = {1,2,3,4,5,6,7};
        for(Integer i:a){
            Node node = new Node((T) i, null);
            Node next = root.next;
            root.next = node;
            node.next = next;
        }
    }
    public void print(){
        insertList();
        Node tmp = root;
        while(tmp.next!=null){
            Node next = tmp.next;
            System.out.println(next.data);
            tmp = next;
        }
    }

    public static void main(String[] args) {
        linkList link = new linkList();
        link.push(100);
        System.out.println(link.pull());
        System.out.println(link.pull());
        System.out.println(link.pull());
        System.out.println(link.pull());
        link.push(101);
        System.out.println(link.pull());
        System.out.println(link.pull());
        System.out.println(link.pull());
        System.out.println(link.pull());
        System.out.println(link.pull());
        System.out.println(link.pull());
        System.out.println(link.pull());
    }
}


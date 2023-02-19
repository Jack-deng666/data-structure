package com.jirui.list;

public class ReverseList {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        Node pre = new Node();
        Node node = pre;
        for(int i:a){
            node.next = new Node(i);
            node = node.next;
        }
//        ReverseList.printNode(pre.next);
        Node node1 = ReverseList.reverseList(pre.next);
        ReverseList.printNode(node1);

    }

    public static Node reverseList(Node head) {
        Node cur = head;
        Node pre = cur.next;
        cur.next = null;
        while(pre!=null){
            Node tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    public static  void printNode(Node head){
        Node cur = head;
        while (cur!=null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}

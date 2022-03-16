package com.jirui.list;

import java.util.ArrayList;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/15 10:12
 */
public class SingleList<T> {
    private int count=0;      // 链表长度
    private Node root = new Node(null,null);      // 根节点
    private Node vrNode = new Node(null, root);

    /**
     * 判断链表为空
     * @return 链表为空
     */
    public boolean isEmpty(){
        return count==0 || root ==null;
    }

    /**
     * 获取链表长度
     * @return 链表长度
     */
    public int size(){
        return count;
    }

    /**
     * 添加最后一个节点
     * @param data 最后节点
     */
    public void  add(T data){
        add(data,count);
    }

    /**
     * 指定位置添加节点
     * @param data 节点数据
     * @param index 节点索引
     */
    public void  add(T data,int index){

        if(index>count){
            System.out.println("错误操作");
            return;
        }
        if(count==0){
            root = new Node(data, null);
            count++;
            return;
        }

        Node preNode = root;
        for(int i=0 ;i<index-1;i++){
            preNode = preNode.next;
        }

        preNode.next = new Node(data,preNode.next);
        this.count++;
    }

    /**
     * 删除最后一个节点
     */
    public void delete(){
        delete(count);
    }

    /**
     * 删除指定位置节点
     * @param index 节点索引
     */
    public void delete(int index){
        if(index>count || count==0 ||isEmpty()){
            System.out.println("元素节点不存在");
            return;
        }
        Node preNode = root; // 虚拟节点
        if(index==0){
            root = root.next;
            count--;
            return;
        }
        for(int i=0;i<index-1;i++){
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        count--;
    }


    /**
     * 获取指定索引节点数据
     * @param index 索引
     * @return 数据信息
     */
    public T get(int index){
        if(index>count || count==0 ||isEmpty()){
            System.out.println("元素节点不存在");
            return null;
        }
        Node resultNode = root;
        for(int i=0;i<index;i++){
            resultNode = resultNode.next;
        }
        return resultNode.data;
    }

    /**
     * 获取最后一个节点
     * @return 数据信息
     */
    public T get(){
        return get(count);
    }

    /**
     * 获取指定数据节点
     * @param data
     * @return
     */
    public Node get(T data){
        if(count==0 ||isEmpty()){
            System.out.println("元素节点不存在");
            return null;
        }
        Node resultNode = root;
        for(int i=0;i<count;i++){
            resultNode = resultNode.next;
            if(resultNode.data==data){
                return resultNode;
            }
        }
        return null;
    }

    /**
     * 节点清空
     */
    public void clean(){
        count = 0;
        root = null;
    }

    /**
     * 翻转链表
     */
    public void reserve(int start, int end){
        if(count==0 ||isEmpty() || start>count  || end >count){
            System.out.println("链表为空");
            return;
        }
        Node preNode = null;
        Node head = this.root;
        Node next;
        while(head!=null){
            next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;

        }
        root = preNode;


    }

    /**
     * 打印数据
     */
    public void print(){
        Node preNode = root;
        ArrayList<T> t = new ArrayList<>();
        while(preNode!=null){

            t.add(preNode.data);
            preNode = preNode.next;

        }
        System.out.println(t);
    }

    /**
     * 内部类实现单个链表节点数据
     */
    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleList<Integer> singleList = new SingleList<>();
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.add(4);
        singleList.print();
        singleList.reserve(0,3);
        singleList.print();
        singleList.delete(3);
        singleList.print();
        singleList.add(5,1);
        singleList.print();
        Integer integer = singleList.get(1);
        System.out.println(integer);
    }

}

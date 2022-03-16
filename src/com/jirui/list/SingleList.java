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
    private Node vrNode;

    public SingleList() {
        this.vrNode = new Node(null, root);
    }

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
     * 翻转全部链表
     */
    public void reserve(){
        if(count==0 ||isEmpty()){
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
        vrNode.next = root;
    }

    /**
     * 翻转部分列表、方法一：
     * @param start
     * @param end
     */
    public void reserve(int start, int end){
        if(count==0 ||isEmpty() || start>count  || end >count){
            System.out.println("链表为空");
            return;
        }
        vrNode.next = root;
        Node preNode = vrNode;
        Node next = null;
        for(int i=0;i<start;i++){
            preNode = preNode.next;
        }
        Node head = preNode.next;
        for(int i=0;i<end-start;i++){
            next = head.next;
            head.next = next.next;
            next.next = preNode.next;
            preNode.next = next;
        }
        if(start==0){
            root = next;
        }
    }
    /**
     * 翻转部分列表、方法二：
     * @param start 开始位置
     * @param end 结束位置
     * @param use2  使用方法2
     */
    public void reserve(int start, int end,boolean use2){
        if(count==0 ||isEmpty() || start>count  || end >count){
            System.out.println("链表为空");
            return;
        }
        vrNode.next = root;
        Node preNode = vrNode;
        Node headNode = preNode;
        Node tailNode = new Node(null,null);
        // 获取子链 将链表分为三部分；
        for(int i=0;i<count;i++){
            if(i == start-1)
                headNode = preNode.next;
            else if (i == end+1){
                tailNode = preNode.next;
                break;
            }
            preNode = preNode.next;
        }
        Node head = headNode.next;
        Node next;
        // 重要步骤
        Node pre = tailNode;
        for(int i=0;i<end-start+1;i++){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        headNode.next = pre;
        if(start==0){
            root=pre;
            vrNode = root;
        }
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
        singleList.add(0);
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.add(4);
        singleList.add(5);
        singleList.add(6);
        singleList.add(7);
        singleList.add(8);
        singleList.add(9);
        singleList.print();
        singleList.reserve(0,5,true);
        singleList.print();
    }

}

package com.jirui.list;

import scala.xml.Null;

public class Node <T>{
    public T data = null;		//数据信息
    public Node next = null;	//下一个节点引用

    public Node(T data) {
        this.data = data;
    }

    public Node(){

    }
    public Node(T data, Node node) {
        this.data = data;
        this.next = node;
    }

}

package com.jirui.list;

public class LineList {
    private int length;
    private int[] list;

    /**
     * 初始化顺序表
     * @param size
     */
    public LineList(int size) {
        list = new int[size];
    }

    /**
     * 判断顺序白是否为空
     * @return
     */
    public boolean isEmpty(){
        return length == -1;
    }

    /**
     * 判断线性表是否内存占满
     * @return
     */
    public boolean isFull(){
        return length==list.length-1;
    }

    /**
     * 插入数据
     * @param value 插入数据
     */
    public boolean add(int value){
        if(!isFull()) {
            length++;
            list[length] = value;
            return true;
        }else{
            System.out.println("线性表已经满了");
            return false;
        }
    }

    /**
     * 获取指定位置元素
     * @param index 获取元素索引
     * @return 返回指定索引数据
     */
    public int get(int index){
        if(index >length || index<0){
            System.out.println("角标越界");
            return -1;
        }
        else{
            return list[length];
        }
    }

    /**
     * 删除指定位置元素
     * @param index 索引
     * @return
     */
    public  boolean delete(int index){
        if(index >length || index<0){
            System.out.println("角标越界");
            return false;
        }else{
            for(int i=index;i<length;i++){
                list[i] = list[i+1];
            }
            length--;
            return true;
        }
    }

    /**
     * 指定位置插入元素
     * @param index 索引
     * @param value 数据
     * @return 插入成功
     */
    public boolean insert(int index,int value){
        if(index >length || index<0 || length+1+1>list.length){
            System.out.println("越界");
            return false;
        }else{
            for(int i=length+1;i>index;i--){
                list[i+1] = list[i];
            }
            length++;
            list[index] = value;
            return true;
        }
    }

    /**
     * 修改指定位置数据
     * @param index 索引
     * @param value 数据
     * @return 修改成功
     */
    public boolean update(int index,int value){
        if(index >length || index<0){
            System.out.println("角标越界");
            return false;
        }else {
            list[index] = value;
            return true;
        }

    }

    /**
     * 清空顺序表
     */
    public void clean(){
        length = 0;
    }

    /**
     * 获取顺序表数据长度
     * @return
     */
    public int getLength(){
        return length;
    }
}

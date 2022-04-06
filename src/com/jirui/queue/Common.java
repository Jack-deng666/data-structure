package com.jirui.queue;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/25 13:44
 */
public class Common {
    private int entry;
    private int export;
    private int[] data;

    public Common(int size) {
        this.data = new int[size];
    }

    /**
     * 判断队列是否为空
     * @return 空
     */
    public boolean isEmpty(){
        return entry==export;
    }
    public boolean isFull(){

        return  export == (entry+1) % data.length;
    }

    /**
     * 进队
     * @param value 数值
     * @return 是否进队成功
     */
    public boolean push(int value){
        if(isFull()){
            return false;
        }else{
            data[entry] = value;
            entry = (entry+1)% data.length;
            return true;
        }
    }

    /**
     * 出队列
     * @return 数值
     */
    public Integer pull (){
        if(isEmpty()){
            return null;
        }else{
            int value = data[export];
            export = (export+1)% data.length;

            return value;
        }
    }

    public static void main(String[] args) {

        Common common = new Common(10);
        System.out.println(common.isEmpty());
        System.out.println(common.pull());
        common.push(1);
        common.push(2);
        common.push(3);
        common.push(4);
        common.push(5);
        common.push(6);
        common.push(7);
        common.push(8);
        common.push(9);
        common.push(10);
        common.push(11);

        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        common.push(6);
        common.push(7);
        common.push(1);
        common.push(2);
        common.push(3);
        common.push(4);
        common.push(5);
        common.push(6);
        common.push(7);
        common.push(8);
        common.push(9);
        common.push(10);
        common.push(11);
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
    }
}

package com.jirui.stack;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/25 10:54
 */
public class Common {
    private int index = 0;
    private int[] data;

    public Common(int size) {
        data = new int[size];
    }

    public boolean isEmpty(){
        return index <= 0;
    }

     public boolean push(int values){
        if(index==data.length){
            return false;
        }else{
            data[index++] = values;
            return true;
        }
     }

    public Integer pull(){
        if(isEmpty()){
            return null;
        }else{
            return data[--index];
        }
    }

    public static void main(String[] args) {
        Common common = new Common(10);
        Integer pull = common.pull();
        System.out.println(pull);
        common.push(1);
        common.push(2);
        common.push(3);
        common.push(4);
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
        System.out.println(common.pull());
    }
}

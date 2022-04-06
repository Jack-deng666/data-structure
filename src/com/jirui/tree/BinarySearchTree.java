package com.jirui.tree;


/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/4/6 15:33
 */



public class BinarySearchTree  {
    private BinaryTree root;
    private int count;

    private static class BinaryTree {
        private Integer data;
        private BinaryTree leftTree;
        private BinaryTree rightTree;

        public BinaryTree(Integer data) {
            this.data = data;
        }
    }

    /**
     * 判断是否为空树
     * @return 空树
     */
    public boolean isEmpty(){
        return this.root.leftTree == null && this.root.rightTree == null;
    }

    /**
     * 添加新节点
     * @param data 节点数据
     */
    public boolean insert(Integer data){
        if (this.isEmpty()){
            this.root.data = data;
            return true;
        } else{
            BinaryTree Node = root;
            while(true){
                if(Node.data.equals(data)){
                    throw new NullPointerException();
                }else if(Node.data>data){
                    if(Node.leftTree == null){
                        Node.leftTree = new BinaryTree(data);
                        return true;
                    }
                    Node = Node.leftTree;
                }else{
                    if(Node.rightTree == null){
                        Node.rightTree = new BinaryTree(data);
                        return true;
                    }
                    Node = Node.rightTree;
                }
            }
        }
    }

    /**
     * 删除某节点
     * @param data 节点数据
     */
    public boolean delete(Integer data) {
        if (isEmpty()) {
            return false;
        } else {
            BinaryTree Node = root;
            BinaryTree parentNode = Node;
            boolean isLife = true;
            while (!Node.data.equals(data)) {
                parentNode = Node;
                if (Node.data > data) {
                    Node = Node.leftTree;
                    isLife = true;
                } else {
                    Node = Node.rightTree;
                    isLife = false;
                }
            }
            if (Node.leftTree == null && Node.rightTree == null) {
                if(isLife){
                    parentNode.leftTree = null;
                }else{
                    parentNode.rightTree = null;
                }

                return true;
            }
            if (Node.rightTree == null) {
                if (isLife) {
                    parentNode.leftTree = Node.leftTree;
                } else {
                    parentNode.rightTree = Node.leftTree;
                }
            } else if (Node.leftTree == null) {
                if (isLife) {
                    parentNode.leftTree = Node.rightTree;
                } else {
                    parentNode.rightTree = Node.rightTree;
                }
            }else{
                BinaryTree tmp = Node;
                BinaryTree parentTmp = Node;
                while(tmp.rightTree != null){
                    parentTmp = tmp;
                    tmp = tmp.rightTree;
                }
                parentTmp.rightTree=null;
                if(isLife){
                    parentNode.leftTree = tmp;
                    tmp.leftTree = Node.leftTree;
                    tmp.rightTree = Node.rightTree;
                }else{
                    parentNode.rightTree = tmp;
                    tmp.leftTree = Node.leftTree;
                    tmp.rightTree = Node.rightTree;
                }
            }
            return true;

        }
    }

    /**
     * 查找节点
     * @param data 匹配数据
     * @return 匹配结果
     */
    public BinaryTree find(Integer data){
        if (this.isEmpty()){
            return root;
        }else{
            BinaryTree Node = root;
            while(Node !=null){
                if(Node.data.equals(data)){
                    return Node;
                }else if(Node.data > data){
                    Node = Node.leftTree;
                }else{
                    Node = Node.rightTree;
                }
            }
            return Node;
        }
    }
}

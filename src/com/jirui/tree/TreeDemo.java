package com.jirui.tree;

import org.junit.Test;

import java.util.*;

public class TreeDemo {
    public static void main(String[] args) {
        char[] chars = new char[] {'1', '2', '3', '4', '0', '5', '6', '7', '8', '0', '0', '9', 'A'};
        Tree tree = new Tree(chars);
        ArrayList<Character> c = new ArrayList<>();
        ArrayList<Character> a = TreeDemo.BreadthShow(tree.root);
        ArrayList<Character> b = TreeDemo.DepthShow(tree.root);
        c = TreeDemo.DepthShow(tree.root,c);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        ArrayList<Integer> integers = new ArrayList<>();
        int [] dd = new int[10];
        dd[1] = 1;

    }

    /**
     * 广度优先搜索
     * @param root 根节点
     * @return 列表
     */
    public static  ArrayList<Character> BreadthShow(Node root){
        LinkedList<Node> trees = new LinkedList<>();
        ArrayList<Character> ints = new ArrayList<Character>();
        Node node = root;
        trees.offer(node);
        while(!trees.isEmpty() ){
            node = trees.poll();
            ints.add(node.data);
            if(node.left !=null)
                trees.offer(node.left);
            if(node.right !=null)
                trees.offer(node.right);
        }
        return ints;

    }

    /**
     * 非递归的深度优先算法
     * @param root
     * @return
     */
    public static ArrayList<Character> DepthShow(Node root){
        ArrayList<Character> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        stack.push(node);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            ans.add(pop.data);
            if(pop.right!=null)
                stack.push(pop.right);
            if(pop.left!=null)
                stack.push(pop.left);
        }
        return ans;
    }

    /**
     * 递归的深度优先算法
     * @param node
     * @param c
     * @return
     */
    public static ArrayList<Character> DepthShow(Node node, ArrayList<Character> c){
        if(node == null){
            return null;
        }

        if(node.left!=null)
            DepthShow(node.left,c);
        c.add(node.data);
        if(node.right!=null)
            DepthShow(node.right,c);



        return c;
    }


    @Test
    public  void test(){
        Queue<Integer> integers = new ArrayDeque<>();

    }

    public Node CreateTree(char [] preorder, char [] inorder){
      
        HashMap<Character, Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }
        Node root = new Node(preorder[0]);
        for(char a: preorder){
            int index = inorderMap.get(a);
            if(index >0){
                char [] inorderSon = inorder;
            }

        }
        return root;
    }

}

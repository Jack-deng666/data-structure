package com.jirui.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/4/12 11:06
 */
public class AdjacentMatrix {
    static final int MaxNum = 20;         // 图的最大顶点数
    static final int MaxValue = 65535;    // 最大值
    int GType;     //图的类型（0:无向图  1：有向图）
    int VertexNum;//顶点数量
    int EdgeNum;   //边的数量
    char[] Vertex = new char[MaxNum]; //保存顶点信息
    int[][] EdgeWeight=new int[MaxNum][MaxNum];//保存权

    public static void main(String[] args) {
        AdjacentMatrix a = new AdjacentMatrix();
//        System.out.println(Arrays.asList(a.EdgeWeight));
        for(int [] i : a.EdgeWeight){
            System.out.println(Arrays.toString(i));
        }
    }
}

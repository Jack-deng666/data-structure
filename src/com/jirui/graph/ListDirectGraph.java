package com.jirui.graph;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/4/12 18:11
 */
public class ListDirectGraph<V> implements IDirectGraph<V> {

    private ArrayList<GraphNode<V>> list;

    public ListDirectGraph() {
        this.list = new ArrayList<>();
    }

    @Override
    public void addVertex(V v) {
        GraphNode<V> vGraphNode = new GraphNode<>(v);
        this.list.add(vGraphNode);

    }

    @Override
    public boolean removeVertex(V v) {
        //1. 移除一个顶点
        //2. 所有和这个顶点关联的边也要被移除
        //  lambda表达式实现
        //  list.removeIf(graphNode -> v.equals(graphNode.getVertex()));

        Iterator<GraphNode<V>> iterator = list.iterator();
        while (iterator.hasNext()) {
            GraphNode<V> graphNode = iterator.next();

            if(v.equals(graphNode.getVertex())) {
                iterator.remove();
            }
        }

        return true;
    }

    @Override
    public V getVertex(int index) {

        return list.get(index).getVertex();
    }

    @Override
    public void addEdge(Edge<V> edge) {

        //1. 新增一条边，直接遍历列表。
        // 如果存在这条的起始节点，则将这条边加入。
        // 如果不存在，则直接报错即可。

        for(GraphNode<V> graphNode : list) {
            V from = edge.getFrom();
            V vertex = graphNode.getVertex();

            // 起始节点在开头
            if(from.equals(vertex)) {
                graphNode.getEdgeSet().add(edge);
            }
        }

    }

    @Override
    public boolean removeEdge(Edge<V> edge) {
        // 直接从列表中对应的节点，移除即可
        GraphNode<V> node = getGraphNode(edge);
        if(null != node) {
            // 移除目标为 to 的边
            node.removeEdge(edge.getTo());
        }

        return true;
    }

    @Override
    public Edge<V> getEdge(int from, int to) {
        // 获取开始和结束的顶点
        V toVertex = getVertex(from);
        // 获取节点
        GraphNode<V> fromNode = list.get(from);
        // 获取对应结束顶点的边
        return fromNode.getEdge(toVertex);
    }
    /**
     * 获取对应的图节点
     * @param vertex 顶点
     * @return  图节点
     * @since 0.0.2
     */
    private GraphNode<V> getGraphNode(final V vertex) {
        for(GraphNode<V> node : list) {
            if(vertex.equals(node.getVertex())) {
                return node;
            }
        }
        return null;
    }

    /**
     * 获取图节点
     * @param edge 边
     * @return 图节点
     */
    private GraphNode<V> getGraphNode(final Edge<V> edge) {
        for(GraphNode<V> node : list) {
            final V from = edge.getFrom();

            if(node.getVertex().equals(from)) {
                return node;
            }
        }

        return null;
    }
}

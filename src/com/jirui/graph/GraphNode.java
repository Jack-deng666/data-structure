package com.jirui.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/4/12 17:48
 */
public class GraphNode<V> {

    /**
     * 定点
     */
    private V vertex;

    /**
     * 边
     */
    private Set<Edge<V>> edgeSet;

    /**
     * 初始化顶点
     * @param vertex 顶点
     */
    public GraphNode(V vertex) {
        this.vertex = vertex;
        this.edgeSet = new HashSet<Edge<V>>();
    }

    /**
     * 新增一条边
     * @param e 边
     */
    public void addEdge(Edge<V> e){
        this.edgeSet.add(e);
    }

    /**
     * 获取目标边
     * @param to 目标边
     * @return 目标边
     */
    public Edge<V> getEdge(final V to){
        for(Edge<V> edge : edgeSet) {
            V dest = edge.getTo();

            if(dest.equals(to)) {
                return edge;
            }
        }
        return null;

    }

    /**
     * 删除目标边
     * @param to
     * @return
     */

    public boolean removeEdge(V to){
        Iterator<Edge<V>> iterator = edgeSet.iterator();
        while (iterator.hasNext()){
            Edge<V> next = iterator.next();
            if(next.getTo().equals(to))
            {
                iterator.remove();
                return true;
            }

        }
        return false;
    }

    public V getVertex() {
        return vertex;
    }

    public Set<Edge<V>> getEdgeSet() {
        return edgeSet;
    }

}

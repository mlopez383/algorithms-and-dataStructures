package com.avantica.tutorial.algorithmsdatastructures.undirectedgraph;

import java.util.List;

public interface UndirectedGraph<T> {
    int vCount();
    int eCount();
    void addEdge(Vertex v1, Vertex v2);
    void deleteEdge(Vertex v1, Vertex v2);
    boolean isConnected(Vertex v1, Vertex v2);
    List<Vertex<T>> depthFirstTraversal();
    List<Vertex<T>> breadthFirstTraversal();
}






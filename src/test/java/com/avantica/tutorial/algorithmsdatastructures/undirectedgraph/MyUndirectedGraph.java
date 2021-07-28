package com.avantica.tutorial.algorithmsdatastructures.undirectedgraph;

import com.avantica.tutorial.algorithmsdatastructures.queue.MyQueue;
import com.avantica.tutorial.algorithmsdatastructures.stack.MyStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUndirectedGraph<T> implements UndirectedGraph<T>{
    private List<Vertex<T>> vertices;
    private Map<String, List<Edge>> adjacency;

    public MyUndirectedGraph() {
        vertices = new ArrayList<Vertex<T>>();
        adjacency = new HashMap<String, List<Edge>>();
    }

    public int vCount() {
        return vertices.size();
    }

    public int eCount() {
        int count = 0;
        for (Map.Entry<String, List<Edge>> entry : adjacency.entrySet()) {
            count += entry.getValue().size();
        }
        return count;
    }

    public void addEdge(Vertex v1, Vertex v2) {
        if(isNewVertex(v1))
            vertices.add(v1);

        if(isNewVertex(v2))
            vertices.add(v2);

        List<Edge> adjacents = new ArrayList<Edge>();
        Edge edge = new Edge(v2.getKey());

        if (adjacency.containsKey(v1.getKey())){
            adjacents = adjacency.get(v1.getKey());
            if(isNewEdge(adjacents, v2)){
                adjacents.add(edge);
            }
        }else{
            adjacents.add(edge);
            adjacency.put(v1.getKey(), adjacents);
        }

        if(!adjacency.containsKey(v2.getKey())){
            adjacency.put(v2.getKey(), new ArrayList<Edge>());
        }
    }

    public void deleteEdge(Vertex v1, Vertex v2) {
        String key1 = v1.getKey();
        String key2 = v2.getKey();

        removeEdge(key1, key2);
        removeEdge(key2, key1);
    }

    public boolean isConnected(Vertex v1, Vertex v2) {
        if(areAdjacent(v1.getKey(), v2.getKey()))
            return true;
        return IsConnectedInternal(v1.getKey(), v2.getKey());
    }

    private boolean IsConnectedInternal(String parentKey, String key2)
    {
        List<Edge>  adjacencyList = adjacency.get(parentKey);
        for(Edge edge : adjacencyList)
        {
            if (edge.getEndVertexKey() == key2) {
                return true;
            }else{
                return IsConnectedInternal(edge.getEndVertexKey(), key2);
            }
        }
        return false;
    }

    public List<Vertex<T>> depthFirstTraversal() {
        List<Vertex<T>> result = new ArrayList<Vertex<T>>();
        MyStack<String> stack = new MyStack<String>();
        if (adjacency.size() > 0)
        {
            String initialKey = adjacency.entrySet().iterator().next().getKey();
            stack.push(initialKey);
            while (!stack.isEmpty()) {
                String currentKey = stack.pop();
                Vertex currentVertex = getVertex(currentKey);

                if (currentVertex != null && currentVertex.getStatus() == StatusVertex.UNVISITED){
                    currentVertex.setStatus(StatusVertex.VISITED);
                    result.add(currentVertex);

                    for(Edge edge : adjacency.get(currentKey)) {
                        stack.push(edge.getEndVertexKey());
                    }
                }
            }
        }
        return result;
    }

    public List<Vertex<T>> breadthFirstTraversal() {
        List<Vertex<T>> result = new ArrayList<Vertex<T>>();
        MyQueue<String> queue = new MyQueue<String>();
        if (adjacency.size() > 0)
        {
            String initialKey = adjacency.entrySet().iterator().next().getKey();
            queue.enqueue(initialKey);
            while (!queue.isEmpty()) {
                String currentKey = queue.dequeue();
                Vertex currentVertex = getVertex(currentKey);

                if (currentVertex != null && currentVertex.getStatus() == StatusVertex.UNVISITED){
                    currentVertex.setStatus(StatusVertex.VISITED);
                    result.add(currentVertex);

                    for(Edge edge : adjacency.get(currentKey)) {
                        queue.enqueue(edge.getEndVertexKey());
                    }
                }
            }
        }
        return result;
    }

    private Vertex<T> getVertex(String key){
        for (Vertex<T> vertex : vertices) {
            if (vertex.getKey() == key) {
                return vertex;
            }
        }
        return null;
    }

    private boolean isNewVertex(Vertex vertex) {
        for(Vertex<T> currentVertex : vertices) {
            if(currentVertex.getKey() == vertex.getKey()) {
                return false;
            }
        }
        return true;
    }

    private boolean areAdjacent (String vertexKey1, String vertexKey2) {
        for (Edge edge : adjacency.get(vertexKey1)) {
            if (edge.getEndVertexKey() == vertexKey2) {
                return true;
            }
        }
        return false;
    }

    private boolean isNewEdge(List<Edge> adjacents, Vertex v2){
        for(Edge the_edge : adjacents) {
            if(the_edge.getEndVertexKey() == v2.getKey()) {
                return false;
            }
        }
        return true;
    }

    private void removeEdge(String key1, String key2) {
        for (Edge edge : adjacency.get(key1)) {
            if (edge.getEndVertexKey() == key2) {
                adjacency.get(key1).remove(edge);
            }
        }
    }
}
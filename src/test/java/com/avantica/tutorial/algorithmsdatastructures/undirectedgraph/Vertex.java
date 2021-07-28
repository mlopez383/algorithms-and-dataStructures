package com.avantica.tutorial.algorithmsdatastructures.undirectedgraph;

public class Vertex<T> {
    private String key;
    private T value;
    private StatusVertex status;

    public Vertex()
    {
        this.status = StatusVertex.UNVISITED;
    }

    public Vertex(String key, T value)
    {
        this.key = key;
        this.value = value;
        this.status = StatusVertex.UNVISITED;
    }

    public String getKey() {
        return key;
    }

    public StatusVertex getStatus() {
        return status;
    }

    public void setStatus(StatusVertex status) {
        this.status = status;
    }
}

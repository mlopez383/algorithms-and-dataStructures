package com.avantica.tutorial.algorithmsdatastructures.undirectedgraph;

public class Edge {
    private String endVertexKey;

    public Edge() {}

    public Edge(String endvertexkey)
    {
        this.endVertexKey = endvertexkey;
    }

    public String getEndVertexKey(){
        return this.endVertexKey;
    }
}

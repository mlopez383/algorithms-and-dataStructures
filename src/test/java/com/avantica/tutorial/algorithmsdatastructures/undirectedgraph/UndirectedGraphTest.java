package com.avantica.tutorial.algorithmsdatastructures.undirectedgraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class UndirectedGraphTest {
    MyUndirectedGraph graph;
    Vertex vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH;

    private void createVertices() {
        vertexA = new Vertex<String>("A", "A");
        vertexB = new Vertex<String>("B", "B");
        vertexC = new Vertex<String>("C", "C");
        vertexD = new Vertex<String>("D", "D");
        vertexE = new Vertex<String>("E", "E");
        vertexF = new Vertex<String>("F", "F");
        vertexG = new Vertex<String>("G", "G");
        vertexH = new Vertex<String>("H", "H");
    }

    private void addEdges(){
        graph.addEdge(vertexA, vertexB);
        graph.addEdge(vertexB, vertexC);
        graph.addEdge(vertexB, vertexD);
        graph.addEdge(vertexC, vertexE);
        graph.addEdge(vertexA, vertexF);
        graph.addEdge(vertexF, vertexG);
        graph.addEdge(vertexE, vertexG);
    }

    @Before
    public void initialize(){
        graph = new MyUndirectedGraph<String>();
        createVertices();
        addEdges();
    }

    @Test
    public void isCreatedGraph(){
        assertEquals("Failure - expected graph vertex size does not match", 7, graph.vCount());
        assertEquals("Failure - expected graph edge size does not match", 7, graph.eCount());
    }

    @Test
    public void testIsConnected() {
        assertTrue("Failure - expected vertices are not connected", graph.isConnected(vertexA, vertexG));
        assertTrue("Failure - expected vertices are connected", !graph.isConnected(vertexA, vertexH));
    }

    @Test
    public void testDFS() {
        List<Vertex> dft = graph.depthFirstTraversal();
        assertTrue("Failure - expected vertex does not match", dft.get(0).getKey() == "A");
        assertTrue("Failure - expected vertex does not match", dft.get(1).getKey() == "F");
        assertTrue("Failure - expected vertex does not match", dft.get(2).getKey() == "G");
        assertTrue("Failure - expected vertex does not match", dft.get(3).getKey() == "B");
        assertTrue("Failure - expected vertex does not match", dft.get(4).getKey() == "D");
        assertTrue("Failure - expected vertex does not match", dft.get(5).getKey() == "C");
        assertTrue("Failure - expected vertex does not match", dft.get(6).getKey() == "E");
    }

    @Test
    public void testBFS() {
        List<Vertex> bfs = graph.breadthFirstTraversal();
        assertTrue("Failure - expected vertex does not match", bfs.get(0).getKey() == "A");
        assertTrue("Failure - expected vertex does not match", bfs.get(1).getKey() == "B");
        assertTrue("Failure - expected vertex does not match", bfs.get(2).getKey() == "F");
        assertTrue("Failure - expected vertex does not match", bfs.get(3).getKey() == "C");
        assertTrue("Failure - expected vertex does not match", bfs.get(4).getKey() == "D");
        assertTrue("Failure - expected vertex does not match", bfs.get(5).getKey() == "G");
        assertTrue("Failure - expected vertex does not match", bfs.get(6).getKey() == "E");
    }

    @Test
    public void tesDeleteEdge() {
        assertEquals("Failure - expected graph edge size does not match", 7, graph.eCount());
        graph.deleteEdge(vertexA, vertexB);
        assertFalse("Failure - expected connected vertices does not match", graph.isConnected(vertexA, vertexB));
        assertEquals("Failure - expected graph edge size does not match", 6, graph.eCount());
    }
}

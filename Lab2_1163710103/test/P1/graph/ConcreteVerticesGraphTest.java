/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for ConcreteVerticesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteVerticesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteVerticesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteVerticesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph<>();
    }
    
    /*
     * Testing ConcreteVerticesGraph...
     */
    
    // Testing strategy for ConcreteVerticesGraph.toString()
    //   TODO
    @Test
    public void addTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	assertTrue(graph.add("A"));
    	assertFalse(graph.add("A"));
    	
    }
    
    @Test 
    public void setTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	assertEquals(0,graph.set("A","B", 4));
    	assertEquals(4,graph.set("A","B", 5));
    	assertEquals(5,graph.set("A","B", 0));
    }
    
    @Test
    public void removeTest() throws Exception{
   	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	assertEquals(0,graph.set("A","B", 4));
    	assertTrue(graph.remove("B"));
    	assertFalse(graph.targets("A").containsKey("B"));
    	assertTrue(graph.add("B"));
    }
    
    
    @Test 
    public void verticesTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	graph.add("C");
    	Set<String> set = new HashSet<>();
    	set.add("A");
    	set.add("B");
    	set.add("C");
    	assertEquals(set,graph.vertices());
    	

    }
    @Test
    public void sourcesTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	graph.add("C");
    	graph.set("A","B", 4);
    	graph.set("B","A", 5);
    	graph.set("B","C", 3);
    	Map<String ,Integer> sorA =new HashMap<>();
    	Map<String ,Integer> sorB =new HashMap<>();
    	Map<String ,Integer> sorC =new HashMap<>();
    	sorA.put("B", 5);
    	sorB.put("A", 4);
    	sorC.put("B", 3);
    	assertEquals(sorA,graph.sources("A"));
    	assertEquals(sorB,graph.sources("B"));
    	assertEquals(sorC,graph.sources("C"));
    }
    // TODO tests for ConcreteVerticesGraph.toString()
    
    /*
     * Testing Vertex...
     */
    
    // Testing strategy for Vertex
    //   TODO 一条条来慢慢测试呗
 // TODO tests for operations of Vertex
    
    @Test
    public void getVertexTest() {
    	Vertex<String> ver = new Vertex<>("A");
    	assertEquals("A",ver.getVertex());
    }
    
    @Test
    public void source_setWeightTest() {
    	Vertex<String> ver = new Vertex<>("A");
    	assertTrue(ver.source_setWeight("B",5));
    }
    
    @Test
    public void target_setWeightTest() {
    	Vertex<String> ver = new Vertex<>("B");
    	assertTrue(ver.target_setWeight("A",5));
    }
    @Test
    public void removeSourceTest() {
    	Vertex<String> ver = new Vertex<>("B");
    	assertTrue(ver.source_setWeight("A",5));
    	assertTrue(ver.removeSource("A"));
    }
    @Test
    public void removeTargetTest() {
    	Vertex<String> ver = new Vertex<>("A");
    	assertTrue(ver.target_setWeight("B",5));
    	assertTrue(ver.removeTarget("B"));
    }
    @Test
    public void getSourceTest() {
    	Vertex<String> ver = new Vertex<>("B");
    	assertTrue(ver.source_setWeight("A",5));
    	Map<String,Integer> com = new HashMap<>();
    	com.put("A",5);
    	assertEquals(com, ver.getSource());

    }
    
    @Test
    public void getTargetTest() {
    	Vertex<String> ver = new Vertex<>("A");
    	assertTrue(ver.target_setWeight("B",5));
    	Map<String,Integer> com = new HashMap<>();
    	com.put("B",5);
    	assertEquals(com, ver.getTarget());
    }
    
    
    
    
    
}

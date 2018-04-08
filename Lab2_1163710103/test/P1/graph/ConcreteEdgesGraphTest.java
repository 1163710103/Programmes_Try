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
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteEdgesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph<>();
    }
    

    /*
     * Testing ConcreteEdgesGraph...
     */
    @Test
    public void addTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	boolean S1 = graph.add("A");
    	boolean S2 = graph.add("A");
    	assertTrue(S1);
    	assertFalse(S2);	
    }
    
    @Test 
    public void setTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	graph.add("C");
    	assertEquals(0,graph.set("A","B",1));
    	assertEquals(1,graph.set("A","B",5));
    	assertEquals(5,graph.set("A","B",0));
    	assertEquals(0,graph.set("A","B",3));
    	assertEquals(0,graph.set("A","C",3));
    }
    
    @Test
    public void removeTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	graph.add("C");
    	graph.set("A","B",1);
    	graph.set("A","C",3);
    	assertFalse(graph.remove("D"));
    	assertTrue(graph.remove("A"));
    	assertTrue(graph.remove("C"));
    }
    @Test
    public void verticesTest() {
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	graph.add("C");
    	Set<String> set = new HashSet<>();
    	set.add("A");
    	set.add("B");
    	set.add("C");
    	assertEquals(set, graph.vertices());

    	
    }
    
    @Test 
    public void sourcesTest() throws Exception{
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	graph.add("C");
    	graph.set("A","B",1);
    	graph.set("A","C",3);
    	Map<String ,Integer> sor0 =new HashMap<>();
    	Map<String ,Integer> sor1 =new HashMap<>();
    	Map<String ,Integer> sor2 =new HashMap<>();
    	sor1.put("A",1);
    	sor2.put("A",3);
    	assertEquals(sor0,graph.sources("A"));
    	assertEquals(sor1,graph.sources("B"));
    	assertEquals(sor2,graph.sources("C"));


    }
    @Test
    public void targetsTest()throws Exception{
    	Graph<String> graph = emptyInstance();
    	graph.add("A");
    	graph.add("B");
    	graph.add("C");
    	graph.set("A","B",1);
    	graph.set("A","C",3);
    	Map<String ,Integer> sor1 =new HashMap<>();
    	Map<String ,Integer> sor2 =new HashMap<>();
    	sor1.put("B",1);
    	sor1.put("C",3);
    	assertEquals(sor1,graph.targets("A"));
    	assertEquals(sor2,graph.targets("C"));
    	


    }
    // Testing strategy for ConcreteEdgesGraph.toString()
    //   TODO判断是否为空的图，若不是则返回它的内存地址
    
    // TODO tests for ConcreteEdgesGraph.toString()
    @Test 
    public void toStringTest(){
    	Graph<String> graph = emptyInstance();
    	String str = "Empty Graph";
    	assertEquals(str,graph.toString());
    	
    }
    
    /*
     * Testing Edge...
     */
    
    // Testing strategy for Edge
    //   TODO一个个进行简单的测试
    
    // TODO tests for operations of Edge
    @Test
    public void testGetSource(){
        Edge<String> edge = new Edge<>(3,"A","B");
        assertEquals("Expected source vertex", "A", edge.getSource()); 
}
    @Test
    public void testGetTarget(){
        Edge<String> edge = new Edge<>(3,"A","B");
        assertEquals("Expected target vertex", "B", edge.getTarget()); 
}
    @Test
    public void testGetWeight(){
        Edge<String> edge = new Edge<>(3,"A","B");
        assertEquals("Expected weight", 3, edge.getWeight()); 
}
    @Test
    public void testSetWeight() {
    	Edge<String> edge = new Edge<>(3,"A","B");
    	Edge<String> edge1 = edge.setWeight(5);
    	Edge<String> edgetest = new Edge<>(5,"A","B");
        assertEquals( edgetest, edge1); 
    }
}

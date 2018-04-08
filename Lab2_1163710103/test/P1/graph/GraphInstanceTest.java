/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    // 测试所有的函数，确保他们能在所有情况下成功运行
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        // TODO you may use, change, or remove this test
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    
    // TODO other tests for instance methods of Graph
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
    public void verticesTest() throws Exception {
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
}

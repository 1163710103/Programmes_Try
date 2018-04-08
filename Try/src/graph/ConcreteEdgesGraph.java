/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph implements Graph<String> {
    
    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    
    // TODO checkRep
    private void checkRep(){
        final int sizeOfEdges = edges.size();
        final int sizeOfVertices = vertices.size();
        int minNumberOfVertices = 
                sizeOfEdges == 0 ? 0 : (int)Math.ceil(Math.sqrt(2 * sizeOfEdges) + 0.5);
        
        assert sizeOfVertices >= minNumberOfVertices;  
}
    
    @Override public boolean add(String vertex) {
        if(vertices.contains(vertex)) {
        	return false;
        }
        else {
        	vertices.add(vertex);
        	return true;
        }
    }
    
    @Override public int set(String source, String target, int weight) {
    	int previous = 0;
        for(int i = 0;i < edges.size();i++){
        	if((edges.get(i).getSource() == source)&&(edges.get(i).getTarget() == target)) {
        		previous = edges.get(i).getWeight();
        		if(weight == 0) {
        			edges.remove(i);
        			return previous;
        		}
        		else {
        			edges.get(i).setWeight(weight);
        			return previous;
        		}
        	}
        }
        Edge newedge = new Edge(weight,source,target);
        edges.add(newedge);
        return previous;
     
    }
    
    @Override public boolean remove(String vertex) {
    	if(vertices.contains(vertex)) {
    		vertices.remove(vertex);
    		for(int i = 0;i < edges.size();i++){
    			if(edges.get(i).getSource() == vertex) {
    				edges.remove(i);
    			}
    			else if(edges.get(i).getTarget() == vertex){
    				edges.remove(i);
    			}
    		}
        	return true;
        }
        else {
        	return false;
        }
    }
    
    @Override public Set<String> vertices() {
        return this.vertices;
    }
    
    @Override public Map<String, Integer> sources(String target) {
        Map<String ,Integer> source_edge = new HashMap<>();
        for(int i = 0;i < edges.size();i++) {
        	if(edges.get(i).getTarget() == target) {
        		source_edge.put(edges.get(i).getSource(),edges.get(i).getWeight());
        	}
        }
        return source_edge;
    }
    
    @Override public Map<String, Integer> targets(String source) {
    	Map<String ,Integer> target_edge = new HashMap<>();
        for(int i = 0;i < edges.size();i++) {
        	if(edges.get(i).getSource() == source) {
        		target_edge.put(edges.get(i).getTarget(),edges.get(i).getWeight());
        	}
        }
        return target_edge;    
        }
    
    // TODO toString()
    @Override public String toString(){
        if ( edges.isEmpty() ) {
            return "Empty Graph";
        }
        return edges.stream()
                .map(edge -> edge.toString())
                .collect(Collectors.joining("\n"));
}
//  //test
//    public static void main(String[] agrc) {
//    	ConcreteEdgesGraph graph = new ConcreteEdgesGraph();
//    	graph.add("A");
//    	graph.add("B");
//    	graph.set("A", "B", 5);
//    	System.out.println(graph.edges.get(0).toString());
//    }
//    //
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge {
    
    // TODO fields
    private String target;
    private String source;
    private int weight;
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    public Edge(int weight,String source,String target) {
    	this.weight = weight;
    	this.source = source;
    	this.target = target;
    	checkRep();
    }
    // TODO checkRep
    private void checkRep(){
        assert source != null;
        assert target != null;
        assert weight > 0;
}
    // TODO methods
    public String getTarget() {
    	return target;
    }
    public String getSource() {
    	return source;
    }
    public int getWeight() {
    	return weight;
    }
    public boolean setTarget(String target) {
    	this.target = target;
    	return true;
    }
    public boolean setSource(String source) {
    	this.source = source;
    	return true;
    }
    public boolean setWeight(int weight) {
    	this.weight = weight;
    	checkRep();
    	return true;
    }
    	
    // TODO toString()
    @Override public String toString(){
        return getSource().toString()+" -> "+getTarget().toString()+": "+getWeight();
}
    
    
    
    
    
}



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


/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph<L> implements Graph<L> {
    
    private final Set<L> vertices = new HashSet<>();
    private final List<Edge<L>> edges = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO  
//    Set<L>
//    List<Edge>
    // Safety from rep exposure:
    //   TODOʹ��finalȥ���첻�ɱ�Ķ��������
    
    // TODO constructor Ĭ�ϵļ���
    // TODO checkRep
    private void checkRep(){
        final int sizeOfEdges = edges.size();
        final int sizeOfVertices = vertices.size();
        final int maxEdges;
        if(sizeOfVertices <=1 ) {
        	maxEdges = 0;
        }
        else maxEdges = sizeOfVertices*(sizeOfVertices-1);
        //����ͼ��������maxedges�붥��n�Ĺ�ϵ��maxedges <= n(n-1)
        assert sizeOfEdges <= maxEdges;  
}
    
    @Override public boolean add(L vertex) {
        if(vertices.contains(vertex)) {
        	return false;
        }
        else {
        	vertices.add(vertex);
            checkRep();
        	return true;
        }
    }
    
    @Override public int set(L source, L target, int weight) {
    	int previous = 0;
        for(int i = 0;i < edges.size();i++){
        	if((edges.get(i).getSource() == source)
        			&&(edges.get(i).getTarget() == target)) {
        		previous = edges.get(i).getWeight();
        		if(weight == 0) {
        			edges.remove(i);
        			checkRep();
        			return previous;
       		}
        		else {
        			edges.set(i, edges.get(i).setWeight(weight));
        			checkRep();
        			return previous;
        		}
        	}
        }
        Edge<L> newedge = new Edge<>(weight,source,target);
        edges.add(newedge);
        checkRep();
        return previous;
     
    }
    
    @Override public boolean remove(L vertex) {
    	if(vertices.contains(vertex)) {
    		vertices.remove(vertex);
    		for(int i = 0;i < edges.size();i++){
    			if(edges.get(i).getSource() == vertex) {
    				edges.remove(i);
    				checkRep();
    			}
    			else if(edges.get(i).getTarget() == vertex){
    				edges.remove(i);
    				checkRep();
    			}
    		}
        	return true;
        }
        else {
        	return false;
        }
    }
    
    @Override public Set<L> vertices() {
        return this.vertices;
    }
    
    @Override public Map<L, Integer> sources(L target) {
        Map<L ,Integer> source_edge = new HashMap<>();
        for(int i = 0;i < edges.size();i++) {
        	if(edges.get(i).getTarget() == target) {
        		source_edge.put(edges.get(i).getSource(),edges.get(i).getWeight());
        	}
        }
        return source_edge;
    }
    
    @Override public Map<L, Integer> targets(L source) {
    	Map<L ,Integer> target_edge = new HashMap<>();
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
//  //�򵥲���
//    public static void main(String[] agrc) {
//    	ConcreteEdgesGraph graph = new ConcreteEdgesGraph();
//    	graph.add("A");
//    	graph.add("B");
//    	graph.set("A", "B", 5);
//    	System.out.println(graph.edges.get(0).toString());
//    	
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
class Edge<L> {
    
    // TODO fields
    private final L target;
    private final L source;
    private final int weight;
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    public Edge(int weight,L source,L target) {
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
    public L getTarget() {
    	return target;
    }
    public L getSource() {
    	return source;
    }
    public int getWeight() {
    	return weight;
    }
    public Edge<L> setWeight(int newweight) {
    	return new Edge<>(newweight,source,target);
    }
    // TODO toString()
    @Override public String toString(){
        return getSource().toString()+" -> "
    +getTarget().toString()+": "+getWeight();
}
    
    
    @Override public boolean equals(Object that){
        Edge<L> thatEdge = (Edge<L>)that;
        return (  this.getSource().equals(thatEdge.getSource()) ) 
        		&& (  this.getTarget().equals(thatEdge.getTarget())  ) && 
        		(  this.getWeight() == thatEdge.getWeight()  );
    }
    @Override public int hashCode(){
        final int prime = 60;
        int result = 0;
        result = prime * result * getSource().hashCode();
        result = prime * result * getTarget().hashCode();
        result = prime * result * getWeight();
        return result;
}
    
    
    
    
}



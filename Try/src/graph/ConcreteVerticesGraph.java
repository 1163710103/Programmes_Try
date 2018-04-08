/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.ArrayList;
import java.util.Collections;
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
public class ConcreteVerticesGraph<L> implements Graph<L> {
    
    private final List<Vertex<L>> vertices = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
//    List<Vertex>
    
    // Safety from rep exposure:
    //   TODO使用checkrep进行检查
    
    // TODO constructor
//    	默认
    
    
    @Override public boolean add(L vertex) {
    	for(Vertex<L> ver : vertices) {
    		if(ver.getVertex().equals(vertex)) {
    			return false;
    		}
    	}
    	Vertex<L> vert = new Vertex<>(vertex);
    	vertices.add(vert);
    	return true;
    }
    
    @Override public int set(L source, L target, int weight) {
    	int pre;
    	//修改
    	for(Vertex<L> ver_s : vertices) {
    		if(ver_s.getVertex().equals(source)) {
    				for	(Vertex<L> ver_t : vertices) {
    					if(ver_t.getVertex().equals(target)) {
    						
    						if(weight == 0) {
        						if(ver_s.getTarget().get(target) == null) {
        							pre = 0;
        						}
        						else {
        							pre = (int)ver_s.getTarget().get(target);
        						}
        						ver_s.removeTarget(target);
        						ver_t.removeSource(source);
        						return pre;
        					}
        					//不然就修改
        					else {
        						if(ver_s.getTarget().get(target) == null) {
        							pre = 0;
        						}
        						else {
        							pre = (int)ver_s.getTarget().get(target);
        						}
        						ver_s.target_setWeight(target, weight);
        						ver_t.source_setWeight(source, weight);
        						return pre;
        					}
    					}
    					//若weight为零则删除
    					
    				}
    			
    			}
    	}
    	return -1;	//报错
    	
    }
    
    @Override public boolean remove(L vertex) {
    	int flag = 0;
    	//清理点
    	for(int i = 0;i < vertices.size();i++) {
    		if(vertices.get(i).getVertex().equals(vertex)) {
    			vertices.remove(i);
    			flag = 1;
    		}
    	//清理边
    		
    	}
    	if(flag == 1) {
    		for(Vertex<L> ver : vertices) {
    			if(ver.getSource().containsKey(vertex)) {
    				ver.removeSource(vertex);
    			}
    			else if(ver.getTarget().containsKey(vertex)) {
    				ver.removeTarget(vertex);
    			}  		
    		}
    		return true;
    	}
    	else return false;
    	
    
}
    @Override public Set<L> vertices() {
    	Set<L> set = new HashSet<>();
    	for(Vertex<L> ver : vertices) {
    		set.add(ver.getVertex());
    	}
        return set;
    }
    
    @Override public Map<L, Integer> sources(L target) {
    	Map<L, Integer> sou = new HashMap<>();
    	for(Vertex<L> ver : vertices) {
    		if(ver.getTarget().containsKey(target)) {
        		sou.put(ver.getVertex(),ver.getTarget().get(target));
    		}
    	}
    	return sou;
    }
    
    @Override public Map<L, Integer> targets(L source) {
    	Map<L, Integer> sou = new HashMap<>();
    	for(Vertex<L> ver : vertices) {
    		if(ver.getSource().containsKey(source)) {
        		sou.put(ver.getVertex(),ver.getSource().get(source));
    		}
    	}
    	return sou;
    }
    
    // TODO toString()
    @Override public String toString(){
        return vertices.stream()
                .filter(vertex -> vertex.getTargets().size() > 0)
                .map(vertex -> vertex.getVertex().toString() + " -> " + vertex.getTargets())
                .collect(Collectors.joining("\n"));
}

}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Vertex<L> {
   
    // TODO fields
    private L name;
    private Map<L, Integer> sources = new HashMap<>();
    private Map<L, Integer> targets = new HashMap<>();
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    public Vertex(L label) {
    	name = label;
    }
    // TODO checkRep
    private void checkRep(){
        final Set<L> sourceLabels = sources.keySet();
        final Set<L> targetLabels = targets.keySet();
        
        assert (!sourceLabels.contains(name));
        assert (!targetLabels.contains(name));
}
    // TODO methods
    public L getVertex() {
    	return name;
    }
    public Map<L,Integer> getSource() {
    	return sources;
    }
    public Map<L,Integer> getTarget() {
    	return targets;
    }
    public boolean removeSource(L source) {
    	if(sources.containsKey(source)) {
        	sources.remove(source);
        	return true;
    	}
    	return false;
    }
    public boolean removeTarget(L target) {
    	if(targets.containsKey(target)) {
    		targets.remove(target);
    		return true;
    	}
    	return false;
    }
    public boolean source_setWeight(L source,int weight) {
    		sources.put(source,weight);
    		checkRep();
    		return true;
    }
    public boolean target_setWeight(L target,int weight) {
    		targets.put(target,weight);
    		checkRep();
    		return true;
    }
    public Map<L, Integer> getTargets(){
        return Collections.unmodifiableMap(targets);
}
    public Map<L, Integer> getSources(){
        return Collections.unmodifiableMap(sources);
}
    // TODO toString()
    @Override public String toString(){
        return String.format(
                "%s -> %s \n" +
                "%s <- %s",
                name.toString(), this.targets,
                name.toString(), this.sources);
}
	
}

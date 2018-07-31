/**
 * 
 */
package project.programcreek.graph;

import java.util.List;

/**
 * @author shekh
 *
 */
public class GraphNode {
	int val;
	GraphNode next;
	List<GraphNode> neighbors;
	boolean visited = false;
	
	GraphNode(){
		
	}
	
	GraphNode(int value){
		this.val = value;
	}
	
	
	
	@Override
	public String toString(){
		return "Val: " + val;
	}
}
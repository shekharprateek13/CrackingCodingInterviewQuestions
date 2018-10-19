package dsalgoproblems.project.programcreek.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author shekh
 */
public class CloneGraph {

	public static GraphNode cloneGraph(GraphNode root){
		Map<GraphNode,GraphNode> map = new HashMap<GraphNode,GraphNode>();
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		GraphNode newRoot = new GraphNode(root.val);
		map.put(root,newRoot);
		queue.add(root);

		while(!queue.isEmpty()){
			GraphNode node = queue.pop();
			GraphNode copyNode = map.get(node);
			List<GraphNode> neighbors = node.neighbors;
			for(GraphNode n:neighbors){
				GraphNode temp = new GraphNode(n.val);
				if(!map.containsKey(n)){
					map.put(n,temp);
					map.get(node.neighbors.add(temp));
				}else{
					map.get(node.neighbors.add(temp));
				}
			}
		}
		return newRoot;
	}
	
	public static void BFS(GraphNode root){
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(root);
		root.visited = true;
		while(!queue.isEmpty()){
			GraphNode node = queue.pop();
			System.out.println(node);
			for(GraphNode n: node.neighbors){
				if(!n.visited){
					n.visited = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		
		n1.neighbors = new ArrayList<GraphNode>();
		n2.neighbors = new ArrayList<GraphNode>();
		n3.neighbors = new ArrayList<GraphNode>();
		n4.neighbors = new ArrayList<GraphNode>();

		n1.neighbors.add(n2);
		n1.neighbors.add(n3);
		
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		n2.neighbors.add(n4);
		
	    n3.neighbors.add(n1);
		n3.neighbors.add(n2);
		n3.neighbors.add(n4);
		
		n4.neighbors.add(n2);
		n4.neighbors.add(n3);
		BFS(n1);
		
		GraphNode newRoot = cloneGraph(n1);
		BFS(newRoot);
	}
}
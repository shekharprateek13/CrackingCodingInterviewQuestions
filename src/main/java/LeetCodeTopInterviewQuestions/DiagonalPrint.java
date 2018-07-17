package LeetCodeTopInterviewQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DiagonalPrint {

	static class TreeNode{
		int data;
		TreeNode left, right;

		TreeNode(){}

		TreeNode(int item){
			data = item;
			left = right = null;
		}
		
		@Override
		public String toString(){
			return String.valueOf(data);
		}
	}
	
	public static void diagonalPrint(TreeNode node,Map<Integer,List<TreeNode>> map, int slope){
		if(node == null){
			return;
		}
		
		List<TreeNode> list = map.get(slope);
		
		if(list == null){
			list = new LinkedList<TreeNode>();
			list.add(node);
		}else{
			list.add(node);
		}
		
		map.put(slope,list);
		
		diagonalPrint(node.left,map,slope+1);
		diagonalPrint(node.right,map,slope);
	}

	public static void main(String[] args){
		TreeNode tree = new TreeNode();
        tree = new TreeNode(6);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(-1);
        tree.left.right.right = new TreeNode(-7);
        tree.right.right = new TreeNode(2);
        tree.right.right.left = new TreeNode(20);
        
        Map<Integer,List<TreeNode>> map = new HashMap<Integer,List<TreeNode>>();
        diagonalPrint(tree,map,0);
        for(Integer key:map.keySet()){
        	System.out.println("Key:"+key+"::::"+map.get(key));
        }
        
	}
}
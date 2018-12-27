package dsalgoproblems.project.programcreek.tree;

import java.util.LinkedList;

/**
 * Iterator will be initialized with the root node of a BST. Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {

    LinkedList<TreeNode> stack = new LinkedList<>();

    public BinarySearchTreeIterator(TreeNode root){
        TreeNode temp = root;
        while(temp!=null){
            stack.push(temp);
            temp = temp.leftChild;
        }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public TreeNode next(){
        TreeNode node = stack.pop();
        if(node.rightChild!=null){
            TreeNode temp = node.rightChild;
            while(temp!=null){
                stack.push(temp);
                temp = temp.leftChild;
            }
        }
        return node;
    }

    public  static void main(String...args){
        TreeNode root = new TreeNode(50);
        root.leftChild = new TreeNode(40);
        root.leftChild.leftChild = new TreeNode(30);
        root.leftChild.leftChild.leftChild = new TreeNode(20);
        root.leftChild.rightChild = new TreeNode(45);
        root.leftChild.rightChild.rightChild = new TreeNode(47);
        root.leftChild.rightChild.rightChild.leftChild = new TreeNode(46);
        root.leftChild.rightChild.rightChild.rightChild = new TreeNode(48);
        root.leftChild.rightChild.rightChild.rightChild.rightChild = new TreeNode(49);


        root.rightChild = new TreeNode(80);
        root.rightChild.leftChild = new TreeNode(70);
        root.rightChild.rightChild = new TreeNode(90);

        BinarySearchTreeIterator bstIterator = new BinarySearchTreeIterator(root);

        while(bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }



    }
}

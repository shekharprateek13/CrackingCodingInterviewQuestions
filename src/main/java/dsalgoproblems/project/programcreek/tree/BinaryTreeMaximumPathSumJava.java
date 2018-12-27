package dsalgoproblems.project.programcreek.tree;

public class BinaryTreeMaximumPathSumJava {

    public static int getMaxPathSum(TreeNode node, int[] max){
        if(node == null){
            return 0;
        }

        int left = getMaxPathSum(node.leftChild,max);
        int right = getMaxPathSum(node.rightChild, max);

        int currentMax = Math.max(node.data,Math.max(left + node.data, right + node.data));

        max[0] = Math.max(max[0],Math.max(currentMax, left + right + node.data));

        return currentMax;
    }


    public static void main(String...args){
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;

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

        System.out.println(getMaxPathSum(root,max));

    }
}

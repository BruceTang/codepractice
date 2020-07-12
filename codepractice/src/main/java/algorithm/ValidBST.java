package algorithm;

import java.util.Stack;

/**
 *
 */
public class ValidBST {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);

        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node4.right = node6;

        System.out.println(isValidBST(node5));

        System.out.println(isValidBST2(node5));
    }

    /**
     * 函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否都在 (l,r)(l,r) 的范围内（注意是开区间）。
     * 如果 root 节点的值 val 不在 (l,r)(l,r) 的范围内说明不满足条件直接返回，
     * 否则我们要继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
     那么根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界 upper 改为 root.val，即调用 helper(root.left, lower, root.val)，
     因为左子树里所有节点的值均小于它的根节点的值。
     同理递归调用右子树时，我们需要把下界 lower 改为 root.val，即调用 helper(root.right, root.val, upper)
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public static boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }


    /**
     * 中序遍历法
     * 二叉搜索树「中序遍历」得到的值构成的序列一定是升序的，
     * 这启示我们在中序遍历的时候实时检查当前节点的值是否大于前一个中序遍历到的节点的值即可。
     * 如果均大于说明这个序列是升序的，整棵树是二叉搜索树，否则不是
      * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}

class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }
}

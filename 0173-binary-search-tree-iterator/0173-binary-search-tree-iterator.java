/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st ;
    TreeNode root ;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        this.root = root;
    }
    
    public int next() {
        while(root != null) {
            st.push(root);
            root = root.left;
        }   
        TreeNode top = st.pop();
        root = top.right;
        return top.val;
    }
    
    public boolean hasNext() {
        return (root != null || !st.isEmpty());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
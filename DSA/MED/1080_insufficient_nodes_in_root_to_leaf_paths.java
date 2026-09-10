class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    TreeNode dfs(TreeNode node, int sum, int limit) {
        if (node == null)
            return null;

        sum += node.val;

        // Leaf node
        if (node.left == null && node.right == null) {
            return sum >= limit ? node : null;
        }

        node.left = dfs(node.left, sum, limit);
        node.right = dfs(node.right, sum, limit);

        // If both children are removed, this node is insufficient
        if (node.left == null && node.right == null)
            return null;

        return node;
    }
}
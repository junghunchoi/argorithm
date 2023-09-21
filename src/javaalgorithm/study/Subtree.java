package javaalgorithm.study;

//https://leetcode.com/problems/subtree-of-another-tree/description/
public class Subtree {

	public boolean isSubTree(TreeNode root, TreeNode subtree) {

		if (root==null) return false;
		if(isSame(root,subtree)) return true;

		return isSubTree(root.left, subtree) || isSubTree(root.right, subtree);
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if(s==null && t==null) return true;
		if(s==null || t==null) return false;

		if(s==t) return true;


		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}




	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

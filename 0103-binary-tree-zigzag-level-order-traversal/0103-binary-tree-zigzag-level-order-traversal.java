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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        boolean flag=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int qs=q.size();
            List<Integer> a=new ArrayList<>();
            for(int i=0;i<qs;i++){
                TreeNode f=q.remove();
                a.add(f.val);
                if(f.left!=null)
                q.add(f.left);
                if(f.right!=null)
                q.add(f.right);
            }
            if(!flag)
            Collections.reverse(a);
            ans.add(a);
            flag=!flag;
        }
        return ans;
    }
}
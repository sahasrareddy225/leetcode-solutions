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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String ans="";
        StringBuilder path1=new StringBuilder();
        boolean start=findPath(root,startValue,path1);
        StringBuilder path2=new StringBuilder();
        boolean dest=findPath(root,destValue,path2);
        int i=0,j=0;
        while(i<path1.length() && j<path2.length() && path1.charAt(i)==path2.charAt(j)){
            i++;
            j++;
        }
        while(i<path1.length()){
            ans+='U';
            i++;
        }
        while(j<path2.length()){
            ans+=path2.charAt(j);
            j++;
        }
        return ans;
    }
    boolean findPath(TreeNode root,int x,StringBuilder path){
        if(root==null) return false;
        if(root.val==x) return true;
        if(root.left!=null){
            path.append('L');
            boolean leftAns=findPath(root.left,x,path);
            if(leftAns) return true;
            path.setLength(path.length()-1);
        }
        if(root.right!=null){
            path.append('R');
            boolean rightAns=findPath(root.right,x,path);
            if(rightAns) return true;
            path.setLength(path.length()-1);
        }
        return false;
    }
}
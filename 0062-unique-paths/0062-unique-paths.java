class Solution {
    long ncr(int n,int r){
        r=Math.min(r,n-r);
        long ans=1;
        for(int i=1;i<=r;i++)
        ans=ans*(n-r+i)/i;
        return ans;
    }
    public int uniquePaths(int m, int n) {
        return (int) ncr(m+n-2,m-1);
    }
}
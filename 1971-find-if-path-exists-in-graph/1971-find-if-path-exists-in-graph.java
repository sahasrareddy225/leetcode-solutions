class UFDS{
    int n;
    int [] p;
    int [] sz;
    public UFDS(int n){
        this.n=n;
        p=new int[n];
        sz=new int[n];
        for(int i=0;i<n;i++){
            p[i]=i;
            sz[i]=1;
        }
    }
    int find(int x){
        if(x==p[x])
        return x;
        return p[x]=find(p[x]);
    }
    boolean merge(int x,int y){
        int lx=find(x);
        int ly=find(y);
        if(lx==ly) return false;
        p[ly]=lx;
        return  true;
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UFDS ds=new UFDS(n);
        for(int [] x : edges){
            ds.merge(x[0],x[1]);
        }
        if(ds.find(source)==ds.find(destination))
        return true;
        return false;
    }
}
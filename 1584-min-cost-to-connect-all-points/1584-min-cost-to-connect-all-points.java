class Edge{
    int u;
    int v;
    int w;
    public Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}
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
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges=new ArrayList<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int d=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new Edge(i,j,d));
            }
        }
        Collections.sort(edges,(e1,e2) -> {
            return e1.w-e2.w;
        });
        int count=0;
        int mst_cost=0;
        UFDS ds=new UFDS(n);
        for(Edge e : edges){
            if(ds.merge(e.u,e.v)){
                count++;
                mst_cost+=e.w;
                if(count==n-1)
                break;
            }
        }
        return mst_cost;
    }
}
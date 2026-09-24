class Solution {
    static int [] lpf=new int[1001];
    static{
        for(int i=0;i<=1000;i++){
            lpf[i]=i;
        }
        for(int i=2;i<=Math.sqrt(1000);i++){
            if(lpf[i]==i){
                for(int j=i*i;j<=1000;j+=i){
                    if(lpf[j]==j)
                    lpf[j]=i;
                }
            }
        }
    }
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int x : nums){
            while(x>1){
                set.add(lpf[x]);
                x/=lpf[x];
            }
        }
        return set.size();
    }
}
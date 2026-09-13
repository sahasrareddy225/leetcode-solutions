class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int profit=0;
        for(int x : prices){
            if(x<min)
            min=x;
            else if(x-min>profit)
            profit=x-min;
        }
        return profit;
    }
}
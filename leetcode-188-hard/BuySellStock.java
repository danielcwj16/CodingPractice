public class BuySellStock {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<2 || k<1) return 0;
        
         
        //用II的解法优化k > prices.length / 2的情况
        if(k>(prices.length/2)) return max(prices);
        
       
        int[][] global = new int[prices.length][k+1];
        int[][] local = new int[prices.length][k+1];
        for(int i=1;i<prices.length;i++){
            int diff = prices[i] - prices[i-1];
            for(int j=1;j<k+1;j++){                
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff,0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j],local[i][j]);
            }
        }
        return global[prices.length-1][k];
    }
    
    //Best time to buy and sell stocks II
    public int max(int[] prices){
        int sum = 0;
        for(int i=1;i<prices.length;i++){
            if((prices[i]-prices[i-1])>0){
                sum += (prices[i]-prices[i-1]);
            }
        }
        return sum;
    }
}
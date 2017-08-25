/**
 * 最多两次交易，那么两次交易分布在两个区间[0,i]和[i,len-1]，两次遍历prices数组， 求得各个区间的最大收益
 */
import java.util.*;

public class BuyStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <=1)
            return 0;
        
        int len = prices.length;
        int min = prices[0];
        int[] arrayleft = new int[len];
        
        for(int i=1;i<len;i++){
            min = Math.min(min,prices[i]);
            arrayleft[i]  = Math.max(arrayleft[i-1],prices[i]-min);
        }
        
        int max = prices[len-1];
        int[] arrayright = new int[len];
        
        for(int i=len-2;i>=0;i--){
            max = Math.max(max,prices[i]);
            arrayright[i] = Math.max(arrayright[i+1],max-prices[i]);
        }
        
        int maxprofit = 0;
        
        for(int i=0;i<len;i++){
            maxprofit = Math.max(maxprofit,arrayleft[i] + arrayright[i]);
        }
        
        return maxprofit;
    }
}

/**
 * 分三种情况：
 * 1.第一条边和第四条边相交
 * 2.第一条边和第五条边相交
 * 3.第一条边和第六条边相交
 */
import java.util.*;

public class SelfCrossing{
    public boolean isSelfCrossing(int[] x){
        if(x.length<4)
        return false;

        for(int i=3;i<x.length;i++){
            if(x[i]>=x[i-2]&&x[i-1]<=x[i-3])
            return true;
            else if(i>=4 && x[i-1]==x[i-3]&&x[i]>=(x[i-2]-x[i-4]))
            return true;
            else if(i>=5 && x[i]>=(x[i-2]-x[i-4]) && x[i-1]>=(x[i-3]-x[i-5]) && x[i-2]>x[i-4]&&x[i-3]>=x[i-1])
            return true;    
        }
        return false;
    }
}
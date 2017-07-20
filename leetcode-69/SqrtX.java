/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
/**
 * 
 */
import java.util.*;

public class SqrtX{
    public int mySqrt(int x){
        int low = 0;
        int high = x;
        while(low <= high){
            long mid = (long)(high + low)/2;
            if(mid*mid == x)
                return (int)mid;
            else if(mid*mid < x){
                low = (int)mid+1;
            }else{
                high = (int)mid - 1;
            }
        }
        return high;
    }
}
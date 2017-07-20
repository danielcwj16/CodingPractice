/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
/*
简单的双指针遍历，查询字符串是否是子串。
PS： 可以用KMP算法，进阶练习掌握
*/
import java.util.*;
public class ImplementstrStr{
    public int solution(String haystack,String needle){
        if(needle.length()==0)
            return -1;
        for(int i=0;i<haystack.length();i++){
            if(haystack.length()-i+1 < needle.length())
                return -1;
            int k = i;
            int j = 0;
            while(j<needle.length()&&k<haystack.length()&&needle.charAt(j)==haystack.charAt(k)){
                k++;
                j++;
                if(j== needle.length()){
                    return i;
                }
            }
            return -1;
        }
    }
}
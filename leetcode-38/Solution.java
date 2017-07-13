import java.util.*;

 /**
  * 简单的遍历字符串，注意起始index位置
  */
public class Solution{
    public String countandsay(int n){
        if(n == 0)
            return "0";
        String str = "1";
        for(int i = 1;i<n;i++){
            str = helper(str);
        }
        return str;
    }
    public String helper(String s){
        int count = 1;
        char num = s.charAt(0);

        StringBuilder sb = new StringBuilder();

       for(int i= 1;i<s.length();i++){
            char cur = s.charAt(i);

            if(num == cur){
                count++;
            }else{
                sb.append(count).append(num);
                num = cur;
                count = 1;
            }
        }

        sb.append(count).append(num);
        return sb.toString();
    }
}

/**
 * 用栈来记录之前的数字，遇到加号和减号就入栈，遇到乘除则用栈顶元素计算，将结果再入栈
 */
import java.util.*;
class Calculator {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        
        int res = 0;
        char sign = '+';
        int n = s.length();
        int num = 0;
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            
            if(c >='0' && c <='9'){
                num = num*10 + (s.charAt(i)-'0');
            }
            if((c < '0'&&c!= ' ')||i == n-1){
                if(sign == '+')st.push(num);
                if(sign == '-')st.push(-num);
                if(sign == '*')st.push(st.pop()*num);
                if(sign =='/')st.push(st.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        while(!st.isEmpty()){
            res += st.pop();
        }
        
        return res;
    }
}
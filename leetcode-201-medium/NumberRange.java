/**
 * 当m和n不相等时，range中肯定包括奇数和偶数，那么最后一位肯定为0
 */
class NumberRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0)
            return 0;
        int movefactor = 1;
        while(m != n){
            m>>=1;
            n>>=1;
            movefactor <<=1;
        }
        
        return m * movefactor;
    }
}
/**
 * Implement pow(x, n).
 */

public class PowerOfX{
    public double myPow(double x, int n) {
        if(n<0)
            return 1/pow(x,-1*n);
        else
            return pow(x,n);
    }
    public double pow(double x,int n){
        if(n==0)
            return 1;
        double v = pow(x,n/2);
        if(n%2 == 1)
            return v*v*x;
        else
            return v*v;
    }
}

public double myPow(double x, int m) {
            double temp=x;
            if(m==0)
            return 1;
            temp=myPow(x,m/2);
            if(m%2==0)
            return temp*temp;
            else 
            {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
            }
    }

    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        if( n < 0) {
            if( n == Integer.MIN_VALUE) {
                n++; // Make -2147483648 to -2147483647
                if(x < 0) {
                    x = -x; //we made n odd so need to update sign
                }
            }
            n = -n;
            x = 1/x;
        }
        if(n % 2 == 0) {
            return myPow(x*x, n/2);
        }
        else {
            return x * myPow(x*x, n/2);
        }
    }
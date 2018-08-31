package cn.zh.jdbc.util;

/**
 * @author ZH
 * @version 1.0
 * */
public class RandomUtil {

	public static int getRandom(int m,int n){  
        int random=(int)(Math.random()*(n-m))+m;  
        return random;  
    }  
  
    //获取位数为n的随机数  
    public static int getRandom(int length){  
        int m=getNumber(length);  
        int n=m*10-1;  
        int random=(int)(Math.random()*(n-m))+m;  
        return random;  
    }  
  
    public static int getNumber(int n){  
        if(n<1){  
            n=1;  
        }  
        if(n==1){  
            return 1;  
        }else{  
            n=n-1;  
            return 10*getNumber(n);  
        }  
    }  
}

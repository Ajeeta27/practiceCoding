import java.util.*;

Pair<Boolean, Integer> solutionCheck(int index, long s, int[] prices, int count, long[][] dp){

    if(s == 0){
        return new Pair(true, 0);
    }
    
    if(index >= prices.length){
        return new Pair(false, -1);
    }
    
       
    Pair<Boolean, Integer> select;
    Pair<Boolean, Integer> notSelect;
    

    if(prices[index] <= s){
        select = 1 + solutionCheck(index+1, s - prices[index], prices, dp); 
    }

    if(solutionCheck(index+1, s, prices, count, dp) == true)
        notSelect = solutionCheck(index+1, s, prices, count, dp); 
    
    Pair<Boolean, Integer> result ;
    Boolean x = result.getKey || notSelect.getKey();
    Integer y = Math.max(select, notSelect);
    
    result = new Pair(x,y);
    
    return result;
  
}
int solution(int n, long s, int[] price) {
    
    long [][] dp = new long[n][(int)s+1];
    for (int i =0; i < n ;i++){
        Arrays.fill(dp , -1);
    }
    
    int index =0;
    solutionCheck(index, s, price, 0, dp); 
    
    if(globalCount ==-1){
        return globalCount;
    }
    int result = (int) dp[0][(int)s+1];
    return result;
}



max((1+ func(index+1, s-input[index]))

 index+1)
 
 fund(index, s)
 
 // select with constraints 
    res1 = 1 + func(index+1, s-input[index])
 
 // no select 
    res2 = func(index+1, s)
    
    
    Max(res1, res2);
    
 */   


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}

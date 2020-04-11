import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hackerrank7 {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	int[] coins = new int[] {1, 5, 10, 25};
    	int[][] dp =  new int[coins.length + 1][n + 1];
    	dp[0][0] = 1;
    	
    	for(int i = 1; i < dp.length; i++) {								
    		dp[i][0] = 1;
    		for(int j = 1; j < dp[0].length; j++) {
    			dp[i][j] = dp[i - 1][j];
    			if(j - coins[i - 1] >= 0) {
    				dp[i][j] += dp[i][j - coins[i - 1]];
    			}
    		}
    		
    	}
    	long[] numPermutation = new long[1];
    	long chainPermutation = 1;
    	solve(coins.length, n, dp, new int[26], numPermutation, coins, chainPermutation);
    	System.out.println(numPermutation[0]);
    }
	
	static void solve(int r, int c, int[][] dp, int[] trackedCoins, long[] numPermutation, int[] coinValues, long chainPermutation) {
		if(r < 0 || c < 0 || dp[r][c] == 0) 
			return;	
		if(r == 0 && c == 0) {
			// distinct permutations is:  (n permute r) / (number of things that repeat)!(number of things that repeat)!...
			numPermutation[0] = ((numPermutation[0] % 1000000007) + (chainPermutation % 1000000007)) % 1000000007;
			
			return;
		}
		
		int elementsSum = 0;
		for(int i = 0; i < trackedCoins.length; i++) {
			elementsSum += trackedCoins[i ];
		} 
		
		int temp = trackedCoins[coinValues[r - 1]];
		for(int i = c; i >= 0; i -= coinValues[r - 1]) {
			solve(r - 1, i, dp, trackedCoins, numPermutation, coinValues, chainPermutation);	
			trackedCoins[coinValues[r - 1]]++;
			elementsSum++;
			chainPermutation = (chainPermutation * elementsSum) % 1000000007;   
//			a/b mod n = [(a mod n)(b−1 mod n)] mod n, 
			chainPermutation = (chainPermutation * modInverse(trackedCoins[coinValues[r - 1]], 1000000007)) % 1000000007;
		}
		trackedCoins[coinValues[r - 1]] = temp;
	}
	
	
	
	 // To compute x^y under modulo m 
    static long power(long x,long y,long m) 
    { 
        if (y == 0) 
            return 1; 
        long p = power(x, y / 2, m) % m; 
        p = (p * p) % m; 
      
        return (y % 2 == 0) ? p : (x * p) % m; 
    } 
      
    // Function to find modular  
    // inverse of a under modulo m 
    // Assumption: m is prime 
    static long modInverse(long a, long m) 
    { 
    	return power(a, m - 2, m); 
    } 

}

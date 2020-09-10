import java.util.*;

public class Hackerrank9 {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int capacity = sc.nextInt();
		
		int[][] jewels = new int[n][2];
		for(int i = 0; i < n; i ++) {
			int value = sc.nextInt();
			int weight = sc.nextInt();
			
			
			jewels[i][0] = value;
			jewels[i][1] = weight;
		}
		
		int[][] dp = new int[n][capacity + 1];
		
		for(int i = 0; i < dp[0].length; i++) {
			if(jewels[0][1] <= i) {
				dp[0][i] = jewels[0][0];
			}
		}
		
		for(int i = 1; i < dp.length; i++) {
			
			for(int j = 0; j < dp[0].length; j++) {
				if(j == 0) {
					continue;
				}
				if(jewels[i][1] <= j) {
					
					if(jewels[i][0] + dp[i - 1][j - jewels[i][1]] > dp[i - 1][j]) {
						dp[i][j] = jewels[i][0] + dp[i - 1][j - jewels[i][1]];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
					
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		System.out.println(dp[n - 1][capacity]); 
	}   
}

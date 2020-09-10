import java.util.*;

public class Codeforces4D {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] envelopes = new int[n + 1][3];
		envelopes[0][1] = sc.nextInt(); // card width 
		envelopes[0][2] = sc.nextInt(); // height 
		
		ArrayList<Integer> validIndex = new ArrayList<>();
		validIndex.add(0);
		for(int i = 0; i < n; i++) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			
			if(width > envelopes[0][1] && height > envelopes[0][2]) {
				
				envelopes[validIndex.size()][0] = i + 1;
				envelopes[validIndex.size()][1] = width;
				envelopes[validIndex.size()][2] = height;
				validIndex.add(i + 1);
			}
		}
		
		int[][] validEnvelopes = new int[validIndex.size()][3];
		for(int i = 0; i < validIndex.size(); i++) {
			validEnvelopes[i][0] = validIndex.get(i);
			validEnvelopes[i][1] = envelopes[i][1];
			validEnvelopes[i][2] = envelopes[i][2];
		}
		
		Arrays.sort(validEnvelopes, (a, b) -> Long.compare((long)a[1] * a[2],(long) b[1] * b[2]));
		
		int[] dp =  new int[validEnvelopes.length]; // maximum chain length which ends in ith envelope
		int[] track = new int[validEnvelopes.length]; // indexes of envelopes in a chain 
		for(int i = 0; i < dp.length; i++) {
			
			for(int j = 0; j < i; j++) {
				if(validEnvelopes[i][1] > validEnvelopes[j][1] && validEnvelopes[i][2] > validEnvelopes[j][2]) {
					
					if(dp[i] <= dp[j] + 1) {
					
						dp[i] = dp[j] + 1;
						track[i] = j;
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		
		for(int i = 0; i < dp.length; i++) {
			if(dp[i] > max) {
				max = dp[i];
				maxIndex = i;
			}
		}
		System.out.println(dp[maxIndex]);
		String output = "";
		
		while(maxIndex > 0) {
			output = validEnvelopes[maxIndex][0] + " " + output; 
			maxIndex = track[maxIndex];
		}
		
		System.out.println(output.trim());	
	}
}

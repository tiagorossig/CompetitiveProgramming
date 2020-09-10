import java.util.*;

public class Codeforces706B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] shops = new int[n];
		for(int i = 0; i < n; i++){
			shops[i] = sc.nextInt();
		}
		Arrays.sort(shops);
		int q = sc.nextInt();
		for(int i = 0; i < q; i++){
			int numCoins = sc.nextInt();
			int result = solve(shops, 0, shops.length, numCoins);
			System.out.println(result);
		}
	}

	private static int solve(int[] shops, int left, int right, int numCoins) {
		if(left + 1 >= right)
			return shops[left] <= numCoins ? right : left;
			
		int mid = left + (right - left)/2;
		if(shops[mid] <= numCoins){
			return solve(shops, mid, right, numCoins);
		}
		else{
			return solve(shops, left, mid, numCoins);
		}
	}
}

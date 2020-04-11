import java.util.Arrays;
import java.util.Scanner;

public class Codeforces870B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solve(arr, k));
		
	}

	private static int solve(int[] arr, int k) {
		if(k == 1)
			return getMin(arr);
		else if(k == 2) {
			return Math.max(arr[0], arr[arr.length - 1]);
		}
		else {
			return getMax(arr); // one segment will be max element by itself 
		}
	}
	
	private static int getMax(int[] arr) {
		int result = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			result = Math.max(arr[i],  result);
		}
		
		return result;
	}
	private static int getMin(int[] arr) {
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			result = Math.min(arr[i],  result);
		}
		
		return result;
	}
	
	
}

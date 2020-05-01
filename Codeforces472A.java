import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Codeforces472A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashSet<Integer> primes = getPrimes(n);
		primes.add(1);
		
		HashSet<Integer> composite = new HashSet<>();
		for(int i = 0; i < n; i++) {
			if(!primes.contains(i)) {
				composite.add(i);
			}
		}
		
		int result1 = 0;
		int result2 = 0;
		
		for(int i : composite) {
			int complement = n - i;
			if(composite.contains(complement)) {
				result1 = i;
				result2 = complement;
				break;
			}
		}
		
		System.out.println(result1 + " " + result2);
	}
	
	static HashSet<Integer> getPrimes(int n) {
		boolean[] composite = new boolean[n + 1];
		HashSet<Integer> primes = new HashSet<>();
		for (int i = 2; i <= n; ++i) {
			if (composite[i]) continue;
			primes.add(i);
			for (int j = 2 * i; j <= n; j += i)
				composite[j] = true;
		}
		return primes;
	}
}

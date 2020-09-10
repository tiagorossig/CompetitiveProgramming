import java.util.*;
 
public class Codeforces1348A {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
 
		for(int i = 0; i < t; i++) {
			int n =  sc.nextInt();
			int a = 0;
			int b = 0;
			
			a += Math.pow(2, n);
			n--;
			int j = n;
			
			while(j > n / 2) {
				b += Math.pow(2, j);
				j--;
			}
		
			while(j > 0) {
				a += Math.pow(2, j);
				j--;
			}
			
			System.out.println(Math.abs(b - a));
		}
    }
}
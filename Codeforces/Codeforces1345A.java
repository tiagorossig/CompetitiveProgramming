import java.util.Scanner;
 
public class Codeforces639 {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n == 1 || m == 1)
				System.out.println("YES");
			else if(n == 2 && m == 2)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}	
    }
}
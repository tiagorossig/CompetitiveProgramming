import java.util.*;
 
public class Codeforces640 {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
 
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			TreeSet<Integer> result = new TreeSet<>();
			int mult = 1;
			
			String str = Integer.toString(num);
			int numLength = str.length();
			
			for(int j = 0; j < numLength; j++) {			
				int firstDigit = Character.getNumericValue(str.charAt(numLength - 1 - j)) * mult;
				
				result.add(firstDigit);
				mult *= 10;
			}
			result.remove(0);
			System.out.println(result.size());
			
			
			for(int j : result) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
    }
}
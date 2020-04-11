import java.util.Arrays;
import java.util.Scanner;

public class Codeforces189A {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
   	
    	int[] pieces = new int[n + 1];
    	Arrays.fill(pieces, Integer.MIN_VALUE);
    	pieces[0] = 0;
    	
    	for(int i = 1; i < pieces.length; i++) {
    		if(i >= a) {
    			pieces[i] = Math.max(pieces[i], pieces[i - a] + 1);
    		}
    	    if(i >= b) {
    			pieces[i] = Math.max(pieces[i], pieces[i - b] + 1);
    		}
    		if(i >= c) {
    			pieces[i] = Math.max(pieces[i], pieces[i - c] + 1);
    		}
    	}
    	
    	System.out.println(pieces[pieces.length - 1]);
    }
}

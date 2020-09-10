import java.io.*;
import java.util.*;

public class Hackerrank8 {
	
	static final long MODULO = 1000000007;

    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt() % MODULO;
    long k = sc.nextInt();
    long d = sc.nextInt();
     
    long result = pow(k, d);
    result = ((n % MODULO) * (result % MODULO)) % MODULO;
     
    System.out.println(result);
    }
    
    // Calculates a^p
    static long pow(long a, long p) {
    	if(p == 0) {
    		// Base Case, anything to the power of 0 is 1
    		return 1;
    	}
    	if(p % 2 == 1) { // odd exponent
    		long temp = ((a % MODULO) * (a % MODULO)) % MODULO;
    		return (((a % MODULO) * (pow(temp, p / 2) % MODULO)) % MODULO);
    	} else { // even exponent
    		long temp = ((a % MODULO) * (a % MODULO)) % MODULO;
    		return pow(temp, p / 2);
    	}
    }
}
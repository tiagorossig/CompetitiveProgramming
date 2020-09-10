import java.io.*;
import java.util.*;

public class Hackerrank6 {

     public static void main(String[] args) throws IOException {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     ArrayList<Integer> ruth = new ArrayList<>();
     ArrayList<Integer> bleminda = new ArrayList<>();
     
     for(int i = 0; i < n; i++) {
         ruth.add(sc.nextInt());
     }
     for(int i = 0; i < n; i++) {
    	 bleminda.add(sc.nextInt());
     }
     
     System.out.println(solve(ruth, bleminda));
 }
     
     private static int solve(ArrayList<Integer> ruth, ArrayList<Integer> bleminda){   
    	 
    	 // Ruth's rocks need to beat Bleminda's rocks by the smallest margin possible.
    	 // when there are no Ruth rocks that can beat Melinda rocks left, we then count these rocks
    	 
    	 while(getMax(ruth) > getMin(bleminda) && ruth.size() > 0) {
    		 int maxRuth = getMax(ruth); 
    		 int biggestSmallerThanN = getBiggestSmallerThanN(bleminda, maxRuth);
    		 bleminda.remove(bleminda.indexOf(biggestSmallerThanN));
    		 ruth.remove(ruth.indexOf(maxRuth));
    		 
    	 }
    	 int result = 0;
    	 for(Integer num : ruth) { // count Ruth's losing rocks 
    		 result += num;
    	 }
    	 return result;
     }
     
     private static int getBiggestSmallerThanN(ArrayList<Integer> arr, int n) {
    	 int result = Integer.MIN_VALUE;
    	 
    	 for(int i = 0; i < arr.size(); i++) {
    		if(arr.get(i) < n) {
    			result = Math.max(arr.get(i),  result);
    		}
  		}
    	 return result;
     }
 
     private static int getMax(ArrayList<Integer> arr) {
 		int result = Integer.MIN_VALUE;
 		
 		for(int i = 0; i < arr.size(); i++) {
 			result = Math.max(arr.get(i),  result);
 		}
 		
 		return result;
 	}
 	private static int getMin(ArrayList<Integer> arr) {
 		int result = Integer.MAX_VALUE;
 		
 		for(int i = 0; i < arr.size(); i++) {
 			result = Math.min(arr.get(i),  result);
 		}
 		return result;
 	}
     
}
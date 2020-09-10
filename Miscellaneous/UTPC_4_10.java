import java.io.*;
import java.util.*;

public class UTPC_4_10 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			int result = solve(sc.nextInt());
			
			if(result == -1) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}
			
		}
		
	}
	
	static int solve(int x) {
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < x; i++) {
			if(x % i == 0) {
				if(!isPrime(i) && !divisibleBySquare(i)) {
					q.add(i);
					
				}
			}
		}
		
		int result = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int cur = q.remove();
				
			}
			
		}
		
		return -1;
	}
	
	static boolean isPrime(int x) {
		for(int i  = 2; i * i <= x; ++i) {
			if(x % i == 0)
				return false;	
		}
		return true;
	}
	
	static boolean divisibleBySquare(int x) {
		for(int i = 0; i * i <= x; ++i){
			if(x % (i * i) == 0) 
				return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//	     int n = sc.nextInt();
//	     
//	     String trump = sc.next();
//	     
//		
//	     String[][] rounds = new String[n][2];
//	    		 
//	     for(int i = 0; i < n; i++) {
//	    	 for(int j = 0; j < 2; j ++) {
//	    		 rounds[i][j] = sc.next();
//	    	 }
//	     }
//	     
//	     
//	     int winsA = 0;
//	     int winsB = 0;
//	     
//	     ArrayList<Character> ranks = new ArrayList<Character>(Arrays.asList('2','3','4','5','6','7','8','9','T','J','Q','K','A'));
//	     
//	     
//	     for(int i = 0; i < n; i++) {
//	    	 String cardA = rounds[i][0];
//	    	 String cardB = rounds[i][1];
//	    	 
//	    	 if(cardA.charAt(1) == trump.charAt(0) && cardB.charAt(1) != trump.charAt(0)) {
//	    		 System.out.println("if 1");
//	    		 winsA++;
//	    		 continue;
//	    	 }
//	    	 if(cardB.charAt(1) == trump.charAt(0) && cardA.charAt(1) != trump.charAt(0)) {
//	    		 System.out.println("if 2");
//	    		 winsB++;
//	    		 continue;
//	    	 }
//	    	 if(cardA.charAt(1) == cardB.charAt(1)) {
//	    		 System.out.println("if 3");
//	    		 if(ranks.indexOf(cardA.charAt(0)) >= ranks.indexOf(cardB.charAt(0))) {
//	    			 winsA++;
//	    		 } else {
//	    			 winsB++;
//	    		 }
//	    		 continue;
//	    	 } 
//	    	 else {
//	    		 System.out.println("if 4");
//	    		 winsB++;
//		    	 continue;
//	    	 }
//	     }
//	     
//
//	     
//	     if(winsA > winsB) {
//	    	 System.out.println("ADITYA " + winsA);
//	     } else if (winsB > winsA) {
//	    	 System.out.println("BRIAN " + winsB);
//	     } else {
//	    	 System.out.println("TIE " + winsB);
//	     }
//	     
//	}
//}












































	

//     public static void main(String[] args) {
//	     Scanner sc = new Scanner(System.in);
//	     int n = sc.nextInt();
//	     int a = sc.nextInt();
//	     int b = sc.nextInt(); 
//	     int c = sc.nextInt();
//
//	     HashMap<String, int[]> stores = new HashMap<>();
//	     
//	     
//	     for(int i = 0; i < n; i++) {
//	    	 String store = sc.next();
//	    	 stores.put(store, new int[4]);
//	    	 for(int j = 0; j < 3; j++) {
//	    		 stores.get(store)[j] = sc.nextInt();
//	    	 }
//	     }
//	     
//	     int min = Integer.MAX_VALUE;
//	     String minStore = "";
//	     
//	     for(String store : stores.keySet()) {
//	    	 stores.get(store)[3] += a * stores.get(store)[0];
//	    	 stores.get(store)[3] += b * stores.get(store)[1];
//	    	 stores.get(store)[3] += c * stores.get(store)[2];
//	    	 if(stores.get(store)[3] < min) {
//	    		 min = stores.get(store)[3];
//	    		 minStore = store;
//	    	 } else if (stores.get(store)[3] == min && store.compareTo(minStore) < 0) {
//	    		 min = stores.get(store)[3];
//	    		 minStore = store;
//	    	 }
//	     }
//	     
//	     System.out.println(minStore + " " + min);
//     }
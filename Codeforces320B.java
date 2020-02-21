import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Codeforces320B {
	 public static class Pair {
		private int a;
		private int b;
        public Pair(int a, int b) {
        	this.a = a;
        	this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
    	ArrayList<Pair> intervals = new ArrayList<>();
    	ArrayList<Integer> reach = new ArrayList<>();
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	for(int i = 0; i < n; i ++) {
    		int queryType = sc.nextInt();
    		if(queryType == 1) {
    			reach.add(0);
    			int a = sc.nextInt();
    			int b = sc.nextInt();
    			intervals.add(new Pair(a, b));
    		} else {
    			dfs(sc.nextInt() - 1, intervals, reach);
    			String output = reach.get(sc.nextInt() - 1) == 1 ? "YES" : "NO";
    			for(int j = 0; j < reach.size(); j++){
    				reach.set(j, 0);
    			}
    			System.out.println(output);
    		}
    	}
    }
    
    private static void dfs(int index, ArrayList<Pair> intervals, ArrayList<Integer> reach) {
    	reach.set(index, 1);
    	for(int i = 0; i < intervals.size(); i++) {       
    		if(reach.get(i) == 0){
    			Pair thisInterval = intervals.get(index);
    			Pair otherInterval = intervals.get(i);
    			boolean condition1 = (thisInterval.a > otherInterval.a) && (otherInterval.b > thisInterval.a);
    			boolean condition2 = (thisInterval.b > otherInterval.a) && (otherInterval.b > thisInterval.b); 
    			if(condition1 || condition2) {
    				dfs(i, intervals, reach);
    			}
    		}
    	}
    }
}
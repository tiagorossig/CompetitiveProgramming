import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Hackerrank4 {
	 public static class Node implements Comparable<Node> {
	        int id;
	        List<Edge> neighbors;
	        int cost;
	        boolean visited;

	        public Node(int id) {
	            this.id = id;
	            neighbors = new ArrayList<>();
	            cost = Integer.MIN_VALUE;
	            visited = false;
	        }

	        public int compareTo(Node other) {
	            return Integer.compare(this.cost, other.cost);
	        }
	    }

	    public static class Edge {
	        Node dest;
	        Node src;
	        int weight;

	        public Edge(Node src, Node dest, int weight) {
	        	this.src = src;
	            this.dest = dest;
	            this.weight = weight;
	        }
	    }

	 public static void main(String[] args) throws IOException {
	     Scanner sc = new Scanner(System.in);
	     List<Edge> graph = new ArrayList<>();
	     List<Node> nodes = new ArrayList<>();
	     int v = sc.nextInt();
	     int e = sc.nextInt();
	     int startHealth = sc.nextInt();
	     
	     // use input to make list of nodes
	     for(int i = 0; i < v; i++) {
	    	 nodes.add(new Node(i + 1));
	     }
	     // add starting health to first node 
	     nodes.get(0).cost = startHealth;

	     // use input to make graph 
	     for(int i = 0; i < e; i++) {
	        	Node node1 = nodes.get(sc.nextInt() - 1);
	        	Node node2 = nodes.get(sc.nextInt() - 1);
	        	int cost = sc.nextInt();
	        	graph.add(new Edge(node1, node2, cost));
	     }
	     
	     
	     // Bellman-Ford algorithm
	     for(int i = 0; i < v - 1; i++) {
	    	 for(int j = 0; j < e; j++) {
	    		 Node source = graph.get(j).src;
	    		 Node destination = graph.get(j).dest;
	    		 int weight = graph.get(j).weight;
	    		 
	    		 if(destination.cost < source.cost + weight) {
	    			 destination.cost = source.cost + weight;
	    		 }
	    	 }
	     }
	     // check for infinite cycle
	     boolean infinite = false;
	     for(int i = 0; i < e; i++) {
	    	 Node source = graph.get(i).src;
    		 Node destination = graph.get(i).dest;
    		 int weight = graph.get(i).weight;
    		 if(source.cost != Integer.MIN_VALUE && source.cost + weight > destination.cost) {
    			 infinite = true;
    		 }
	     }
	     if(nodes.get(nodes.size() - 1).cost == Integer.MAX_VALUE){
	    	 infinite = true;
	     }
	     
	     // output result
	     if(infinite) {
	    	 System.out.println("infinity");
	     } else {
	    	 int lastRoomHealth = nodes.get(nodes.size() - 1).cost;
	    	 int output = lastRoomHealth == Integer.MIN_VALUE ? -1 : lastRoomHealth;
	    	 System.out.println(output);
	     }
	 }

}

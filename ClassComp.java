import java.io.*;
import java.util.*;


/**
 * The problem can be found here: http://www.spoj.com/problems/EZDIJKST/
 *
 * I'm getting WA (Wrong Answer) on the online judge. Can you figure out why?
 */
public class ClassComp {
	public static class Node implements Comparable<Node> {
        int id;
        List<Edge> neighbors;
        int cost;
        boolean visited;

        public Node(int id) {
            this.id = id;
            neighbors = new ArrayList<>();
            cost = Integer.MAX_VALUE;
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
        int v = sc.nextInt();
        int e = sc.nextInt();
        int repairStations = sc.nextInt();
        int air = sc.nextInt();
        ArrayList<Edge> graph = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Integer> repairOrNot = new ArrayList<>();
        
        for(int i = 0; i < v; i++) {
        	nodes.add(new Node(i + 1));
        	repairOrNot.add(0);
        }
        
        for(int i = 0; i < repairStations; i++) {
        	repairOrNot.set(i, 1);
        }
        
        for(int i = 0; i < e; i++) {
        	Node node1 = nodes.get(sc.nextInt() - 1);
        	Node node2 = nodes.get(sc.nextInt() - 1);
        	int weight = sc.nextInt();
        	graph.add(new Edge(node1, node2, weight));
        }
        graph.get(0).src.cost = air;
        
        
     // Bellman-Ford algorithm
	     for(int i = 0; i < v - 1; i++) {
	    	 for(int j = 0; j < e; j++) {
	    		 Node source = graph.get(j).src;
	    		 
	    		 Node destination = graph.get(j).dest;
	    		 int weight = graph.get(j).weight;
	    		 
	    		 System.out.println("dest cost is " + destination.cost);
	    		 System.out.println("source cost is " + source.cost + "\n");
	    		 
	    		 
	    		 if(destination.cost > source.cost + weight) {
	    			 destination.cost = source.cost + weight;
	    		 }
	    	 }
	     }
	     
	     int distance = nodes.get(nodes.size() - 1).cost;
    	 System.out.println(distance);
	     
    }
}
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Codeforces20C {
	 public static class Node implements Comparable<Node> {
	        int id;
	        List<Edge> neighbors;
	        int cost;
	        boolean visited;
	        int prev;
	        int next;

	        public Node(int id) {
	        	next = 0;
	        	prev = 0;
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
	        int weight;

	        public Edge(Node dest, int weight) {
	            this.dest = dest;
	            this.weight = weight;
	        }
	    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner("5 6 1 2 2 2 5 5 2 3 4 1 4 1 4 3 3 3 5 1");
        final int numVert = sc.nextInt();
        final int numEdges = sc.nextInt();
        List<Node> graph = new ArrayList<>();
        graph.add(new Node(0));
        
        for (int i = 1; i <= numVert; i++) {
            graph.add(new Node(i));
        }
        
        for(int i = 1; i <= numEdges; i++) {
        	int temp1 = sc.nextInt();
        	int temp2 = sc.nextInt();
        	Node node1 = graph.get(temp1);
        	Node node2 = graph.get(temp2);
        	int cost = sc.nextInt();
        	node1.neighbors.add(new Edge(node2, cost));
        	node2.neighbors.add(new Edge(node1, cost));
        }
        
        
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node start = graph.get(1);
        start.cost = 0;
        start.visited = true;
        pq.add(start);

        while (!pq.isEmpty()) {
//        	System.out.println("this runs");
            Node current = pq.remove();
//            System.out.println("current neighbors is " + current.neighbors.size());

            for (Edge edge : current.neighbors) {
                Node nextNode = edge.dest;
                int newCost = current.cost + edge.weight;

                if (!nextNode.visited || newCost < nextNode.cost) {
            
                	nextNode.prev = current.id;
                	current.next = nextNode.id;
                    nextNode.cost = newCost;
                    nextNode.visited = true;
                    pq.add(nextNode);
                }
            }
        }
        
//        for(int i = 1; i < graph.size(); i++) {
//        	System.out.println("node ID: " + graph.get(i).id + " node cost: " + graph.get(i).cost);
//        }
//        
        
        Node finalVert = graph.get(numVert);
        int finalCost = finalVert.cost;
        finalVert.next = 0;
        
        if(finalCost == Integer.MAX_VALUE) {
        	System.out.println(-1);
        	return;
        } 
//    	boolean done = false;
//    	Node curNode = finalVert;
//    	int sizePath = 1;
//    	while(!done) {
//    		if(curNode.prev == 0) {
//    			done = true;
//    		} else {
//    			sizePath++;
//    			curNode = graph.get(curNode.prev);
//    		}
//    	}
    	boolean done = false;
    	Node curNode = start;
    	String separator = " "; 
//    	System.out.println("Final id " + finalVert.id);
//    	System.out.println("Final next " + finalVert.next);
    	while(!done) {
//    		System.out.println(curNode.id);
    		if(curNode.next == 0) {
    			done = true;
    			separator = "\n";
    		} 
    		
//    		System.out.println("Moving to: " + curNode.next);
    		System.out.print(curNode.id + separator);
    		curNode = graph.get(curNode.next);
    	}
    }
}
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numNodes = sc.nextInt();
        int numEdges = sc.nextInt();
        int start = sc.nextInt();
        int distance = sc.nextInt();
        
        HashMap <Integer, HashSet<Integer>> map = new HashMap<>(); // vertices mapped to adjacency lists
        
        for(int i = 1; i <= numNodes; i++){
            map.put(i, new HashSet<>()); // fill map with empty hash sets 
        }

        for(int i = 0; i < numEdges; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            map.get(num1).add(num2); // fill adjacency lists 
            map.get(num2).add(num1);
        }

        System.out.print(numComponents(map, numNodes, numEdges) + " ");
        System.out.println(numReacheable(map, numNodes, numEdges, start, distance));
    }
    
    private static int numComponents(HashMap<Integer, HashSet<Integer>> map, int numNodes, int numEdges){

        HashSet<Integer> seen = new HashSet<>(); // vertices that I've visited 
        int count = 0; // number of components 
        
        for(int i = 1; i <= numNodes; i++){ // loop through every node 
            if(!seen.contains(i)){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int cur = q.remove();
                    seen.add(cur);
                    for(int vertex : map.get(cur)){ // search through graph 

                        if(!seen.contains(vertex)){ // havent seen, move here next 
                            q.add(vertex);
                        }
                    }  
                }
                count++;     
            } // move to next component 
        }
        return count;
    }
    
    private static int numReacheable(HashMap<Integer, HashSet<Integer>> map, int numNodes, int numEdges, int start, int distance) {
        
        HashSet<Integer> seen = new HashSet<>();
        int[] distances = new int[numNodes + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int cur = q.remove(); // start at start vertex
            seen.add(cur);
            for(int vertex : map.get(cur)){
                if(!seen.contains(vertex) && distances[cur] < distance){ // only move to next vertex if it is within the distance limit and it hasnt been seen 
                    distances[vertex] = distances[cur] + 1;
                    q.add(vertex);
                }
            }
        }   
        return seen.size();
    }
        
}
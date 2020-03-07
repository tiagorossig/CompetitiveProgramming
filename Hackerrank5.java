import java.io.*;
import java.util.*;

public class Hackerrank5 {

     public static void main(String[] args) throws IOException {
     Scanner sc = new Scanner(System.in);
     int testCases = sc.nextInt();
     
     for(int i = 0; i < testCases; i++) {
         long maxTime = sc.nextLong();
         int numIntervals = sc.nextInt();
         int timePerRoom = sc.nextInt();
         
         System.out.println("" + solve(maxTime, numIntervals, timePerRoom));
     }
 }
     
     
     private static long solve(long maxTime, int numIntervals, int timePerRoom){   
         if(maxTime == 0 && timePerRoom == 0)
             return 1;
         
         long left = 0;
         long right = (long) Math.sqrt(maxTime) *20;
         
         
         while (left + 1 < right) {
             long mid = left + (right - left)/2;
             double countTime = countTime(mid, numIntervals, timePerRoom);
      
            	 
             if (maxTime > countTime) {
                 left = mid;
             } else if (maxTime == countTime){
                 return mid;
             } else {
                 right = mid;
             }
         }

         return left;
     }
     
     private static double countTime(long people, int numIntervals, int timePerRoom) {
         double time = 0;
         time += (double)people * (people - 1) / 2;
         
         time += (people / numIntervals) * timePerRoom;
         
         
         if(time == 0)
        	 return 1;
         else 
        	 return time;
     }
}


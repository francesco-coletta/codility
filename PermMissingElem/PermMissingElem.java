// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int sumTarget = 0; 
        for(int i = 1; i <= (A.length + 1); i++){
            sumTarget = sumTarget + i;
        }        
        int sumArray = 0;
        for(int i = 0; i < A.length; i++){
            sumArray = sumArray + A[i];
        }
        int missing = sumTarget - sumArray;
        System.out.println("sumTarget = " + sumTarget + ", sumArray = " + sumArray + " -> missing = " + missing);
        
        return missing;
        
    }
}

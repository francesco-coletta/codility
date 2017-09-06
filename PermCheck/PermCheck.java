// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int isPerm = 0;
        int numItems = A.length;
        System.out.println("numItems = " + numItems);
        System.out.println("A = " + debug(A));
        
        int[] counter = new int[numItems];
        
        for(int i = 0; i < numItems; i++){
            if(A[i] < 1 || A[i] > numItems)
                break;
            counter[A[i] - 1] = counter[A[i] - 1] + 1;
        }
        
        System.out.println("counter = " + debug(counter));
        
        int numCount_1 = 0;
        for(int i = 0; i < numItems; i++){
            if(counter[i] == 1)
                numCount_1++;
        }
        
        if (numCount_1 == numItems)
            isPerm = 1;    
        
        return isPerm;
    }
    
    private String debug(int[] arr){
        String debug = "[";
        for(int i = 0; i < arr.length; i++){
            debug = debug + arr[i];
            if ( i < arr.length - 1) {
                debug = debug + ", ";
            }
        }
        debug = debug + "]";
        return debug;
    }  
}

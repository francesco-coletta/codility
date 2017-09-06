// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        int earliestTime = -1;
        int numItems = A.length;
        System.out.println(" X = " + X);
        System.out.println("numItems = " + numItems);
        System.out.println("A = " + debug(A));
        
        if (X > numItems)
            return earliestTime;
        
        int[] counterLeaf = new int[X];
        int remainPositionToCross = X;
        for(int i = 0; i < numItems; i++){
            System.out.println("A["+ i + "] = " + A[i]);
            if(A[i] > X)
                continue;
            counterLeaf[A[i] - 1] = counterLeaf[A[i] - 1] +1;
            if(counterLeaf[A[i] - 1] == 1){
                remainPositionToCross--;
            }
            if (remainPositionToCross == 0){
                earliestTime = i;
                break;
            }
        }
        
        System.out.println("counterLeaf = " + debug(counterLeaf));
        
        return earliestTime;
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

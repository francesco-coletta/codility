// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;
class Solution {
    public int solution(int[] A) {
        
        int smallestInt = 1;
        
        int numItems = A.length;
        if (numItems == 0){
            return smallestInt;
        }
        
        //System.out.println("numItems = " + numItems);
        //System.out.println("A = " + debug(A));
        
        Arrays.sort(A);
        numItems = A.length;
        //System.out.println("numItems sorted A = " + numItems);
        //System.out.println("sorted A = " + debug(A));
        
        int numUniqueValue = 0;
        int[] uniquePositiveA = new int[numItems];
        for(int i = 0; i < numItems; i++){
            if(A[i] > 0){
                if (numUniqueValue > 0){
                    if (A[i] != uniquePositiveA[numUniqueValue-1] ){
                        uniquePositiveA[numUniqueValue] = A[i];
                        numUniqueValue++;
                    }                    
                }
                else{
                    uniquePositiveA[numUniqueValue] = A[i];
                    numUniqueValue++;
                }
            }
            
            if (A[i] > 0 && A[i] != uniquePositiveA[numUniqueValue-1] ){
                uniquePositiveA[numUniqueValue] = A[i];
                numUniqueValue++;
            }
        }
        //System.out.println("numItems unique A = " + numUniqueValue);
        //System.out.println("unique A = " + debug(uniquePositiveA));
        
        if (uniquePositiveA[0] <= 0 || uniquePositiveA[0] > 1){
            return smallestInt;
        }

        for(int i = 0; i < numUniqueValue; i++){
            //System.out.println("uniquePositiveA["+ i + "] = " + uniquePositiveA[i]);
            
            if (uniquePositiveA[i] > smallestInt){
                break;
            }
            smallestInt++;
        }
        
        return smallestInt;
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

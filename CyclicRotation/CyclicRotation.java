// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        
        printArray(A);   
        int[] rot = A; 
        for(int i = 0; i < K; i++){
            rot = rotation(rot);
            printArray(rot);
        }
        
                
        
        
        return rot;   
    }
    
    private int[] rotation(int[] a){
        int numItems = a.length;
        
        int[] rotated = new int[numItems];
        for(int i = 0; (i < numItems - 1); i++){
            rotated[i + 1] = a[i]; 
        }
        rotated[0]  = a[numItems - 1];
        
        return rotated;
    }
    
    private void printArray(int[] a){
        String out = "[";
        for(int i = 0; i < a.length; i++){
            out = out  + a[i] + ", ";
        }
        out = out.substring(0, out.length() - 2);
        out = out + "]";
        System.out.println(out);
    }
}

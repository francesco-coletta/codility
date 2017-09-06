// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int minDelta =0;
        int numItems = A.length;
        System.out.println("numItems = " + numItems);
        
        if (numItems < 2){
            return numItems;
        }

        int totalSum = 0;        
        for(int i = 0; i < numItems; i++){
            totalSum = totalSum + A[i];
        }
        System.out.println("totalSum = " + totalSum);
        
        minDelta = Math.abs(totalSum);
        
        int leftSum = 0;
        int rightSum = 0;

        int currentDelta = 0;
        for(int i = 0; i < numItems; i++){
            leftSum = leftSum + A[i];
            rightSum = totalSum - leftSum;

            currentDelta = Math.abs(leftSum - rightSum);
            System.out.println("i = " + i +  ", leftSum = " + leftSum + ", rightSum = " + rightSum + " -> currentDelta " + currentDelta);
            
            if (currentDelta < minDelta){
                minDelta = currentDelta;
                System.out.println("New min delta = " + minDelta);
            }
        }
        
        return minDelta;
    }
}

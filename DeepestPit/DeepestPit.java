class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int maxDeep = -1;
        
        int numItems = A.length;
        //System.out.println("numItems = " + numItems);
        //System.out.println("A = " + debug(A));
        
        if (numItems < 3)
            return maxDeep;
            
        int[] pendenza = new int[numItems - 1];
        int j = 0;
        for(int i = 0; i < numItems - 1; i++){
            j = i + 1;
            
            if(A[j] > A[i]){
                pendenza[i] = 1;
            }
            else if(A[j] == A[i] ){
                pendenza[i] = 0;
            }
            else{
                pendenza[i] = -1;
            }
            //System.out.println("A["+ i + "] = " + A[i] + " A["+ j + "] = " + A[j] + ": pendenza " + pendenza[i]);   
        }
        //System.out.println("pendenza = " + debug(pendenza));
        
        
        int p = -1;
        int q = -1;
        int r = -1;
        for(int i = 0; i < numItems - 1; i++){
 
            //System.out.println("pendenza["+ i + "] = " + pendenza[i]);  
            
            if (p < 0){
                if(pendenza[i] == -1){
                    p = i;
                    //System.out.println("\tstart deep. p = " + i);
                }
            }
            else{
                if(pendenza[i] == 0){
                    p = i;
                    //System.out.println("\trestart deep. p = " + p);
                }
                else if(pendenza[i] == +1){
                    //System.out.println("\tinversion. deep.");
                    if (q < 0){
                        q = i;
                        r = i+1;
                        //System.out.println("\tinversion. deep. q = " + q + ", r = " + r);
                    }
                    else{
                        r = i+1;
                        //System.out.println("\tend deep. r = " + r);
                    }
                }
                else{
                    if (p >= 0 && p < q && q < r && r < numItems){
                        //System.out.println("\tDeep: p = " + p + ", q = " + q + ", r = " + r);
                        //System.out.println("\tA[p] = " + A[p] + ", A[q] = " + A[q] + ", A[r] = " + A[r]);

                        int leftDepth = A[p] - A[q];
                        int rightDepth = A[r] - A[q];
                        
                        int deep = leftDepth;
                        if (deep > rightDepth) 
                            deep = rightDepth;
                            
                        if (deep > maxDeep)
                            maxDeep = deep;
                            
                        //System.out.println("\tdeep = " + deep + ", maxDeep = " + maxDeep);
                        p = i;
                        q = -1;
                        r = -1;
                        //System.out.println("\tStart new Deep: p = " + p + ", q = " + q + ", r = " + r);
                    }
                    
                }
            }
        }
        
        if (p >= 0 && p < q && q < r && r < numItems){
            //System.out.println("\tDeep: p = " + p + ", q = " + q + ", r = " + r);
            //System.out.println("\tA[p] = " + A[p] + ", A[q] = " + A[q] + ", A[r] = " + A[r]);

            int leftDepth = A[p] - A[q];
            int rightDepth = A[r] - A[q];
            
            int deep = leftDepth;
            if (deep > rightDepth) 
                deep = rightDepth;
                
            if (deep > maxDeep)
                maxDeep = deep;
                
            //System.out.println("\tdeep = " + deep + ", maxDeep = " + maxDeep);
        }        
        
        return maxDeep;
        
    }
    
    private String debug(int[] arr){
        String debug = "[";
        for(int i = 0; i < arr.length; i++){
            debug = debug + arr[i] + ", ";
        }
        debug = debug + "]";
        
        return debug;
        
    }  
}

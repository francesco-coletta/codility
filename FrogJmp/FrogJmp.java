ass Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int jump = ((Y - X) / D);
        
        if (((Y - X) % D) > 0){
            jump++;
        }
        
        return jump;
    }
}

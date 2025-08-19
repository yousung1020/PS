class Solution {
    public int solution(int slice, int n){
        int count = 0;
        while(n > 0){
            n -= slice;
            count++;
        }
        return count;
    }
}
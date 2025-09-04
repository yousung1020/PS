import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Integer[] matsI = new Integer[mats.length];
        boolean checkPlace = false;
        
        for(int i = 0; i < mats.length; i++){
            matsI[i] = mats[i];
        }
        
        Arrays.sort(matsI, (i1, i2) -> {
            return i2 - i1;
        });
        
        for(int m: matsI){
            for(int r = 0; r <= park.length - m; r++){
                for(int c = 0; c <= park[r].length - m; c++){
                    checkPlace = check_jari(m, r, c, park);
                    
                    if(checkPlace){
                        return m;
                    }
                }
            }
        }
        
        return -1;
    }
    
    public boolean check_jari(int m, int r, int c, String[][] park){
        for(int i = r; i < r + m; i++){
            for(int j = c; j < c + m; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        
        return true;
    }
}
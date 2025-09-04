import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
//         int answer = 0;
//         int n = park.length;
//         int m = park[0].length;
//         boolean dos = true;
        
//         Arrays.sort(mats);
        
//         for(int k = mats.length - 1; k >= 0; k--){
//             for(int i = 0; i <= n - mats[k]; i++){
//                 for(int j = 0; j <= m - mats[k]; j++){
//                     dos = true;
//                     for(int ii = i; ii < i + mats[k]; ii++){
//                         for(int jj = j; jj < j + mats[k]; jj++){
//                             if(!park[ii][jj].equals("-1")){
//                                 dos = false;
//                                 break;
//                             }
//                         }
//                         if(!dos){
//                             break;
//                         }
//                     }
//                     if(dos){
//                         return mats[k];
//                     }
//                 }
//             }
//         }
        
        Integer[] gang = new Integer[mats.length];
        boolean checkPlace = true;
        
        for(int i = 0; i < mats.length; i++){
            gang[i] = mats[i];
        }
        
        Arrays.sort(gang, (i1, i2) -> {
            return i2 - i1;
        });
        
        for(int i: gang){
            for(int r = 0; r <= park.length - i; r++){
                for(int c = 0; c <= park[r].length - i; c++){
                    checkPlace = check_jari(i, r, c, park);  
                    if(checkPlace){
                        return i;
                    }
                }
            }
        }   
        
        return -1;
    }
    
    public boolean check_jari(int mat, int r, int c, String[][] park){
        for(int i = r; i < r + mat; i++){
            for(int j = c; j < c + mat; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}
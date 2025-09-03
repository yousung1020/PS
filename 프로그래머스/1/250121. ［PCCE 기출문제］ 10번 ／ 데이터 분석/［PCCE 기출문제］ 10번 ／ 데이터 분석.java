import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // int[][] answer = new int[][];
        final int idx;
        // ext 값이 val_ext보다 작은 데이터만 뽑기
        if(ext.equals("code")){
            idx = 0;
        }
        else if(ext.equals("date")){
            idx = 1;
        }
        else if(ext.equals("maximum")){
            idx = 2;
        }
        else{
            idx = 3;
        }
        
        // 정렬 기준 인덱스 뽑기
        final int idx2;
        
        if(sort_by.equals("code")){
            idx2 = 0;
        }
        else if(sort_by.equals("date")){
            idx2 = 1;
        }
        else if(sort_by.equals("maximum")){
            idx2 = 2;
        }
        else{
            idx2 = 3;
        }
        
        // data 순회하면서 각 조건에 맞는 데이터 뽑아내기
        int size = 0;
        int[][] temp = new int[data.length][4];
        
        for(int i = 0; i < data.length; i++){
            // val_ext 기준 작은 것만
            if(data[i][idx] < val_ext){
                temp[i] = data[i];
                size++;
            }
        }
        
        int[][] answer = new int[size][4];
        int idx3 = 0;
        for(int i = 0; i < temp.length; i++){
            if(temp[i][0] > 0){
                answer[idx3] = temp[i];
                System.out.println(answer[idx3][idx2]);
                idx3++;
            }
        }
    
        Arrays.sort(answer, (i1, i2) -> {
            return i1[idx2] - i2[idx2];
        });
        
        return answer;
    }
}
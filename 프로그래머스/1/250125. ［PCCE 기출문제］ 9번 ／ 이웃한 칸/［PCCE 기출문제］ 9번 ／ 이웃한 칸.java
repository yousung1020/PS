class Solution {
    public int solution(String[][] board, int h, int w) {
        // [][][][][][][]
        // [][][][][][][]
        // [][][][][][][]
        // 순서대로 위 아래 왼 오
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        int count = 0;
        // 위 아래 왼 오 방향에 대해서 순회하며 색깔을 검사해야 함 즉, 4번 (0 ~ 3) 순회
        for(int i = 0; i < 4; i++){
            int check_h = h + dh[i];
            int check_w = w + dw[i];
            
            // board의 인덱스 범위에서 벗어나는지 췍.
            if((check_h < board.length && check_h >= 0) && (check_w < board[check_h].length && check_w >= 0)){
                if(board[h][w].equals(board[check_h][check_w])){
                    count++;
                }
            }
        }
        
        return count;
    }
}
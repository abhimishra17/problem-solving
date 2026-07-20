class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, m, n, board[i][j], i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int m, int n, char ele, int i, int j) {
        
        for (int r = 0; r < m; r++) {
            if (r != i && board[r][j] == ele) {
                return false;
            }
        }

       
        for (int c = 0; c < n; c++) {
            if (c != j && board[i][c] == ele) {
                return false;
            }
        }

        
        int ri = 3 * (i / 3);
        int ci = 3 * (j / 3);
        
        for (int x = ri; x < ri + 3; x++) {
            for (int y = ci; y < ci + 3; y++) {
                if (x != i && y != j && board[x][y] == ele) {
                    return false;
                }
            }
        }

        return true;
    }
}


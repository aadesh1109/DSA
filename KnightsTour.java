public class KnightsTour {
    public static void main(String[] args) {
        solveKT();
    }
    private static void solveKT(){
        int[][] board = new int[8][8];
        int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};
        solveKT(0,0,board,rowMove,colMove,1);

    }
    private static void solveKT(int currRow , int currCol, int[][] board, int[] rowMove, int[] colMove, int number){

        board[currRow][currCol]=number;
        if (number==(board.length*board.length))
        {
            printTable(board);
            board[currRow][currCol]=0;
            return;
        }

        for (int i = 0; i < rowMove.length ; i++) {
            int nextRow = currRow+rowMove[i];
            int nextCol = currCol+colMove[i];
            if (isSafe(nextRow,nextCol,board) && board[nextRow][nextCol]==0)
            {
                solveKT(nextRow,nextCol,board,rowMove,colMove,number+1);
            }
        }
        board[currRow][currCol]=0;
    }

    private static void printTable(int[][] board) {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(int row, int col, int[][] board) {
        return row>=0 && row<board.length && col>=0 && col<board.length;
    }
}
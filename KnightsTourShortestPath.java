import java.util.concurrent.atomic.AtomicInteger;

public class KnightsTourShortestPath {
    public static void main(String[] args) {
        IndexPair src = new IndexPair(0,7);
        IndexPair des = new IndexPair(7,0);
        findPath(src,des);

    }

    private static void findPath(IndexPair src, IndexPair des) {
        int[][] board = new int[8][8];
        int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};
        AtomicInteger ai = new AtomicInteger(Integer.MAX_VALUE);
        find(src.row,src.col,des,rowMove,colMove,board,0,ai);
        System.out.println(ai.intValue());


    }

    private static void find(int currRow, int currCol,IndexPair des ,int[] rowMove, int[] colMove, int[][] board, int count , AtomicInteger ai) {
        board[currRow][currCol]=count;
        if (currRow == des.row && currCol==des.col)
        {
            int x = ai.intValue();
            x=Integer.min(x,count);
            ai.set(x);
            board[currRow][currCol]=count;
            return;
        }

        for (int i = 0; i < rowMove.length ; i++) {
            int nextRow = currRow+rowMove[i];
            int nextCol = currCol+colMove[i];
            if (isSafe(nextRow,nextCol,board) && board[nextRow][nextCol]==0)
            {
                find(nextRow,nextCol,des,rowMove,colMove,board,count+1,ai);
            }
        }
        board[currRow][currCol]=0;







    }

    private static boolean isSafe(int row, int col, int[][] board) {
        return row>=0 && row<board.length && col>=0 && col<board.length;
    }


}
class IndexPair{
    int row;
    int col;

    public IndexPair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

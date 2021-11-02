import java.util.ArrayList;
public class LongestRouteInMatrix {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
                };
        Pair source = new Pair(0,0);
        Pair destination = new Pair(5,7);
        int longestDis = findLongestRoute(matrix,source,destination);
        System.out.println(longestDis);
    }

    private static int findLongestRoute( int[][] matrix, Pair source, Pair destination){
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        return findLongestRoute(source.row,source.col,matrix,destination,visited);


    }

    private static int findLongestRoute(int row, int col, int[][] matrix, Pair destination, boolean[][] visited) {
        if (row==destination.row && col==destination.col)
            return 0;

        visited[row][col]=true;
        if (isSafe(row,col-1,matrix) && !visited[row][col-1])
        {int left = findLongestRoute(row,col-1,matrix,destination,visited)+1;}

        if (isSafe(row-1,col,matrix) && !visited[row-1][col])
        {int up = findLongestRoute(row-1,col,matrix,destination,visited)+1;}

        if (isSafe(row,col+1,matrix) && !visited[row][col+1])
        {int right = findLongestRoute(row,col+1,matrix,destination,visited)+1;}

        if (isSafe(row+1,col,matrix) && !visited[row+1][col])
        {int down = findLongestRoute(row+1,col,matrix,destination,visited)+1;}

         visited[row][col]=false;

        return 1;



    }

    private static boolean isSafe(int row, int col, int[][] matrix) {
        return row>=0 && row< matrix.length && col>=0 && col<matrix.length && matrix[row][col]==1;
    }
}

class Pair{
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
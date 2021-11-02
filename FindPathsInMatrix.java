import java.util.ArrayList;
import java.util.List;

public class FindPathsInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        ArrayList<ArrayList<Path>> paths = findPath(0,0,matrix);

    }

    private static ArrayList<ArrayList<Path>> findPath(int currRow, int currCol, int[][] matrix) {
        ArrayList<ArrayList<Path>> paths = new ArrayList<>();
        ArrayList<Path> path = new ArrayList<>();
        path.add(new Path(currRow,currCol));
        int[] rowMove = {0,1};
        int[] colMove = {1,0};
        findPath(currRow,currCol,rowMove,colMove,matrix,paths, path);
        return paths;
    }

    private static void findPath(int currRow, int currCol,int[] rowMove,int[] colMove ,int[][] matrix,ArrayList<ArrayList<Path>> paths,ArrayList<Path> path) {

        if (currRow==matrix.length-1 && currCol== matrix.length-1)
        {
            System.out.println(path);
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < rowMove.length ; i++) {
            if (currRow+rowMove[i]<matrix.length && currCol+colMove[i]< matrix.length) //condition to check whether next move breaks the board
            {
                path.add(new Path(currRow+rowMove[i],currCol+colMove[i]));
                findPath(currRow+rowMove[i],currCol+colMove[i],rowMove,colMove,matrix,paths,path);
                path.remove(path.size()-1);

            }
        }





    }
}

class Path{
    int row;
    int col;

    public Path(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "{"+row+" "+col+"}";
    }
}

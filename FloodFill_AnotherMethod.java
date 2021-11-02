import java.util.Arrays;

public class FloodFill_AnotherMethod {
    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,1,1}};
        for (int[] arr : image) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        int[][] x  = floodFill(image, 1, 1, 1);
        for (int[] arr : image) {
            System.out.println(Arrays.toString(arr));
        }


    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] seen = new boolean[image.length][image[0].length];
        int[] rowMove = {0, 1, 0, -1};
        int[] colMove = {1, 0, -1, 0};
        floodFill(image, seen, rowMove, colMove, sr, sc, newColor);
        return image;


    }

    public static void floodFill(int[][] image, boolean[][] seen, int[] rowMove, int[] colMove, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        seen[sr][sc] = true;
        image[sr][sc] = newColor;

        for (int i = 0; i < rowMove.length; i++) {
            if (isSafe(sr + rowMove[i], sc + colMove[i], image) && isValid(sr + rowMove[i], sc + colMove[i], image, color, seen))
                floodFill(image, seen, rowMove, colMove, sr + rowMove[i], sc + colMove[i], newColor);
        }
        seen[sr][sc] = false;
    }

    public static boolean isSafe(int row, int col, int[][] image) {
        return row < image.length && col < image[0].length && row > -1 && col > -1;
    }

    public static boolean isValid(int row, int col, int[][] image, int color, boolean[][] seen) {
        return image[row][col] == color  && !seen[row][col];
    }


}

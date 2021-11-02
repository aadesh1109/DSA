public class GoldmineProblem {
    public static void main(String[] args) {
        int[][] M = {{2,1},
                {1,2}};
        System.out.println(maxGold(M.length, M[0].length, M));
    }

    public static int maxGold(int n, int m, int[][] M) {
        int max = 0;
        for (int c = m - 2; c >= 0; c--) {
            for (int r = 0; r < n; r++) {
                if (r == 0 && r == n - 1)
                    M[r][c] += M[r][c + 1];
                else if (r == 0)
                    M[r][c] += Math.max(M[r][c + 1], M[r + 1][c + 1]);
                else if (r == n - 1)
                    M[r][c] += Math.max(M[r][c + 1], M[r - 1][c + 1]);
                else
                    M[r][c] += Math.max(M[r + 1][c + 1], Math.max(M[r][c + 1], M[r - 1][c + 1]));
                if (c == 0)
                    max = Math.max(max, M[r][c]);
            }
        }
        return max;
    }
}

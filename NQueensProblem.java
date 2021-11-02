import java.util.Arrays;

class NQueensProblem
{
    public static final int N = 4;
    private static boolean isSafe(char[][] mat, int r, int c)
    {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++)
            if (mat[i][c] == 'Q')
                return false;

        // return false if two queens share the same \ diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if (mat[i][j] == 'Q')
                return false;

        // return false if two queens share the same / diagonal
        for (int i = r, j = c; i >= 0 && j < N; i--, j++)
            if (mat[i][j] == 'Q')
                return false;

        return true;
    }

    private static void nQueen(char[][] mat, int r)
    {
        if (r == N)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                    System.out.print(mat[i][j] + " ");
                System.out.println();
            }
            System.out.println();

            return;
        }
        for (int c = 0; c < N; c++)
        {
            if (isSafe(mat, r, c))
            {
                mat[r][c] = 'Q';
                nQueen(mat, r + 1);
                mat[r][c] = '-';
            }
        }
    }

    public static void main(String[] args)
    {
        char[][] mat = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '-');
        }
        nQueen(mat, 0);
    }
}
public class NoOfSubMatrices {
    public static void main(String[] args) {
        int[][] matrix = new int[2][2];
        int c=0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = i; j < matrix.length ; j++) {
                for (int k = i; k < matrix.length ; k++) {
                    System.out.println(j+" "+k);
                }
            }
        }
        System.out.println(c);

    }
}

import java.util.Scanner;
public class RainWaterTrapping //Method1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findVolCollected(arr));

    }

    private static int findVolCollected(int[] arr) {
        int[] leftGreatest = new int[arr.length];
        int[] rightGreatest = new int[arr.length];
        int greatest = 0;
        for (int i = 0; i < arr.length ; i++) {
            leftGreatest[i]=greatest;
            greatest=Math.max(greatest,arr[i]);
        }
        greatest = 0;

        for (int i = rightGreatest.length-1; i >=0 ; i--) {
            rightGreatest[i]=greatest;
            greatest = Math.max(greatest,arr[i]);
        }
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            int value = Math.min(leftGreatest[i], rightGreatest[i]);
            if (value-arr[i]>0)
                sum+= value -arr[i];
        }
        return sum;
    }
}

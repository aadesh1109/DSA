import java.util.Scanner;

public class EvenOrOddUsingBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int x = sc.nextInt();
        if ((x&1)==1)
            System.out.println("ODD");
        else
            System.out.println("EVEN");
    }
}

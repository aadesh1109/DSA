import java.util.Arrays;
public class ZeroAndOne {
    public static void main(String[] args) {
        int[] a = {0,0,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] a){
        int i = 0, j = a.length-1;
        while (i<j) {
            while (i<j && a[i]!=0)
                i++;
            while (i<j && a[j]!=1)
                j--;

            a[i]=a[i]+a[j];
            a[j]=a[i]-a[j];
            a[i]=a[i]-a[j];
        }
    }
}
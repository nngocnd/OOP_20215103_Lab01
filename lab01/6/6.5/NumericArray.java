import java.util.Scanner;
import java.util.Arrays;

public class NumericArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int n = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = input.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        double average = sum / (1.0 * n);

        System.out.println("Array after sorting:\n");;
        for (int i : arr){
            System.out.println(i + " ");
        }
        System.out.println("\n");
        System.out.println("Sum :" + sum);
        System.out.println("Average: " + average);
    }
}

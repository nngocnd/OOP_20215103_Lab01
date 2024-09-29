import java.util.Scanner;

public class SumOfTwoMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows, cols;
        
        System.out.println("Rows: ");
        rows = input.nextInt();

        System.out.println("Cols: ");
        cols = input.nextInt();

        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];
        int[][] sum = new int[rows][cols];

        System.out.println("Input Matrix A:\n");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                A[i][j] = input.nextInt();
            }
        }
        
        System.out.println("Input Matrix B:\n");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                B[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                sum[i][j] = A[i][j] + B[i][j];
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}

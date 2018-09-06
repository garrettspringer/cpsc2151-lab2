package cpsc2150.lab2;

import java.util.Scanner;

public class MatrixApp
{
    public static void main(String[] args)
    {
        System.out.println("How many rows should your maxtrix have?");
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        System.out.println("How many columns should your matrix have?");
        int columns = input.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.println("What number should go in Row: " + i + " Col: " + j);
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();
        System.out.println("Your matrix is:");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print("| " + matrix[i][j] + " |");
            }
            System.out.println();
        }
        int[][] testTranspose = Transpose(matrix, rows, columns);
        System.out.println("The transposed matrix is: ");
        print(testTranspose, columns, rows);
        System.out.println("The product sum is: ");
        System.out.println(sumProduct(matrix, rows,columns));
        System.out.println("The average is: ");
        System.out.println(average(matrix, rows, columns));
        System.out.println("The sums of each Row are: ");
        rowSum(matrix, rows, columns);
        System.out.println("The sums of each Column are:");
        colSum(matrix, rows, columns);

    }

    private static int[][] Transpose(int[][] prev, int r, int c)
    {
        //
        int[][] next = new int[c][r];
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                next[j][i] = prev[i][j];
            }
        }
        return next;
    }

    private static int sumProduct(int[][] m, int r, int c)
    {
        int total = 1;
        int[] sums= new int[r];
        for (int i = 0; i < r; i++)
        {
            for (int j= 0;j<c; j++)
            {
                sums[i] += m[i][j];
            }
        }
        for (int i = 0; i < r; i++)
        {
            total *= sums[i];
        }
        return total;
    }
    private static double average(int[][] m, int r, int c)
    {
        double total = 0;
        for (int i = 0; i < r; i++)
        {
            for (int j= 0;j<c; j++)
            {
                total += m[i][j];
            }
        }
        return total/(r*c);
    }
    private static int[] colSum(int[][] m, int r, int c)
    {
        int[] sums= new int[c];
        for (int i = 0; i < c; i++)
        {
            for (int j= 0;j<r; j++)
            {
                sums[i] += m[j][i];
            }
            System.out.print("|"+sums[i]+"|");
        }
        System.out.println();
        return sums;
    }
    private static int[] rowSum(int[][] m, int r, int c)
    {
        int[] sums= new int[r];
        for (int i = 0; i < r; i++)
        {
            for (int j= 0;j<c; j++)
            {
                sums[i] += m[i][j];

            }
            System.out.print("|"+sums[i]+"|");
        }
        System.out.println();

        return sums;
    }
    private static void print(int[][] m, int r, int c)
    {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("| " + m[i][j] + " |");
            }
            System.out.println();
        }
    }
}
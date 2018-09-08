/*
 * Garrett Springer & Jackson Lee
 * Lab 2
 * CPSC 2151
 * 6 September 2018
 */

/**
 * This program creates a custom 2D Matrix generated from
 * the user's input.  The Matrix will print to the CL along
 * with the results of the altering functions
 */

package cpsc2150.lab2;

import java.util.Scanner;


public class MatrixApp
{
    public static void main(String[] args)
    {
        System.out.println("How many rows should your maxtrix have?");
        Scanner input = new Scanner(System.in); //to get input from the user
        final int rows = input.nextInt();
        System.out.println("How many columns should your matrix have?");
        final int columns = input.nextInt();
        final int[][] matrix = new int[rows][columns]; //user-generated matrix to be filled
        for (int i = 0; i < rows; i++) //fills the matrix with user input
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.println("What number should go in Row: " + i + " Col: " + j);
                matrix[i][j] = input.nextInt();
            }
        }
        input.close(); //scanner no longer needed
        System.out.println("Your matrix is:");
        System.out.println(print(matrix,rows,columns)); //prints the created matrix

        int[][] testTranspose = Transpose(matrix, rows, columns);

        // Displays the results of the matrix functions on the command line
        System.out.println("The transposed matrix is: ");
        System.out.println(print(testTranspose, columns, rows)); //prints transposed matric
        System.out.println("The product sum is: ");
        System.out.println(sumProduct(matrix, rows,columns)); //prints product sum
        System.out.println("The average is: ");
        System.out.println(average(matrix, rows, columns)); // prints average
        System.out.println("The sums of each Row are: ");
        int[] tempArray; //array to hold results of romSum and colSum
        tempArray = rowSum(matrix, rows,columns);
        for (int i = 0; i < rows; i++)
        {
            System.out.print("| "+tempArray[i] + " | "); //prints the rowSums
        }
        System.out.println();
        System.out.println("The sums of each Column are:");
        tempArray = colSum(matrix, rows,columns);
        for (int i = 0; i < columns; i++)
        {
            System.out.print("| "+tempArray[i] + " | "); //prints the colSums
        }
        System.out.println();
    }

    /**
     *
     * @param prev the matrix to be transposed
     * @param r the number of rows in prev
     * @param c the number of columns in prev
     * @return the transposed matrix "next"
     */
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

    /**
     *
     * @param m the matrix to be summed
     * @param r the number of rows in m
     * @param c the number of columns in m
     * @return the product of the sums of the rows in m
     */
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

    /**
     *
     * @param m the matrix to be averaged
     * @param r the number of rows in m
     * @param c the number of columns in m
     * @return the average of all numbers in m
     */
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

    /**
     *
     * @param m the matrix to be column summed
     * @param r the number of rows in m
     * @param c the number of columns in m
     * @return the sum of all the columns in m
     */
    private static int[] colSum(int[][] m, int r, int c)
    {
        int[] sums= new int[c];
        for (int i = 0; i < c; i++)
        {
            for (int j= 0;j<r; j++)
            {
                sums[i] += m[j][i];
            }

        }
        return sums;
    }

    /**
     *
     * @param m the matrix to be row summed
     * @param r the number of rows in m
     * @param c the number of columns in m
     * @return the sum of all of the rows in m
     */
    private static int[] rowSum(int[][] m, int r, int c)
    {
        int[] sums= new int[r];
        for (int i = 0; i < r; i++)
        {
            for (int j= 0;j<c; j++)
            {
                sums[i] += m[i][j];

            }
        }
        return sums;
    }

    /**
     *
     * @param m the matrix to be printed
     * @param r the number of rows in m
     * @param c the number of columns in m
     */
    private static String print(int[][] m, int r, int c)
    {
        String result = "";
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result += ("| " + m[i][j] + " | ");
            }
            result += "\n";
        }
        return result;
    }
}
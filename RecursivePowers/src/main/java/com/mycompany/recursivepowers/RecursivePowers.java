/* I hereby declare upon my word of honor that I have neither given nor 
 * received unauthorized help on this work.
 *  */
package com.mycompany.recursivepowers;

import java.util.Scanner;

/**
 * 
 * @author Chris Whitworth
 */
public class RecursivePowers {
    
    public RecursivePowers(){
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecursivePowers recursive = new RecursivePowers();

        int result = recursive.power(recursive.getPositiveNum(scanner), 
                recursive.getPositiveNum(scanner));

        System.out.println("Result: " + result);

        // Close the scanner
        scanner.close();
    }

    /**
     * recursive positive number request
     * @param scanner
     * @return 
     */
    private int getPositiveNum(Scanner scanner) {
        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("I said a positive number!");
            return getPositiveNum(scanner);
        }

        return number;
    }

    /**
     * recursive exponent method
     * @param base
     * @param exponent
     * @return 
     */
    private int power(int base, int exponent) {
        // Base case: when the exponent is 0, it's always 1
        if (exponent == 0) {
            return 1;
        }

        // multiply base by the result of recursive call
        int temp = power(base, exponent / 2);
        int result = temp * temp;

        // Adjust the result if the exponent is odd
        if (exponent % 2 == 1) {
            result *= base;
        }

        return result;
    }
}
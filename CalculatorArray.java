/* Project Title: Array Calculator
 * File Name: CalculatorArray.java
 * Date Compiled Last: March 26, 2023
 * Author: Myo B)
 * Compiled in: VSC LMAO (Transfer to eclipse later)
 * Version: 1.3.1 (1.4 when fixing NaN)
 * 
 * Integrity: I have not copied any lines of code from any online resources
 * 
 * Exception to Integrity: Notes I've taken, Official Java Documentation
 * 
 */


package ClassProjects;

import java.util.Scanner;

public class CalculatorArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Variables/Arrs
        
        String[] menu = {"Menu", "Add", "Subtract", "Multiply", "Divide", "Dot product", "Generate Random array", "Quit"};
        String question1 = "What would you like to do?";
        String question2 = "How many values are in the arrays?";
        String question3 = "Enter the values in the first array, separated by spaces:";
        String question4 = "Enter the values in the second array, separated by spaces:";
        String randQuestion1 = "How many values should be in the random array?";
        String randQuestion2 = "What is the lower limit for the random number?";
        String randQuestion3 = "What is the upper limit for the random number?";
        String results = "The result is ";
        String resultEnd = "]";
        int arrslen;
        int operation;
        boolean errDiv = false;
        int errPos = 0;
        double dotProd = 0;
        int randArrLen;
        int randUpLimit;
        int randLowLimit;

        //Menu printing
        for (int i = 0; i < menu.length; i++) {
            if (i == 0) {
                System.out.println(menu[0]);
            }
            else {
            System.out.println(i + ". " + menu[i]);
            }
        }

        //Operation config
        System.out.println(question1);
        operation = input.nextInt();

        if (operation == 7) {
            System.out.print("Goodbye!");
        }
        else if (operation == 6) {

            System.out.println(randQuestion1);
            randArrLen = input.nextInt();

            double[] randArr = new double[randArrLen];
            
            System.out.println(randQuestion2);
            randLowLimit = input.nextInt();

            System.out.println(randQuestion3);
            randUpLimit = input.nextInt();

            for (int i = 0; i < randArrLen; i++) {
                randArr[i] = Math.random()*(randUpLimit - randLowLimit + 1) + randLowLimit;
            }

            System.out.print(results + "[");
            for (int i = 0; i < randArrLen - 1; i++) {
                System.out.print(randArr[i] + ", ");
            }

            System.out.print(randArr[randArrLen - 1] + resultEnd);
            
        }
        else if (operation != 6 && operation != 7) {
            //Num of nums in arrs
            System.out.println(question2);
            arrslen = input.nextInt();

            int[] primArr = new int[arrslen];
            int[] secArr = new int[arrslen];
            double[] resultArr = new double[arrslen];

            //TODO Add alternate menu for random array and place if statement to swap between normal and rand limits

            //Grabs first array
            System.out.println(question3);
            for (int i = 0; i < arrslen; i++) {
                int tempVal = input.nextInt();
                primArr[i] = tempVal;
            }

            //Grabs second array
            System.out.println(question4);
            for (int i = 0; i < arrslen; i++) {
                int tempVal = input.nextInt();
                secArr[i] = tempVal;
            }

            switch (operation) {
                case 1: //Addition
                    for(int i = 0; i < arrslen; i++) {
                        int tempSum = primArr[i] + secArr[i];
                        resultArr[i] = tempSum;
                    }
                    break;
                case 2: //Subtraction
                    for(int i = 0; i < arrslen; i++) {
                        int tempSum = primArr[i] - secArr[i];
                        resultArr[i] = tempSum;
                    }
                    break;
                case 3: //Multiplication
                    for(int i = 0; i < arrslen; i++) {
                        int tempSum = primArr[i] * secArr[i];
                        resultArr[i] = tempSum;
                    }
                    break;
                case 4: //Division
                    for(int i = 0; i < arrslen; i++) {
                        if (secArr[i] == 0) {
                            errPos = i;
                            errDiv = true;
                            resultArr[i] = 0;
                        }
                        else {
                        double tempSum = (double)primArr[i] / secArr[i];
                        resultArr[i] = tempSum;
                        }
                    }
                    break;
                case 5:
                    for(int i = 0; i < arrslen; i++) {
                        int tempSum = primArr[i] * secArr[i];
                        resultArr[i] = tempSum;
                    }
                    for(int i = 0; i < arrslen; i++) {
                        dotProd += resultArr[i];
                    }
                    break;
                case 6:
                    //TODO Random Array Generation
                    break;
                default:
                    break;
            }

            //FIXME Account for NaN when dividing by 0 WHEN in last index

            //Final output of results
            System.out.print(results);
            if (operation != 5) {
                System.out.print("[");
                for (int i = 0; i < arrslen - 1; i++) {
                    if (errDiv == true) {
                        if (errPos == i) {
                            System.out.print("NaN");
                            if (i != arrslen) {
                                System.out.print(", ");
                            }
                        }
                        else {
                            System.out.print(resultArr[i] + ", ");
                        } 
                    }
                    else {
                        System.out.print(resultArr[i] + ", ");
                    }
                }
                System.out.print(resultArr[arrslen - 1] + resultEnd);
            }
            else {
                System.out.print(dotProd);
            }

        }
         
        input.close();
    }
}

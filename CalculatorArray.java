/* Project Title: Array Calculator
 * File Name: CalculatorArray.java
 * Date Compiled Last: March 31, 2023
 * Author: Myo B)
 * Compiled in: Eclispe 2022-12
 * Version: 1.4.4, Fully Working NaN Support!!!
 * 
 * Integrity: I have not copied any lines of code from any online resources and this code is my own doing
 * 
 * Exception to Integrity: 
 * Java Docs(?)
 * Line 78: https://www.javatpoint.com/how-to-generate-random-number-in-java 
 * 
 * Extra Notes: 
 * Github for history https://github.com/Myolitz/Array-Calculator
 * Youtube link for me coding (most of) this: https://www.youtube.com/watch?v=ZzFkrRUfLKI
 */


package ClassProjects;

import java.util.Scanner;

public class CalculatorArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Arrs
        //Maybe could've had the questions be an array like the menu, meh
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

        //Vars
        int arrslen;
        int operation;
        boolean errDiv = false; //This and below function exclusively for division
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

        //Goodbye 
        if (operation == 7) {
            System.out.print("Goodbye!");
        }
        //Random Array Questionaire
        else if (operation == 6) {
            System.out.println(randQuestion1);
            randArrLen = input.nextInt();

            //Array initialized inside as randArrLen is not set beforehand
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
        //1-5
        else if (operation != 6 && operation != 7) {
            //Num of nums in arrs
            System.out.println(question2);
            arrslen = input.nextInt();

            //See Line 73
            int[] primArr = new int[arrslen];
            int[] secArr = new int[arrslen];
            double[] resultArr = new double[arrslen];
            int[] errPos = new int[arrslen];

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

            //Operation switch
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
                        //Checks for any dype of division by 0
                        if (secArr[i] == 0) { 
                            errPos[i] = i;
                            errDiv = true;
                            resultArr[i] = 0;
                        }
                        else {
                        double tempSum = (double)primArr[i] / secArr[i];
                        resultArr[i] = tempSum;
                        //System.out.println("resultArr[" + i + "]: " + resultArr[i]);
                        }
                    }
                    break;
                case 5: //Dot Product [(a+b) * (c+d) * (e*f) = g]
                    for(int i = 0; i < arrslen; i++) {
                        int tempSum = primArr[i] * secArr[i];
                        resultArr[i] = tempSum;
                    }
                    for(int i = 0; i < arrslen; i++) {
                        dotProd += resultArr[i];
                    }
                    break;
                default:
                    break;
            }

            //Final output of results
            System.out.print(results);
            if (operation != 5) {
                System.out.print("[");
                for (int i = 0; i <= arrslen - 1; i++) {
                    //If division by 0 is detected
                    if (errDiv == true) {
                        //Since wherever the division was set resultArr[i] to 0, checks values
                        if (resultArr[i] != 0) {
                            if (i != arrslen - 1) {
                                System.out.print(resultArr[i] + ", ");
                            }
                            else {
                                System.out.print(resultArr[i] + resultEnd);
                            }
                        }
                        //If it is 0, it was NaN
                        else if (resultArr[i] == 0) {
                            if (i != arrslen - 1) {
                                System.out.print("NaN, ");
                            }
                            else {
                                System.out.print("NaN]");
                            }
                        }
                    // else if (errPos[i] != i) { //Unsure what this was for tbh
                    //     System.out.print(resultArr[i] + ", ");
                    // } 
                    }
                    else {
                        System.out.print(resultArr[i] + ", ");
                    }
                }
                //Well if no division fails happened then just print as normal
                if (errDiv == false) {
                    System.out.print(resultArr[arrslen - 1] + resultEnd);
                } 
            }
            else {
                System.out.print(dotProd);
            }

        }
        input.close();
    }
}

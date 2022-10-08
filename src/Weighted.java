/**
 * Assignment3
 * [Yuhao Zhang]
 * [002743843]
 * [Section08]
 */

import java.util.Scanner;

public class Weighted {
    public static void main(String[] args) {
        Integer[] totalInput;
        Integer[] earnedInput;
        Integer[] percentInput;


        //Receive the total points from users
        System.out.println("Please input the total point for all the assignments (should be positive integers and seperated with comma):");
        Scanner scanPoint = new Scanner(System.in);  //construct an object scanPoint for receiving the input
//        while (scanPoint.hasNextLine()) {
            String scP = scanPoint.nextLine();   //receive string with next()
            String[] totalInputStr = scP.split(",");    //convert the input string into a string array
            totalInput = new Integer[totalInputStr.length];
        System.out.print("The total points you input is");
            for (int n = 0; n < totalInput.length; n++) {
                totalInput[n] = Integer.parseInt(totalInputStr[n]); //convert string array to integer array
                if (totalInput[n] < 0) {      //check whether the total point typed is correct
                    System.out.println("Please check your input!");
//                    continue;
                }
                System.out.print(" " + totalInput[n]);
//                break;
            }
//        }

        //Receive the earned points from users
        System.out.println("\nPlease input the point you earned for all the assignments (should be positive integers and seperated with comma):");
        Scanner scanEarned = new Scanner(System.in);
//        while (scanEarned.hasNextLine()) {    //check whether the number of input is corresponded
            String scE = scanEarned.nextLine();
            String[] earnedInputStr = scE.split(",");
            earnedInput = new Integer[earnedInputStr.length];
        System.out.print("The earned points you input is");
            for (int n = 0; n < earnedInput.length; n++){
                earnedInput[n] = Integer.parseInt(earnedInputStr[n]);
                if (earnedInput[n] < 0 || earnedInput[n] > totalInput[n]){
                    System.out.println("Please check your input");
//                    continue;
                }
                System.out.print(" " + earnedInput[n]);
//                break;
            }
//        }

        //Receive the input from users
        System.out.println("\nPlease input the percentage of all the assignments accounting for of this class grade (should be 8 positive integers, '%'has been added):");
        Scanner scanPercent = new Scanner(System.in);
//        while (scanPercent.hasNextLine()) {    //check whether the input is correct
            String scPer = scanPercent.nextLine();
            String[] assPercentInputStr = scPer.split(",");
            percentInput = new Integer[assPercentInputStr.length];
        System.out.print("The assignment percentage you input is");
            for (int n = 0; n < percentInput.length; n++) {
                percentInput[n] = Integer.parseInt(assPercentInputStr[n]);
                if (percentInput[n] < 0 || percentInput[n] > 100) {      //check whether the percentage typed is correct
                    System.out.print("Please check your input!");
//                    continue;
                }
                System.out.print(" " + percentInput[n] + "%");
//                break;
            }
//        }


        Point student = new Point();
        //Set value for parameters
        student.setTotalPoint(totalInput);
        student.setEarnedPoint(earnedInput);
        student.setAssPercent(percentInput);
        Double[] percent = new Double[8];
        Double[] grade = new Double[8];

        //Calculate final result using getter in Point class
        System.out.println("\nWeighted grade:");
        double total = 0.0;
        for (int n = 0; n < totalInput.length; n++) {
            percent[n] =Double.valueOf(student.getAssPercent()[n]) / 100;
            grade[n] = Double.valueOf(student.getEarnedPoint()[n]) / Double.valueOf(student.getTotalPoint()[n]) * percent[n] * 100;
            System.out.print(" " + grade[n]);
            total += grade[n];
        }
        System.out.printf("Your final point is " + total + ". Which is ");

        //give the final letter grade with 'if-else'
        if (total >= 90 && total <= 100){
            System.out.printf("A");
        } else if (total >= 80) {
            System.out.printf("B");
        } else if (total >= 70) {
            System.out.printf("C");
        } else if (total >= 60) {
            System.out.printf("D");
        } else {
            System.out.printf("F");
        }
    }
}

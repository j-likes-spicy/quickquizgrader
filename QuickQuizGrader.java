/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quickquizgrader;

import java.util.Scanner;

/**
 *
 * @author Josh H
 */
public class QuickQuizGrader {

    /**
     * @param args the command line arguments
     */
    
    // method to print grades entered
    public static void printGrades(double arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0.0 && arr[i] != 999) {
                System.out.println("You entered: " + arr[i]);
            }    
        }
    }
    
    // another method to print letter grades
    public static void printLetterGrades(double arr[]){
        String letterGrade;        
        for (int i = 0; i < arr.length; i++) {
            // data correction for grades entered greater than 100
            if (arr[i] > 100 && arr[i] != 999) {
                arr[i] = 100;
            }
            if (arr[i] >= 90) {
                letterGrade = "A";
            } 
            else if (arr[i] >= 80) {
                letterGrade = "B";
            }
            else if (arr[i] >= 70) {
                letterGrade = "C";
            }
            else if (arr[i] >= 60) {
                letterGrade = "D";
            }
            else {
                letterGrade = "F";
            }
            
            // output string containing letter grades if not 999 or 0
            if (arr[i] > 0.0 && arr[i] != 999) {
                System.out.println("You entered: " + arr[i] + ". " + "For grade " +  (i + 1) + ", " + arr[i] + " is a " + letterGrade);
            }
            
        }
    }
    
    // method to calculate and display average score
    public static void findAverageGrade(double arr[]) {
        double total = 0.0;
        double averageScore = 0.0;
        String averageGrade;
        for (int i = 0; i < arr.length; i++) {
            // omit negative values
            if (arr[i] < 0) {
                arr[i] = 0;
            }
            // data correction for grades entered greater than 100
            if (arr[i] > 100 && arr[i] != 999) {
                arr[i] = 100;
            }
            
            // omit any 999 entries
            if (arr[i] == 999) {
                arr[i] = 0;
            }
            
            // sum valid array values
            total += arr[i];
            
            // find average, account for zero index
            if (arr[i] != 0) {
                averageScore = total / (i + 1);
            }
            
            
        }
        
        // display average grade based on averageScore variable
            if (averageScore >= 90) {
                averageGrade = "A";
            } else if (averageScore >= 80) {
                averageGrade = "B";
            } else if (averageScore >= 70) {
                averageGrade = "C";
            } else if (averageScore >= 60) {
                averageGrade = "D";
            } else {
                averageGrade = "F";
            }
        
        // display average
            System.out.println("Your average score is " + averageScore + " Overall, your average grade is a " + averageGrade);
    }
    
    public static void main(String[] args) {
        // Program variables
        
        String userInput;
        boolean validator = false;
        Scanner in = new Scanner(System.in);
        double[] gradesArray = new double[10];
        double numeric = 0.0;
        
        // Display welcome message
        System.out.println("Welcome to QuickQuizGrader");
        System.out.println("A simple Java console application that");
        System.out.println("will total your quiz grades.");
        System.out.println("The program allows up to 10 entries");
        System.out.println("To terminate early, simply enter 999 \n");
        
        // For loop to prompt for grades
        for (int i = 0; i < gradesArray.length; i++) {
            // Nested while loop for data validation purposes
            while (validator == false) {
                // prompt user to enter a grade
                System.out.print("Enter your grade, then press Return/Enter: ");
                // gather input from the keyboard
                userInput = in.nextLine();
                /* For enhanced data validation purposes, we will gather the
                    user input in the form of a string, and try to convert the
                    entry to a double. If the user neglects to enter a valid 
                    data type, the loop will keep continuing.
                */
                try {
                    numeric = Double.parseDouble(userInput);                    
                    gradesArray[i] = numeric;
                    validator = true;
                }
                
                catch(NumberFormatException e) {
                    System.out.println("Please enter a number");
                }
                
                
            }
            
            // conditional to break loop
            if (gradesArray[i] == 999) {
                System.out.println("Terminating program per request");
                break;
            }
            
            // reinitialize validator back to false
            validator = false;
        }
            
            
            
            // call method to print the letter grades
            printLetterGrades(gradesArray);
            
            // call method to calculate average
            findAverageGrade(gradesArray);
    }
    
}

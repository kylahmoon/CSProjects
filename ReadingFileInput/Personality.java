// Kylah Moon
// 11/23/21
// CSE 142
// TA: Jacob Berg - Section AU
// Take-home Assesment #7
// This program takes A or B (or skip) answers from a file input and depending on the answers prints 
// out the users four letter personality type based off of E/I, S/N, T/F, and J/P.

import java.util.*;
import java.io.*;

public class Personality {

    public static final int DIMENSIONS = 4;
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        intro();

        System.out.print("input file name? ");
        String inputFileName = console.nextLine();
        Scanner input = new Scanner(new File(inputFileName));
        
        System.out.print("output file name? ");
        String outputFileName = console.nextLine();
        PrintStream output = new PrintStream(new File(outputFileName));
        
         while(input.hasNextLine()){
            String name = input.nextLine();
            String testAnswers = input.nextLine();
            int [] answersA = new int[DIMENSIONS];
            int [] answersB = new int[DIMENSIONS];
            
            computeAB(answersA, answersB, testAnswers);
            int[] results = percentageB(answersA, answersB);
            String personaltyType = endResults(results);

            output.print(name + ": " + Arrays.toString(results) + " = " + personaltyType);  
            output.println();
         } 

    }

// This program prints the introduction for the program.
   public static void intro(){
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }

// This method counts up the A and B values of the users answers. 
// Parameters: 
//    int[] answersA - an array that tracks all the users A answers.
//    int[] answersB - an array that tracks all the users B answers.
//    String testAnswers - takes in a String of all of the users answers.
    public static void computeAB(int[] answersA, int[] answersB, String testAnswers){
        for (int i = 0; i < 70; i++){
            char count = testAnswers.charAt(i);
            if(count == 'a' || count == 'A'){
               whichDimension(answersA, i);
            }else if(count == 'b' || count == 'B'){
               whichDimension(answersB, i);
            }
        }
    }
    
// This method finds which of the four dimensions the A or B answers counts is in. 
// Parameters: 
//    int[] aAndB - this array stores whether its an A or B in its specific spot.
//    int i - the value i from the for loop.   
    public static void whichDimension(int[] aAndB, int i){
       if ( i % 7 < 1){
         aAndB[0]++;
         
       }else if( i % 7 < 3){
         aAndB[1]++;
              
       } else if( i % 7 < 5){
         aAndB[2]++;
         
       }else if( i % 7 < 7){
         aAndB[3]++;
       } 
    }

// This method finds the percentage of B responses per dimension. 
// Returns: int[] results - an array with the percentage for each dimension.
// Parameters: 
//    int[] answersA - an array that tracks all the users A answers.
//    int[] answersB - an array that tracks all the users B answers.
   public static int[] percentageB(int[] answersA, int[] answersB){
      int totalAnswers = 0;
      double percentage = 0;
      int roundedPercent = 0;
      int[] results = new int[DIMENSIONS];
      
      for (int i = 0; i < DIMENSIONS; i++){
         totalAnswers = answersA[i] + answersB[i];
         percentage = (((double)answersB[i] / totalAnswers) * 100);
         roundedPercent = (int)Math.round(percentage);
         results [i] += roundedPercent;
      }
      return results;
   }

// This method finds the end four letter personality type. 
// Returns: String personalityType - the four letter personality type.
// Parameters: 
//    int[] results - an array with the percentage for each dimension.
   public static String endResults(int[] results){
      String[] personality = new String[DIMENSIONS];
      String personalityType = "";
      String typeA = "ESTJ";
      String typeB = "INFP";
      
      for (int i = 0; i < DIMENSIONS; i++){
         char charA = typeA.charAt(i);
         char charB = typeB.charAt(i);
         if(results[i] < 50){
            personalityType += charA;
         }else if(results[i] > 50){
            personalityType += charB;
         }else if(results[i] == 50){
            personalityType += "X";
         }
      }  
      return personalityType;
   }
}

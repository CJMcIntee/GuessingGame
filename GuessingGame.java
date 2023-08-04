//Christine McIntee
//June 28th 2023
//Guessing Game
//This program is a guessing game that the user can play as many times as they want.

import java.util.*;

public class GuessingGame {
   public static final int RANGE = 100;
   
   //play game as many times as the user chooses
   public static void main(String[] args) {  
      Scanner console = new Scanner(System.in);          
      intro();
      int numGuesses = playGame(console);
      int best = numGuesses;
      int numGames = 1; 
      System.out.println("Do you want to play again? ");
      String gameAgain = console.next().toUpperCase();   
      while(gameAgain.startsWith("Y")) {    
         numGuesses += playGame(console);
         if (numGuesses - best < best) {
            best = numGuesses - best;
         } 
         System.out.println("Do you want to play again? ");
         gameAgain = console.next().toUpperCase();  
         numGames++;    
      }
      double average = numGuesses / numGames;        
      showResults(numGames, numGuesses, average, best);  
   } //end main method
   
   //play a single game and return number of guesses
   public static int playGame(Scanner console) {
      Random rand = new Random();
      int randomNumber = rand.nextInt(RANGE);
      int numGuesses = 1;
      //Show random number
      //System.out.println("\nRandom number = " + randomNumber);
      System.out.printf("\nI'm thinking of a number between 1 and 100...\n");
      System.out.print("Your guess? ");
      int guess = console.nextInt();     
      while(guess != randomNumber) {   
         if (guess < randomNumber) {
            System.out.println("It's higher."); 
            }
         if (guess > randomNumber) {
            System.out.println("It's lower.");
            }    
         System.out.print("Your guess? ");
         guess = console.nextInt();   
         numGuesses++;
      }
      if (numGuesses == 1) {
         System.out.println("You got it right in " + numGuesses + " guess");
      } else {  
         System.out.println("You got it right in " + numGuesses + " guesses");
      }
      return numGuesses;       
   } //end playGame method
    
   //display game statistics to user
   public static void showResults(int numGames, int numGuesses, 
                                    double average, int best) {
      System.out.println("Overall results:");
      System.out.printf("  total games = %2d\n", + numGames);
      System.out.printf("  total guesses = %2d\n", + numGuesses);
      System.out.printf("  guesses/game = %2.1f\n", + average);
      System.out.printf("  best game = " + best);   
   } //end showResults method
                     
   //introduce and explain program to user
   public static void intro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.printf("than your guess.\n");           
   } //end intro method 
      
} //end GuessingGame class

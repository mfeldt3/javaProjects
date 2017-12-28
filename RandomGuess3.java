/*
Author: Michael Feldt
Date:10/21/16

RandomGuess3 is a simple program that plays a game of guess the number between 1 and 1000. The computer prompts the user if their guess is too long and keeps count of how many guesses there were until
the correct number is guessed.
*/
import java.util.*;
public class RandomGuess3
{
   public static void main(String[] args)
   {
      int playAgain=0;
      do //Loop for if  the user wants to play again
      {
      Random number= new Random();  
      int count=0;
      int MAX=1000;
      int theNumber=number.nextInt(MAX)+1; //Random number from Random class between 1-1000
      int guess=0;

         do // Nested loop that takes guesses and adds to count until the user correctly guesses the number
         {
           System.out.println("Please enter your guess for a number between 1-1000.");
           Scanner userInput=new Scanner(System.in);
           guess=userInput.nextInt();
           ++count;
           
           if (guess>theNumber)
           {
              System.out.println("You are too high");
            
           }
           else if (guess <theNumber)
           {
              System.out.println("You are too low");
              
           } 
           else
           {
             System.out.println("You got it! It only took you " + count + " guesses");
           }
         } while (guess!=theNumber);
         System.out.println("Would you like to play again? 1.Yes 2. No ");
         Scanner userPlay= new Scanner(System.in);
         playAgain=userPlay.nextInt();
      }while (playAgain==1); 
      System.out.println("Thanks for playing"); //Thanks for playing display  
      
   }//end main
}

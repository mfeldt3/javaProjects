/*
Author: Michael Feldt
Date:10/21/16
//Five Dice displays five random dice results for the user and cpu. 
*/
import java.util.*;
public class fiveDice
{
   public static void main(String[] args)
   {
    Random dice1= new Random(); //random number
    Random dice2= new Random();
    Random dice3= new Random();
    Random dice4=new Random();
    Random dice5=new Random();
    int MAX=6;
    int d1result=dice1.nextInt(MAX)+1; //Dye number
    int d2result=dice2.nextInt(MAX)+1;
    int d3result=dice3.nextInt(MAX)+1;
    int d4result=dice4.nextInt(MAX)+1;
    int d5result=dice5.nextInt(MAX)+1;
    
    ArrayList userDice=new ArrayList(); //Created an array of dice result objects
    userDice.add(d1result);
    userDice.add(d2result);
    userDice.add(d3result);
    userDice.add(d4result);
    userDice.add(d5result);
    
    System.out.println("User dice results");
    for (int i=0; i<userDice.size(); ++i)
    {
      System.out.print(userDice.get(i) + " ");
    }
    System.out.println(); // Add new line to avoid confusion
    
    Random cpuDice1= new Random(); // CPU random number
    Random cpuDice2= new Random();
    Random cpuDice3= new Random();
    Random cpuDice4=new Random();
    Random cpuDice5=new Random();
    
    
    int cd1result=cpuDice1.nextInt(MAX)+1; //CPU die results
    int cd2result=cpuDice2.nextInt(MAX)+1;
    int cd3result=cpuDice3.nextInt(MAX)+1;
    int cd4result=cpuDice4.nextInt(MAX)+1;
    int cd5result=cpuDice5.nextInt(MAX)+1;
    
    ArrayList cpuResult= new ArrayList(); //Cpu array of dice thrown objects
    
    cpuResult.add(cd1result);
    cpuResult.add(cd2result);
    cpuResult.add(cd3result);
    cpuResult.add(cd4result);
    cpuResult.add(cd5result);
    
    System.out.println("Computers dice results");
    for (int z=0; z<cpuResult.size(); ++z)
    {
      System.out.print(cpuResult.get(z) + " "); //printed the results from the array
    }
    
       
   }
}

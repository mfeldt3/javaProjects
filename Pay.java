import java.util.Scanner;
import javax.swing.*;
/*
Author: Michael Feldt
Date:10/21/16

Pay is a program that takes user input for skill level and hours worked and allows the user to select which insurance options they have and it displays their net pay.
*/
public class Pay
{
   public static void main(String[] args)
   {  
      int skill=0;
      do
      {
      System.out.println("What skill level worker are you?");
      Scanner skillLevel= new Scanner(System.in);
      skill=skillLevel.nextInt();
      } while (skill<1 || skill>3); //Do while loop to make sure the user enters an appropraite skill level
      System.out.println("How many hours did you work this week?");
      Scanner hoursWorked= new Scanner(System.in);
      int hours= hoursWorked.nextInt();
      int fullWeek=40;
      double overtime=1.5;
      double moneyEarned=0.00;
      double normalPay=0.00;
      double otPay=0.00;
      int insurance=0;
      double icost=0.00;
      double netPay=0.00;
      
      double pay;
      //Switch to gain what skill level the worker is
      switch (skill)
      {
         case 1:
            {
               pay=17.00;
               break;
            }
         case 2:
            {
               pay=20.00;
               break;
            }   
         case 3:
            {
               pay=22.00;
               break;
            }
         default:
            {
               pay=0;
               System.out.println("You have not enetered a valid skill level.");
               break;
            }               
      }
      // Find if overtime was worked and caluclates how much money was earned for the week
      if (hours<=fullWeek)
      {
         moneyEarned=hours*pay;
         otPay=0.00;
         normalPay=moneyEarned;
      }
      else
      {
         double ot=hours-40;
         otPay=ot * (pay*overtime);
         normalPay=40* pay;
         moneyEarned=normalPay+otPay;
         
      }
      //Ask for insurance input 
      double dentalReply=0;
      double medicalReply=0;
      double lTDisabilityReply=0;
      double retirementReply=0;
      //used JOptionPane to ask YES/NO if the user would like any of the insurance options offered
      if (skill==2)
      {
         dentalReply = JOptionPane.showConfirmDialog(null, "Would you like to enroll in Dental insurance for 20.00$/Wk ","Dental", JOptionPane.YES_NO_OPTION);
         medicalReply = JOptionPane.showConfirmDialog(null, "Would you like to enroll in Medical insurance for 32.50$/Wk ","Medical", JOptionPane.YES_NO_OPTION);
         lTDisabilityReply = JOptionPane.showConfirmDialog(null, "Would you like to enroll in Long Term Disibility insurance for 10.00$/Wk ","Long Term Disibility", JOptionPane.YES_NO_OPTION);
         retirementReply=JOptionPane.NO_OPTION;
      }
      else if (skill==3)
      {
         dentalReply = JOptionPane.showConfirmDialog(null, "Would you like to enroll in Dental insurance for 20.00$/Wk ","Dental", JOptionPane.YES_NO_OPTION);
         medicalReply = JOptionPane.showConfirmDialog(null, "Would you like to enroll in Medical insurance for 32.50$/Wk ","Medical", JOptionPane.YES_NO_OPTION);
         lTDisabilityReply = JOptionPane.showConfirmDialog(null, "Would you like to enroll in Long Term Disibility insurance for 10.00$/Wk ","Long Term Disibility", JOptionPane.YES_NO_OPTION);
         retirementReply = JOptionPane.showConfirmDialog(null, "Would you like to enroll in our retirement package for 3% of your gross pay ","Retirement", JOptionPane.YES_NO_OPTION);
      }
      else
      {
         retirementReply=JOptionPane.NO_OPTION;
         dentalReply=JOptionPane.NO_OPTION;
         lTDisabilityReply=JOptionPane.NO_OPTION;
         medicalReply=JOptionPane.NO_OPTION; 
      }
      double dental=0.00;
      double medical=0.00;
      double retirement=0.00;
      double LTD=0.00;
      //added cost for which ever insurance options the user selected
      if (dentalReply==JOptionPane.YES_OPTION)
      {
         dental=20.00;
      }
      else
      {
         dental=0.00;
      }   
      if (medicalReply==JOptionPane.YES_OPTION)
      {
         medical=32.50;
      }
      else
      {
         medical=0.00;
      }   
      if (lTDisabilityReply==JOptionPane.YES_OPTION)
      {
         LTD=10.00;
      }
      else
      {
         LTD=0.00;
      }
      if (retirementReply==JOptionPane.YES_OPTION)
      {
         retirement=(moneyEarned*0.03);
      }
      else
      {
         retirement=0.00;
      }   
      icost= dental+ medical+ LTD+ retirement;
      System.out.println("You get paid " + pay + " dollars per hour");
      System.out.println("You worked " + hours + " hours this week.");
      System.out.println("You earned " + normalPay + " dollars this week for standard hours");
      System.out.println("You earned " + otPay + " dollars this week for overtime hours");
      System.out.println("You earned " + moneyEarned + " dollars this week.");
      JOptionPane.showMessageDialog(null, "Your gross income is " +moneyEarned+ " dollars."); //Used JOptionPane to show gross pay.
      System.out.println("Your insurance deductions are " + icost + " dollars.");
      //if statement to make sure net earnings are not negative
      netPay=moneyEarned-icost;
      if (netPay<0)
         {
            System.out.println("Your insurance cost more than what you make in a week");
         }
      else
         {
            System.out.println("Your net pay after insurance deductions is " + netPay + " dollars");
         }   
      
      
      

   }//end main
}

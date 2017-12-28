//Author:Michael Feldt
//Date: 12/25/16
//JLottery2 has checkboxes for availble numbers and the user selects 6 numbers as their lottery picks. The program then select 6 random winning lottery numbers and displays the winnings of the user.
import javax.swing.*; //import needed packages

import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class JLottery2 extends JFrame implements ItemListener, ActionListener {

	public static void main(String[] args)
	{
		JLottery2 frame=new JLottery2();
		frame.setVisible(true);
		frame.setSize(600,400); //set size of frame
		
	}
	JCheckBox zero=new JCheckBox("0"); //created checkbox buttons
	JCheckBox one=new JCheckBox("1");
	JCheckBox two=new JCheckBox("2");
	JCheckBox three=new JCheckBox("3");
	JCheckBox four=new JCheckBox("4");
	JCheckBox five=new JCheckBox("5");
	JCheckBox six=new JCheckBox("6");
	JCheckBox seven=new JCheckBox("7");
	JCheckBox eight=new JCheckBox("8");
	JCheckBox nine=new JCheckBox("9");
	JCheckBox ten=new JCheckBox("10");
	JCheckBox eleven=new JCheckBox("11");
	JCheckBox twelve=new JCheckBox("12");
	JCheckBox thirteen=new JCheckBox("13");
	JCheckBox fourteen=new JCheckBox("14");
	JCheckBox fifteen= new JCheckBox("15");
	JCheckBox sixteen=new JCheckBox("16");
	JCheckBox seventeen = new JCheckBox("17");
	JCheckBox eighteen = new JCheckBox("18");
	JCheckBox nineteen = new JCheckBox("19");
	JCheckBox twenty = new JCheckBox("20");
	JCheckBox twentyOne = new JCheckBox("21");
	JCheckBox twentyTwo = new JCheckBox("22");
	JCheckBox twentyThree = new JCheckBox("23");
	JCheckBox twentyFour = new JCheckBox("24");
	JCheckBox twentyFive = new JCheckBox("25");
	JCheckBox twentySix = new JCheckBox("26");
	JCheckBox twentySeven = new JCheckBox("27");
	JCheckBox twentyEight = new JCheckBox("28");
	JCheckBox twentyNine = new JCheckBox("29");
	JCheckBox thirty = new JCheckBox("30");
	JCheckBox fourty = new JCheckBox("40");
	JLabel intro=new JLabel("6 numbers will be selected at random. Please select which 6 numbers you think it will be between 0-30"); //intro and directions
	JLabel warning=new JLabel("Select Carefully you may only select once!");
	JMenuBar mainBar=new JMenuBar(); //menu bar 
	JMenu file=new JMenu("File");
	JMenuItem about=new JMenuItem("about");
	JCheckBox boxArray[]={zero, one, two, three, four, five, six, seven, eight, nine,ten,eleven,twelve, thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen,twenty,twentyOne,twentyTwo,twentyThree,twentyFour,twentyFive,twentySix,twentySeven,twentyEight,twentyNine,thirty};
	//array of jcheckboxes
	public Integer[] getIndex() //Method to create an array of random numbers 0-30 that do not repeat
	{
	Integer[] arr=new Integer[31];
    	for (int ii=0; ii<arr.length; ++ii)
    	{
    		arr[ii]=ii;
       
    	}
    	Collections.shuffle(Arrays.asList(arr));
    	return arr;
	}
	Integer indexArray[]=getIndex();
	int count=0;
	int selected;
	int matches=0;
	int result1=indexArray[1]; //six random numbers
	int result2=indexArray[2];
	int result3=indexArray[3];
	int result4=indexArray[4];
	int result5=indexArray[5];
	int result6=indexArray[6];
	int resultArray[]={result1,result2,result3,result4,result5,result6}; //random numbers in array
	int guessArray[]=new int[6];
	int numCorrect=0;
	JLabel results=new JLabel("\n"); //hide results initially
	JLabel userGuesses=new JLabel("Select Your guesses!\n");
	JLabel correct=new JLabel(" ");
	
	

	
	
	
	public JLottery2()
	{
		super("JLottery2");
		add(mainBar);
		mainBar.add(file);
		file.add(about);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //added everything to frame
		setLayout(new FlowLayout());
		add(intro);
		add(warning);
		add(results);
		add(userGuesses);
		add(correct);
		about.addActionListener(this); //action listener to about in menu
		for (int i=0; i<boxArray.length; ++i)
		{
			add(boxArray[i]);
			boxArray[i].addItemListener(this); //added itemlisteners to all the buttons
		}
		
		

		
		
	}
	public void itemStateChanged(ItemEvent event)
	{		
		for (int v=0; v<boxArray.length; ++v) //find which box is selected and once it is selected disable it and set it to an unreachable number
		{
			if(boxArray[v].isSelected())
			{
				boxArray[v].setEnabled(false);
				selected=v;
				boxArray[v]=fourty;
	
			}
		}
		guessArray[count]=selected; //added checked box to guess array
		
		++count; //added to count to limit 6 guesses
		
		if (count>5) //code following executes after the 6 guesses have been made
		{
			for (int b=0; b<guessArray.length; ++b)
			{
				for (int n=0; n<resultArray.length; ++n)
					{
						if (guessArray[b]==resultArray[n]) //check for matches between random and guess arrays
						{
							numCorrect++; //add to match total if matches are found
						}
					}
			}
			if (numCorrect==0 || numCorrect==1 || numCorrect==2) //display reward
			{
				correct.setText("Your reward is 0$");
			}
			else if (numCorrect==3)
			{
				correct.setText("Your reward is 100$");
			}
			else if (numCorrect==4)
			{
				correct.setText("Your reward is 10,000$");
			}
			else if (numCorrect==5)
			{
				correct.setText("Your reward is 50,000$");
			}
			else
			{
				correct.setText("Your reward is 1,000,000");
			}
			results.setText("The Randomly Selected numbers were "+ result1 + " "+result2+ " "+result3+" "+result4+" "+result5+ " "+result6+ " "); //display randomly selected numbers
			
			for (int j=0; j<boxArray.length; j++)
			{
				boxArray[j].setEnabled(false); //make it so no more numbers can be selected after 6 numbers have been picked
				userGuesses.setText("Your guesses were "+guessArray[0]+ " "+guessArray[1]+ " " + guessArray[2]+ " "+ guessArray[3]+ " " + guessArray[4]+ " "+ guessArray[5] + "\n"); //display guesses
				
				
			}
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		//For about
		Object aboutSource=e.getSource();
		if (aboutSource==about)
		{
			JOptionPane.showMessageDialog(null, "Michael Feldt"); //display info when about selected
		}
	}
}

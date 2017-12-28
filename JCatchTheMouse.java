//Author:Michael Feldt
//Date: 12/27/16
//JCatchTheMouse is a application that displays a frame where one box is checked with an X the user then presses the X. When pressed the X changes to a different box. The goal is to get 10 boxes pressed correctly
//Once 10 boxes have been pressed correctly stats are displayed about the game.
import javax.swing.*; //import needed packages
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class JCatchTheMouse extends JFrame implements ActionListener {

	public static void main(String[] args)
	{
		JCatchTheMouse frame=new JCatchTheMouse();
		frame.setVisible(true);
		frame.setSize(600,250);
	}
	JButton one = new JButton(""); //added buttons
	JButton two = new JButton("");
	JButton three = new JButton("");
	JButton four = new JButton("");
	JButton five = new JButton("");
	JButton six = new JButton("");
	JButton seven = new JButton("");
	JButton eight = new JButton("");
	JButton nine = new JButton("");
	JButton ten = new JButton("");
	JButton eleven = new JButton("");
	JButton twelve = new JButton("");
	JButton thirteen = new JButton("");
	JButton fourteen = new JButton("");
	JButton fifteen = new JButton("");
	JButton sixteen = new JButton("");
	JButton seventeen = new JButton("");
	JButton eighteen = new JButton("");
	JButton nineteen = new JButton("");
	JButton twenty = new JButton("");
	JButton twentyOne = new JButton("");
	JButton twentyTwo = new JButton("");
	JButton twentyThree = new JButton("");
	JButton twentyFour = new JButton("");
	JButton twentyFive = new JButton("");
	JButton twentySix = new JButton("");
	JButton twentySeven = new JButton("");
	JButton twentyEight = new JButton("");
	JButton twentyNine = new JButton("");
	JButton thirty = new JButton("");
	JButton thirtyOne = new JButton("");
	JButton thirtyTwo = new JButton("");
	JButton thirtyThree = new JButton("");
	JButton thirtyFour = new JButton("");
	JButton thirtyFive = new JButton("");
	JButton thirtySix = new JButton("");
	JButton thirtySeven = new JButton("");
	JButton thirtyEight = new JButton("");
	JButton thirtyNine = new JButton("");
	JButton forty = new JButton("");
	JButton fortyOne = new JButton("");
	JButton fortyTwo = new JButton("");
	JButton fortyThree = new JButton("");
	JButton fortyFour = new JButton("");
	JButton fortyFive = new JButton("");
	JButton fortySix = new JButton("");
	JButton fortySeven = new JButton("");
	JButton fortyEight = new JButton("");
	
	JButton blankbuttons[] = { one, two, three, four, five, six, seven, eight, nine,ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen,seventeen, eighteen, nineteen, twenty, twentyOne, twentyTwo,twentyThree, twentyFour, 
			twentyFive, twentySix, twentySeven,twentyEight, twentyNine, thirty, thirtyOne, thirtyTwo, thirtyThree,thirtyFour, thirtyFive, thirtySix, thirtySeven, thirtyEight,thirtyNine, forty, fortyOne, fortyTwo, fortyThree, fortyFour,
			fortyFive, fortySix, fortySeven, fortyEight }; //button array for easy addition to frame
	JLabel intro=new JLabel("Locate and press the X as fast as you can!");
	JLabel congrats=new JLabel("");
	JLabel ratio=new JLabel("");
	JLabel info=new JLabel(""); //labels for before and after 10 correct
	double correct;
	double total;
	Random rand=new Random();
	int randValue=rand.nextInt(49);
	int newRand; //random index for button array
	
	
	public JCatchTheMouse()
	{
		super("JCatchTheMouse");
		setLayout(new FlowLayout());
		add(intro);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(congrats);
		add(ratio);
		add(info);
		
		for (int i=0; i<blankbuttons.length; ++i)
		{
			add(blankbuttons[i]);
			blankbuttons[i].addActionListener(this); //action listeners for all buttons
		}
		blankbuttons[randValue].setText("X"); //set X on value of random index
		newRand=randValue; //stored index
	}
	public void actionPerformed(ActionEvent e)
	{
		++total; //anytime button pressed total incremented
		Object buttonSelected=e.getSource();
		if (buttonSelected==blankbuttons[newRand])
		{
			++correct;
			blankbuttons[newRand].setText(""); //when correct button pressed set it back to blank and added to correct total
			Random rand=new Random();
			int randValue=rand.nextInt(49);
			blankbuttons[randValue].setText("X"); //new random index is found and X is assigned to that button
			newRand=randValue; //stored value
		}
		
		if (correct>9)
		{
			for (int j=0; j<blankbuttons.length; ++j)
			{
				blankbuttons[j].setVisible(false); //removed buttons after 10 correct
			}
			double ratioValue=(correct/total); //ratio
			ratioValue=ratioValue*100; //percentage 
			long percentValue=Math.round(ratioValue);//rounded
			ratio.setText("Your percentage of correct hits is " +percentValue);
			congrats.setText("You hit " +correct+ " in " + total+ " clicks"); //congrats and info labels
			intro.setText("Great Job!!");
			info.setText("\nAuthor:Michael Feldt || Date: 12/27/16 ");
			
		}
	}
}

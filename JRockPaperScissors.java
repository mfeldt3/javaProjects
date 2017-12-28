//Author:Michael Feldt
//Date: 12/27/16
// JRockPaperScissors uses a Applet to play rock paper scissors between a user and PC. The results are kept and displayed after each round.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class JRockPaperScissors extends JApplet implements ActionListener  {

	JButton rock=new JButton("Rock");
	JButton scissors=new JButton("Scissors");
	JButton paper=new JButton("Paper");
	JLabel rps=new JLabel("Rock, Paper, Scissors");
	Font titleFont=new Font("Arial", Font.BOLD, 40);
	JLabel select=new JLabel("Select one button");
	JLabel results=new JLabel("--------Results--------");
	JLabel gameResults=new JLabel("");
	JLabel winner=new JLabel("");
	JLabel stats=new JLabel("");
	int user;
	int pcWins=0;
	int userWins=0;
	int tie=0;
	String userSelect;
	String pcSelect;
	String whoWon;
	public void init()
	{
		setLayout(new FlowLayout()); //added to applet set size and added actionListeners
		add(rps);
		rps.setFont(titleFont);
		add(select);
		add(rock);
		add(scissors);
		add(paper);
		add(results);
		results.setFont(titleFont);
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
		add(gameResults);
		add(winner);
		add(stats);
		setSize(430,300);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Random num=new Random();
		int number=num.nextInt(3);
		if (number==0) //Created random number 0=2 as the pc's rock paper or scissors;
		{
			pcSelect="rock"; //Gave name to each value
		}
		if (number==1)
		{
			pcSelect="paper";
		}
		if (number==2)
		{
			pcSelect="scissors";
		}
	
		Object source=e.getSource();
		if (source==rock) //found if source was rock paper or scissors and assigned it an int value to compare with pc pick
		{
			user=0;
			userSelect="rock";
		}
		else if (source==paper) //0-rock 1-paper 2- scissors
		{
			user=1;
			userSelect="paper";
		}
		else if (source==scissors)
		{
			user=2;
			userSelect="scissors";
		}
		if (user==number) //found who won and incremented it to the total or if tie incremented it to tie total
		{
			++tie;
			whoWon="No one";
		}
		else if(user==0 && number==2)
		{
			++userWins;
			whoWon="User";
		}
		else if (user==0 && number==1)
		{
			++pcWins;
			whoWon="Computer";
		}
		else if(user==1 && number==2)
		{
			++pcWins;
			whoWon="Computer";
		}
		else if(user==1 && number==0)
		{
			++userWins;
			whoWon="User";
		}
		else if(user==2 && number==0)
		{
			++pcWins;
			whoWon="Computer";
		}
		else if(user==2 && number==1)
		{
			++userWins;
			whoWon="User";
		}
		gameResults.setText("You chose " + userSelect + " ----- the computer selected "+ pcSelect + "                            "); //displayed who selected what and who won
		winner.setText("Winner " + whoWon);
		stats.setText("You: " + userWins + "  Computer: " + pcWins + "  Ties: "+ tie); //tally of total results
	}
	
	public void paint(Graphics g) //Drawstring to draw info in bottom left corner of applet
	{
		super.paint(g);
		String name="Michael Feldt";
		
		
		g.drawString(name, 20,270);
	}
}

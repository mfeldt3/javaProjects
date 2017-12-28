//Author:Michael Feldt
//Date: 12/12/16
// JSmileFace2 is a program which uses JFrame to display a smiley face that can be turned into a sad face with a JButton press. 
import javax.swing.*; //import needed packages
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class JSmileFace2 extends JFrame implements ActionListener {
	public static void main(String[] args)
	{
		JSmileFace2 frame=new JSmileFace2();
		frame.setVisible(true);
		frame.setSize(800,400);
	}
	JButton button=new JButton("Make me sad");
	int i=0; //Count
	
	public JSmileFace2()
	{
		super("Smile Face");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(button);
		button.addActionListener(this); //added action listener
		
	}
	public void paint(Graphics gr)
	{
		super.paint(gr);
		gr.setColor(Color.YELLOW);
		gr.fillOval(35, 35, 350, 350); //added circle face
		gr.setColor(Color.BLACK);
		gr.fillOval(150, 150, 50, 50); //added eyes
		gr.fillOval(225, 150, 50, 50);
		gr.setColor(Color.WHITE);
		if (i%2==0) //added count to change happy and frowny face based on click
		{
		gr.fillArc(140, 170, 150, 125, 0, -180); //happy
		}
		else
		{
		gr.setColor(Color.RED);
		gr.fillArc(140, 225, 150, 125, 0, 180); //sad
		}
	}
	public void actionPerformed(ActionEvent ev)
	{
		++i; //added to count
		repaint(); //to to repaint
	}
}

//Author:Michael Feldt
//Date: 12/5/16
//JLeftorRight displays a frame where mouse clicks are registered. It then shows what integer is registered on each mouse click.
import javax.swing.*; //import needed packages
import java.awt.Color.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class JLeftOrRight extends JFrame implements MouseListener {
	public static void main(String[] args)
	{
		JLeftOrRight frame=new JLeftOrRight();
		frame.setVisible(true);
		frame.setSize(300,200);
	}
	
	
	JLabel label=new JLabel("click a mouse button!");
	
	public JLeftOrRight()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(label);
		addMouseListener(this); //added mouseListener
		setLayout(new FlowLayout());
	}
	
	public void mouseClicked(MouseEvent e)
	{
		int i=e.getModifiers();
		if (i==MouseEvent.BUTTON1_MASK)
		{
		label.setText("The Integer for left click is " + i); //Set label text to left click value
		}
		else if (i==MouseEvent.BUTTON2_MASK)
		{
			label.setText("The Integer  for middle mouse click is " + i); //middle mouse click + value displayed
		}
		else if (i==MouseEvent.BUTTON3_MASK)
		{
			label.setText("The Integer for right mouse click is " + i); //Right mouse click + value displayed
		}
	}
	
	public void mouseEntered(MouseEvent e) {} //added other events so class would run
	public void mouseExited(MouseEvent e)	{}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
		
}
/*Write an application that lets you determine the integer value returned by the InputEvent method getModifiers() 
 * when you click your left, right, or—if you have one—middle mouse button on a JFrame. Save the file as JLeftOrRight.java.
 * */

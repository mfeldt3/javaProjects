//Name:Michael Feldt
//Date: 12/19/16
//JPasswordC is a Applet that takes a user input for a password if the password is correct the background changes to green if not it changes to red.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class JPasswordC extends JApplet implements ActionListener {
 
	JLabel question=new JLabel("Please enter the password");
	JTextField text=new JTextField(10);
	Container con=getContentPane();
	public void init()
	{
		setLayout(new FlowLayout());
		add(question);
		add(text);
		text.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String input=text.getText();
		String[] valid={"Rosebud", "Redrum", "Jason", "Surrender","Dorthy"}; //array of possible answers
		
	for (int i=0; i<valid.length; ++i) //loop to loop through possible results
	{
		
		if (input.equals(valid[i])) //if input equals value break loop and grant access if not keep looping
		{
			question.setText("Access Granted");
			con.setBackground(Color.GREEN);
			break;
		}
		else
		{
			question.setText("Access Denied");
			con.setBackground(Color.RED);
		}
	}
	}
}

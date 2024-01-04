import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PytanieObliczeniowe extends JPanel implements PytanieTestowe{
	int result;
	JTextField tf;
	public PytanieObliczeniowe(String s)throws NoGoodAnswerException
	{
		String[] lines = s.split("\n");
		setLayout(new GridLayout(lines.length+3,1));
		JLabel l1=new JLabel(" "+lines[0]);
		add(l1);
		result=Integer.parseInt(lines[1]);
		tf=new JTextField(10);
		add(tf);
	}
	public double returnPoints()
	{
		try
		{
			if(Integer.parseInt(tf.getText())==result)
			{
				return 1;
			}
		}
		catch(NumberFormatException nfe)
		{
			System.out.println(nfe.toString());
		}
		return 0;
	}
	public void randomAnswers()
	{
		tf.setText("");
	}
}

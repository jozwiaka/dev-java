import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

public class PytanieWielokrotnegoWyboru extends JPanel implements PytanieTestowe{
	int points[]=new int[5];
	String answers[]=new String[5];
	MyRadioButton b[]=new MyRadioButton[5];
	List<Odpowiedz> odpowiedzi=new ArrayList<>();
	public PytanieWielokrotnegoWyboru(String s) throws NoGoodAnswerException,TooManyAnswersException
	{
//		SpringLayout layout = new SpringLayout();
//		setLayout(layout);
		String[] lines = s.split("\n");
		if(lines.length-1>5)throw new TooManyAnswersException("Too many answers in question: "+lines[0]);
		setLayout(new GridLayout(lines.length,1));
		for(int j=1;j<lines.length;j++)
		{
			String valstr[] = lines[j].split("\t");
			points[j-1]=Integer.parseInt(valstr[0]);
			answers[j-1]=valstr[1];
			b[j-1] = new MyRadioButton(answers[j-1]);
			b[j-1].value=points[j-1];
			odpowiedzi.add(b[j-1]);
		}


		JLabel l1=new JLabel(" "+lines[0]);
		add(l1);
		randomAnswers();
		int points0=0;
		for(int i=0;i<points.length;i++)
			{
				if(points[i]==0)points0++;
			}
		if(points0==points.length) {
			throw new NoGoodAnswerException("No good answer in the question: "+lines[0]);
		}
				
	}
	public double returnPoints()
	{
		int points1=0;
		int points0=0;
		double myPoints=0;
		for(int i=0;i<odpowiedzi.size();i++)
		{
			//System.out.println(b[i].value);
			if(b[i].value==0)points0++;
			if(b[i].value==1)points1++;
		}
		for(int i=0;i<odpowiedzi.size();i++)
		{
			if(b[i].isSelected())
			{
				if(b[i].value==0)myPoints-=(double)1/points0;
				if(b[i].value==1)myPoints+=(double)1/points1;
			}
		}
		if(myPoints<0)return 0;
		if(myPoints>1)return 1;
		return myPoints;
	}
	public void randomAnswers()
	{
		Collections.shuffle(odpowiedzi);
		for (Odpowiedz o:odpowiedzi)
        {
			MyRadioButton mb=(MyRadioButton)o;
			mb.setSelected(false);
			add(mb);
        }
	}

}

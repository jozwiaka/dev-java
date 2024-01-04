
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

public class Okno extends JFrame
{
	PytanieJednokrotnegoWyboru pjw[];
	PytanieWielokrotnegoWyboru pww[];
	PytanieObliczeniowe po[];
	int ipjw=0;
	int ipww=0;
	int ipo=0;
	List<PytanieTestowe> listaPytan = new ArrayList<>();
	public Okno() throws IOException
	{
		Container c = getContentPane();
		setSize(new Dimension(450,800));
		SpringLayout layout = new SpringLayout();
		c.setLayout(layout);
		
		Test test=new Test();
		String s;
		s=test.read();
		String[] sl;
		sl=s.split("\n\n");
		for(int i=0;i<sl.length;i++)
		{
			if(sl[i].startsWith("MCQ"))ipww++;
			if(sl[i].startsWith("SCQ"))ipjw++;
			if(sl[i].startsWith("CAL"))ipo++;
		}
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(ipww+ipjw+ipo,1));
		PytanieJednokrotnegoWyboru pjw[]=new PytanieJednokrotnegoWyboru[ipjw];
		PytanieWielokrotnegoWyboru pww[]=new PytanieWielokrotnegoWyboru[ipww];
		PytanieObliczeniowe po[]=new PytanieObliczeniowe[ipo];
		ipjw=0;
		ipww=0;
		ipo=0;
		for(int i=0;i<sl.length;i++)
		{
			if(sl[i].startsWith("MCQ"))
			{
				sl[i]=sl[i].replace("MCQ\t","");
				pww[ipww]=new PytanieWielokrotnegoWyboru(sl[i]);
				listaPytan.add(pww[ipww]);
				ipww++;
			}
			if(sl[i].startsWith("SCQ"))
			{
				sl[i]=sl[i].replace("SCQ\t","");
				pjw[ipjw]=new PytanieJednokrotnegoWyboru(sl[i]);
				listaPytan.add(pjw[ipjw]);
				ipjw++;
			}
			if(sl[i].startsWith("CAL"))
			{
				sl[i]=sl[i].replace("CAL\t","");
				po[ipo]=new PytanieObliczeniowe(sl[i]);
				listaPytan.add(po[ipo]);
				ipo++;
			}
			
		}
//		PytanieJednokrotnegoWyboru pjw = new PytanieJednokrotnegoWyboru("aa");
//		PytanieWielokrotnegoWyboru pww = new PytanieWielokrotnegoWyboru("");
//		PytanieObliczeniowe po=new PytanieObliczeniowe("");
		Collections.shuffle(listaPytan);
		for (PytanieTestowe pt:listaPytan)
        {
			JPanel p=(JPanel)pt;
			p.setPreferredSize(new Dimension(400,200));
            p1.add(p);
        }
		Font myFont = new Font("Serif", Font.BOLD, 25);
		JButton b1 = new JButton("End Test");
		JButton b2 = new JButton("Try Again");
		b1.setFont(myFont);
		b2.setFont(myFont);
		
		JLabel l1 = new JLabel("Result: ");
		JLabel l2 = new JLabel("");
		l1.setFont(myFont);
		l2.setFont(myFont);
		
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2,2));
		p2.add(b1);
		p2.add(b2);
		p2.add(l1);
		p2.add(l2);
		JScrollPane sp1=new JScrollPane(p1);
		sp1.setPreferredSize(new Dimension(400,600));
		c.add(sp1);
		c.add(p2);
		
		 //constraints
        layout.putConstraint(SpringLayout.WEST, sp1,5,SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, sp1,5,SpringLayout.NORTH, c);
        
        layout.putConstraint(SpringLayout.WEST, p2,5,SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, p2,10,SpringLayout.SOUTH, sp1);
        
        b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double points=0;
				for (PytanieTestowe pt:listaPytan)
                {
        			points+=pt.returnPoints();
                }
				l2.setText(Double.toString(points)+"/"+(double)listaPytan.size());
			}
        
        });
        b2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
        		c.remove(sp1);
        		p1.removeAll();
        		Collections.shuffle(listaPytan);
        		for (PytanieTestowe pt:listaPytan)
                {
        			pt.randomAnswers();
        			JPanel p=(JPanel)pt;
        			p.setPreferredSize(new Dimension(400,200));
        			p1.add(p);
                }
        		c.add(sp1);
        		l2.setText("");
        		revalidate();
        	}
        	});
		
        //pack();
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
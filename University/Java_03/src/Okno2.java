import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Okno2 extends JFrame
{
	private JTextField text[][];
	
	public Okno2()
	{
		//text - alokacja
		text = new JTextField[2][2];
		
		//tytul i rozmiar okna
		setTitle("Pierwsze okno");
		setSize(new Dimension(300,150));
		
		//c
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//panel1
		JPanel panel1 = new JPanel();
		c.add(panel1,BorderLayout.CENTER);
		panel1.setLayout(new GridLayout(2,2));
		panel1.add(text[0][0] = new JTextField());
		panel1.add(text[0][1] = new JTextField());
		panel1.add(text[1][0] = new JTextField());
		panel1.add(text[1][1] = new JTextField());
		
		//panel2
		JPanel panel2 = new JPanel();
		c.add(panel2,BorderLayout.SOUTH);
		panel2.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		//button1
		JButton button1 = new JButton("Oblicz");
		panel2.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				double tab[][] = new double[2][2];
				for(int i=0;i<2;i++)
				{
					for(int j=0;j<2;j++)
					{
						tab[i][j]=Double.parseDouble(text[i][j].getText());
					}
				}
				Macierz macierz = new Macierz(tab);
				JOptionPane.showMessageDialog(new JFrame(),"Wyznacznik wynosi: " + macierz.dajWyznacznik());
			}
		});
		
		//button2
		JButton button2 = new JButton("Transponuj");
		panel2.add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String text_T[][] = new String[2][2];
				for(int i=0;i<2;i++)
				{
					for(int j=0;j<2;j++)
					{
						text_T[i][j] = text[j][i].getText();
					}
				}
				
				for(int i=0;i<2;i++)
				{
					for(int j=0;j<2;j++)
					{
						text[i][j].setText(text_T[i][j]);
					}
				}
			}
		});
		
		//button3
		JButton button3 = new JButton("Zsumuj");
		panel2.add(button3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int suma = 0;
				for(int i=0;i<2;i++)
				{
					for(int j=0;j<2;j++)
					{
						suma+=Double.parseDouble(text[i][j].getText());
					}
				}
				JOptionPane.showMessageDialog(new JFrame(),"Suma elementow macierzy "
						+ "wynosi: "+suma);
			}
		});
		
		//Visible + EXIT_ON_CLOSE
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

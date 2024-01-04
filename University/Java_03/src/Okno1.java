import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Okno1 extends JFrame
{
	JTextField imie;
	JTextField nazwaKierunku;
	
	Okno1()
	{
		setTitle("Pierwsze okno");
		setSize(new Dimension(420,210));
		imie = new JTextField(10);
		nazwaKierunku = new JTextField(10);
		
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.add(new JLabel("Imie"));
		c.add(imie);
		c.add(new JLabel("Kierunek"));
		c.add(nazwaKierunku);
		
		JButton button = new JButton("Pokaz");
		c.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame frame = new JFrame();
				String string = "Czesc " + Okno1.this.imie.getText() +
				" studiujacy na kierunku " + Okno1.this.nazwaKierunku.getText() + "!";
				JOptionPane.showMessageDialog(frame,string);
			}
		});
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

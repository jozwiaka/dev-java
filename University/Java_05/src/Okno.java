import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Okno extends JFrame
{
	private JComboBox cbArray[];
	private Rezystor rArray[];
	
	Color allColors[][]=new Color[30][6];
	Kolor allKolors[][]=new Kolor[30][6];
	int alliLoscWlaczonychCB[]=new int[30];
	
	private int iloscWlaczonychCB=0;
	int iloscZapamietanych=0;
	//String RV="";
	public Okno()
	{
		Container c = getContentPane();
		String[] titles={"1st Color","2nd Color","3rd Color",
				"Multiplier","Tolerance","PPM"};
		JLabel ResistorValue=new JLabel();
		Rezystor rTemp[]=new Rezystor[2];
		rTemp[0]= new Rezystor();
		rTemp[1]= new Rezystor();
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		c.setLayout(gridBag);
		
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout());
		
		JPanel p2a=new JPanel();
		p2a.setLayout(new GridLayout(12,1));
		
		JPanel p2b=new JPanel();
		p2b.setLayout(new GridLayout(2,1));
		
		JPanel p2bRezystor=new JPanel();
		p2bRezystor.setLayout(new GridBagLayout());
		
		
		JPanel p3=new JPanel();
		p3.setPreferredSize(new Dimension(800,700));
		p3.setLayout(new FlowLayout());
		
		Kolor k0=new Kolor(Color.lightGray,"","");
		Vector<Kolor> kolory123 = new Vector<Kolor>();
		kolory123.add(new Kolor(Color.lightGray,"",""));
		kolory123.add( new Kolor( Color.white, "White","0" ));
		kolory123.add( new Kolor( Color.red, "Red", "1" ));
		kolory123.add( new Kolor( Color.blue, "Blue","2" ));
		kolory123.add( new Kolor( Color.yellow, "Yellow","3" ));
		kolory123.add( new Kolor( Color.pink, "Pink","4" ));
		kolory123.add( new Kolor( Color.green, "Green","5" ));
		kolory123.add( new Kolor( Color.orange, "Orange","6" ));
		kolory123.add( new Kolor( Color.GRAY, "Gray","7" ));
		kolory123.add( new Kolor( Color.cyan, "Cyan","8" ));
		kolory123.add( new Kolor( Color.magenta, "Magenta","9" ));
		
		Vector<Kolor> kolory4 = new Vector<Kolor>();
		kolory4.add(new Kolor(Color.lightGray,"",""));
		kolory4.add( new Kolor( Color.white, "White","x1 Ohm" ));
		kolory4.add( new Kolor( Color.red, "Red", "x10 Ohm" ));
		kolory4.add( new Kolor( Color.blue, "Blue","x100 Ohm" ));
		kolory4.add( new Kolor( Color.yellow, "Yellow","x1 kOhm" ));
		kolory4.add( new Kolor( Color.pink, "Pink","x10 kOhm" ));
		kolory4.add( new Kolor( Color.green, "Green","x100 kOhm" ));
		kolory4.add( new Kolor( Color.orange, "Orange","x1 MOhm" ));
		kolory4.add( new Kolor( Color.GRAY, "Gray","x10 MOhm" ));
		kolory4.add( new Kolor( Color.cyan, "Cyan","x100 MOhm" ));
		kolory4.add( new Kolor( Color.magenta, "Magenta","x1 GOhm" ));
		
		Vector<Kolor> kolory5 = new Vector<Kolor>();
		kolory5.add(new Kolor(Color.lightGray,"",""));
		kolory5.add( new Kolor( Color.white, "White","+-1%" ));
		kolory5.add( new Kolor( Color.red, "Red", "+-2%" ));
		kolory5.add( new Kolor( Color.blue, "Blue","+-0.5%" ));
		kolory5.add( new Kolor( Color.yellow, "Yellow","+-0.25%" ));
		kolory5.add( new Kolor( Color.pink, "Pink","+-0.1" ));
		kolory5.add( new Kolor( Color.green, "Green","+-0.05" ));
		kolory5.add( new Kolor( Color.orange, "Orange","+-5%" ));
		kolory5.add( new Kolor( Color.GRAY, "Gray","+-10" ));
		
		Vector<Kolor> kolory6 = new Vector<Kolor>();
		kolory6.add(new Kolor(Color.lightGray,"",""));
		kolory6.add( new Kolor( Color.white, "White","100 ppm" ));
		kolory6.add( new Kolor( Color.red, "Red", "50 ppm" ));
		kolory6.add( new Kolor( Color.blue, "Blue","15 ppm" ));
		kolory6.add( new Kolor( Color.yellow, "Yellow","25 ppm" ));
		kolory6.add( new Kolor( Color.pink, "Pink","10 ppm" ));
		kolory6.add( new Kolor( Color.green, "Green","5 ppm" ));
		
		//Tworze CB i Rezystory
		rArray = new Rezystor[6];
		cbArray = new JComboBox[6];
		
		for(int index=0;index<cbArray.length;index++)
		{
			final int i=index;
			rArray[i]=new Rezystor();
			if(i<3)cbArray[i]=new JComboBox<Kolor>(kolory123);
			if(i==3)cbArray[i]=new JComboBox<Kolor>(kolory4);
			if(i==4)cbArray[i]=new JComboBox<Kolor>(kolory5);
			if(i==5)cbArray[i]=new JComboBox<Kolor>(kolory6);
			
			cbArray[i].setPreferredSize(new Dimension(200,40));
			Kolor k = (Kolor)cbArray[i].getSelectedItem();
			cbArray[i].setBackground(k.getColor());
			
			//Change colors of CB and R, after CB change
			cbArray[i].addActionListener( e->{
				Kolor k1 = (Kolor)cbArray[i].getSelectedItem();
				rArray[i].setColor( k1.getColor() );
				cbArray[i].setBackground(k1.getColor());
				if(i==2)
				{
					if(rArray[i].getColor()!=Color.lightGray)
					rTemp[0].setColor(rArray[i].getColor());
				}
				if(i==5)
				{
					if(rArray[i].getColor()!=Color.lightGray)
					rTemp[1].setColor(rArray[i].getColor());
				}
			});
//				cbArray[i].addItemListener(new ItemListener(){
//				public void itemStateChanged(ItemEvent event)
//				    {}
//				});
			
			//Color CB
			cbArray[i].setRenderer(new ColorRenderer(this));
			p2a.add(new JLabel(titles[i]));
			p2a.add(cbArray[i]);
			p2bRezystor.add(rArray[i]);
		}
		
		//4 CB wlaczone na start
		iloscWlaczonychCB=4;
		cbArray[2].setEnabled(false);
		cbArray[5].setEnabled(false);
		
		//RadioButtons
		JRadioButton b4 = new JRadioButton("4");
		b4.setSelected(true);
		JRadioButton b5 = new JRadioButton("5");
		JRadioButton b6 = new JRadioButton("6");
		ButtonGroup group = new ButtonGroup();
		group.add(b4);
		group.add(b5);
		group.add(b6);
		
		class RadioButtonsEventHandler implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton button = (JRadioButton) e.getSource();
				iloscWlaczonychCB = Integer.parseInt(button.getText());

				if(iloscWlaczonychCB==4)
				{
					cbArray[2].setEnabled(false);
					rArray[2].setColor(Color.lightGray);
					cbArray[5].setEnabled(false);
					rArray[5].setColor(Color.lightGray);
				}
				if(iloscWlaczonychCB==5)
				{
					cbArray[2].setEnabled(true);
					rArray[2].setColor(rTemp[0].getColor());
					cbArray[5].setEnabled(false);
					rArray[5].setColor(Color.lightGray);
				}
				if(iloscWlaczonychCB==6)
				{
					cbArray[2].setEnabled(true);
					rArray[2].setColor(rTemp[0].getColor());
					cbArray[5].setEnabled(true);
					rArray[5].setColor(rTemp[1].getColor());
				}
			}	
		}
		b4.addActionListener(new RadioButtonsEventHandler());
		b5.addActionListener(new RadioButtonsEventHandler());
		b6.addActionListener(new RadioButtonsEventHandler());
		
		//JTable
		JTable table = new JTable() {
	        public boolean isCellEditable(int x, int y) {
	            return false;
	        }};
		DefaultTableModel dtm=new DefaultTableModel(titles,0);
		table.setModel(dtm);
		table.setRowHeight(30);
		for(int i=0;i<6;i++)
		{
		table.getColumnModel().getColumn(i).setPreferredWidth(200);
		}
		//table.getColumnModel().getColumn(i).setCellRenderer(new BoardTableCellRenderer(this));
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
		        {
		           for(int i=0;i<6;i++)
		           {
		        	   rArray[i].setColor(allColors[row][i]);
		        	   cbArray[i].setSelectedItem(allKolors[row][i]);
		           }
		           if(alliLoscWlaczonychCB[row]==4)
		           {
		        	   cbArray[2].setEnabled(false);
		        	   cbArray[5].setEnabled(false);
		        	   b4.setSelected(true);
		           }
		           if(alliLoscWlaczonychCB[row]==5)
		           {
		        	   cbArray[2].setEnabled(true);
		        	   cbArray[5].setEnabled(false);
		        	   b5.setSelected(true);   
		           }
		           if(alliLoscWlaczonychCB[row]==6)
		           {
		        	   cbArray[2].setEnabled(true); 
		        	   cbArray[5].setEnabled(true);
		        	   b6.setSelected(true);
		           }
		        }
		    }
		});

		JPanel pTable = new JPanel();
		JScrollPane jsp= new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(800,700));
		pTable.add(jsp);
		
		JButton bZapamietaj=new JButton("Zapamietaj");
		bZapamietaj.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Color colors[]=new Color[6];
				Kolor kolory[]=new Kolor[6];
				for(int i=0;i<6;i++)
				{
					Kolor k = (Kolor)cbArray[i].getSelectedItem();
					if(iloscWlaczonychCB==4)
					{
						if(i==2)
						{
							colors[i]=k0.getColor();
							kolory[i]=k0;
							continue;	
						}
						if(i==5)
						{
							colors[i]=k0.getColor();
							kolory[i]=k0;
							continue;
						}
					}
					if(iloscWlaczonychCB==5)
					{
						if(i==5)
						{
							colors[i]=k0.getColor();
							kolory[i]=k0;
							continue;
						}
					}
					colors[i]=k.getColor();
					kolory[i]=k;
					
				}
				
				allKolors[iloscZapamietanych]=kolory;
				allColors[iloscZapamietanych]=colors;
				alliLoscWlaczonychCB[iloscZapamietanych]=iloscWlaczonychCB;
				dtm.addRow(new Object[] {kolory[0],kolory[1],kolory[2],kolory[3],kolory[4],kolory[5]});
				iloscZapamietanych++;
			}
		});
		
		
		//p1
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		constraints.gridx = 0;
        constraints.gridy = 0;
		c.add(p1,constraints);
		
		//p2
		p2b.add(new JLabel("Output: "));
		p2b.add(p2bRezystor);
		p2.add(p2a);
		p2.add(p2b);
		constraints.gridx = 0;
		constraints.gridy = 1;
		c.add(p2,constraints);
		
		//p3
		JPanel pZapamietaj = new JPanel();
		pZapamietaj.setLayout(new BorderLayout());
		pZapamietaj.add(bZapamietaj,BorderLayout.SOUTH);
		p3.add(pZapamietaj);
		p3.add(pTable);
		constraints.gridx = 1;
		constraints.gridy = 1;
		c.add(p3,constraints);
		
		//Koncowka
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class ColorRenderer extends JLabel implements ListCellRenderer
{
	private Okno okno;
	public ColorRenderer(Okno okno)
	{
		this.okno=okno;
		this.setOpaque(true);
	}
	public Component getListCellRendererComponent(JList list, Object key, int index,
			boolean isSelected, boolean cellHasFocus)
	{
		
		Kolor kolor = (Kolor)key;
		list.setSelectionBackground(null);
		list.setSelectionForeground(null);
		
		if(isSelected)
		{
			setBorder(BorderFactory.createEtchedBorder());
		}
		else
		{
			setBorder(null);
		}
		setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		setText(""+kolor);
		setBackground(kolor.getColor());
		setForeground(Color.black);
		return this;
	}
}

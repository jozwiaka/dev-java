import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Okno extends JFrame
{
	private String regex="";
	private String input="";
	private Pattern pattern=Pattern.compile("");
	private Matcher matcher=pattern.matcher(input);
	
	int number=1;
	int i=0;
	int columns=0;
	
	boolean bool[]=new boolean[3];
	
	public Okno()
	{
		bool[0]=false;
		bool[1]=false;
		bool[2]=false;
		setSize(new Dimension(800,600));
		//container
		Container c = getContentPane();
		
		//layout
		SpringLayout layout = new SpringLayout();
        c.setLayout(layout);
        
        //textField
        JTextField textField = new JTextField(45);
        
        //checkboxes
        JCheckBox checkBox[]=new JCheckBox[3];
        checkBox[0] = new JCheckBox("\\\\", false); 
        checkBox[1] = new JCheckBox("DOTALL", false); 
        checkBox[2] = new JCheckBox("MULTILINE", false); 
        
        //buttons
        JButton button1 = new JButton("Kopiuj \\");
        JButton button2 = new JButton("Kopiuj \\\\");
        
        //textArea
        JTextArea textArea = new JTextArea(10,45);
        
        //label
        JLabel label = new JLabel("Dopasowany caly tekst: ");
        
        //table
        JTable t = new JTable(); 
        DefaultTableModel dtm = new DefaultTableModel(new Object[] { "#","group(0)"},0);
        t.setModel(dtm);
		
        
        //listeners START------------------------------------------------------------------------------------
        //textField
        textField.getDocument().addDocumentListener(new DocumentListener() {
        	
        	@Override
        	public void insertUpdate(DocumentEvent e)
        	{
        		regex=textField.getText();
        		textField.setBackground(Color.white);
    			try
    			{
    				if(bool[0]==true)
            		{
            			regex=regex.replace("\\\\","\\");
            		}
            		if(bool[1]==false&&bool[2]==false)
            		{
            			pattern=Pattern.compile(regex);        			
            		}
            		if(bool[1]==true&&bool[2]==false)
            		{
            			pattern=Pattern.compile(regex,Pattern.DOTALL);        			
            		}
            		if(bool[1]==false&&bool[2]==true)
            		{
            			pattern=Pattern.compile(regex,Pattern.MULTILINE);        			
            		}
            		if(bool[1]==true&&bool[2]==true)
            		{
            			pattern=Pattern.compile(regex,Pattern.DOTALL|Pattern.MULTILINE);        			
            		}
        		}
    			catch(PatternSyntaxException pse)
    			{
    				textField.setBackground(Color.red);
    				System.out.println(pse.toString());
    			}
    			finally
    			{
    			input=textArea.getText();
        		matcher=pattern.matcher(input);
    			if(matcher.matches())
	        		label.setText("Dopasowany caly tekst: TAK");
	        	else
	        		label.setText("Dopasowany caly tekst: NIE");
    			int groupCount = matcher.groupCount();
    			for(int i=columns;i<groupCount;i++)
    			{
    				columns++;
    				dtm.addColumn("group("+columns+")");
    			}
//    			for(int i=columns;i>groupCount;i--)
//    			{
//    				Vector rows = dtm.getDataVector();
//    		        for (Object row : rows)
//    		        {
//    		            ((Vector)row).remove(i);
//    		        }
//    				System.out.println("columns: "+columns);
//    				System.out.println("groupCount: "+groupCount);
//    				t.removeColumn(t.getColumnModel().getColumn(i));
//    				columns--;
//    			}
    			dtm.fireTableStructureChanged();
    			}
        	}
        	
        	@Override
        	public void removeUpdate(DocumentEvent e) {
        		insertUpdate(e);
        	}
        	
        	@Override
        	public void changedUpdate(DocumentEvent e) {
        		insertUpdate(e);
        	}
        });
        //textArea
        textArea.getDocument().addDocumentListener(new DocumentListener() {
        	
        	@Override
        	public void insertUpdate(DocumentEvent e)
        	{
        		input=textArea.getText();
        		matcher=pattern.matcher(input);
        		int groupCount = matcher.groupCount();
        		int j=0;
        		while(matcher.find())
        		{
        			if(j<i)
    				{
        				j++;
        				continue;
    				}
        			Vector<String> v=new Vector<>();
        			v.add(""+number);
	    			for (int i = 0; i <= groupCount; i++)
	    			{
	                    System.out.println("Group " + i + ": " + matcher.group(i));
	                    v.add(matcher.group(i));
	    			}
	    			dtm.addRow(v);
	    			number++;
	    			i++;
        	    }
        		
    			if(matcher.matches())
	        		label.setText("Dopasowany caly tekst: TAK");
	        		else
	        		label.setText("Dopasowany caly tekst: NIE");
	        		dtm.fireTableStructureChanged();
        	}
        	
        	@Override
        	public void removeUpdate(DocumentEvent e) {
        		insertUpdate(e);
        	}
        	
        	@Override
        	public void changedUpdate(DocumentEvent e) {
        		insertUpdate(e);
        	}
        });
       
        //checkBox
        for(int index=0;index<checkBox.length;index++)
		{
			final int i=index;
			checkBox[i].addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED)
	                {
	                    bool[i]=true;
	                }
	                else 
	                {
	                	bool[i]=false;
	                }
	                regex=textField.getText();
	        		dtm.fireTableStructureChanged();
	        		textField.setBackground(Color.white);
	    			try
	    			{
	    				if(bool[0]==true)
	            		{
	            			regex=regex.replace("\\\\","\\");
	            		}
	            		if(bool[1]==false&&bool[2]==false)
	            		{
	            			pattern=Pattern.compile(regex);        			
	            		}
	            		if(bool[1]==true&&bool[2]==false)
	            		{
	            			pattern=Pattern.compile(regex,Pattern.DOTALL);        			
	            		}
	            		if(bool[1]==false&&bool[2]==true)
	            		{
	            			pattern=Pattern.compile(regex,Pattern.MULTILINE);        			
	            		}
	            		if(bool[1]==true&&bool[2]==true)
	            		{
	            			pattern=Pattern.compile(regex,Pattern.DOTALL|Pattern.MULTILINE);        			
	            		}
	        		}
	    			catch(PatternSyntaxException pse)
	    			{
	    				textField.setBackground(Color.red);
	    				System.out.println(pse.toString());
	    			}
	    			finally
	    			{
	    			input=textArea.getText();
	        		matcher=pattern.matcher(input);
	    			if(matcher.matches())
		        		label.setText("Dopasowany caly tekst: TAK");
		        		else
		        		label.setText("Dopasowany caly tekst: NIE");
		        		dtm.fireTableStructureChanged();
	    			}
	            }
	        });
		}
        //button1
        button1.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String myString = regex;
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
    			
        	}});
        //button2
        button2.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String myString = regex.replace("\\","\\\\");
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
        		
        	}});
        //listeners END--------------------------------------------------------------------------------------------
        //adding
        c.add(textField);
        c.add(checkBox[0]);
        c.add(checkBox[1]);
        c.add(checkBox[2]);
        c.add(button1);
        c.add(button2);
        JScrollPane jsp1 = new JScrollPane(textArea);
        c.add(jsp1);
        c.add(label);
        JScrollPane jsp2 = new JScrollPane(t);
        c.add(jsp2);
 
        //constraints
        layout.putConstraint(SpringLayout.WEST, textField,5,SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, textField,5,SpringLayout.NORTH, c);
        
        layout.putConstraint(SpringLayout.WEST, checkBox[0],5,SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, checkBox[0],25,SpringLayout.NORTH,textField );
        
        layout.putConstraint(SpringLayout.WEST, checkBox[1],20,SpringLayout.EAST, checkBox[0]);
        layout.putConstraint(SpringLayout.NORTH, checkBox[1],25,SpringLayout.NORTH,textField );
        
        layout.putConstraint(SpringLayout.WEST, checkBox[2],20,SpringLayout.EAST, checkBox[1]);
        layout.putConstraint(SpringLayout.NORTH, checkBox[2],25,SpringLayout.NORTH,textField );
        
        layout.putConstraint(SpringLayout.WEST, button1,50,SpringLayout.EAST, checkBox[2]);
        layout.putConstraint(SpringLayout.NORTH, button1,25,SpringLayout.NORTH,textField );
        
        layout.putConstraint(SpringLayout.WEST, button2,10,SpringLayout.EAST, button1);
        layout.putConstraint(SpringLayout.NORTH, button2,25,SpringLayout.NORTH,textField );
        
        layout.putConstraint(SpringLayout.WEST, jsp1,5,SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, jsp1,30,SpringLayout.NORTH,checkBox[1] );
        
        layout.putConstraint(SpringLayout.WEST, label,5,SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, label,5,SpringLayout.SOUTH,jsp1);
        
        layout.putConstraint(SpringLayout.WEST, jsp2,5,SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, jsp2,5,SpringLayout.SOUTH,label);
        
        
        //end
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class BoardTableCellRenderer extends DefaultTableCellRenderer {

private static final long serialVersionUID = 1L;
Okno okno;
public BoardTableCellRenderer(Okno okno)
{
	this.okno=okno;
}
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row,int col) {

    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

    System.out.println("Ilosc: "+okno.iloscZapamietanych+"row: "+row);
    if(row==okno.iloscZapamietanych-1)c.setBackground(okno.allColors[row][col]);
    return c;
}
}
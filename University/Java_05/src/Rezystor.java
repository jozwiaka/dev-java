import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

class Rezystor extends JPanel {
	private Color c = Color.lightGray;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor( c );
		g.fillRect(0,0, 70, 60);
	}
	
	void setColor( Color c) {
		this.c = c;
		this.repaint();
	}
	Color getColor()
	{
		return c;
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension( 70,60 );
	}
}
import java.awt.Color;

class Kolor {

	Color color;
	String napis;
	String liczba;
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getNapis() {
		return napis;
	}

	public void setNapis(String napis) {
		this.napis = napis;
	}

	public String getLiczba() {
		return liczba;
	}

	public void setLiczba(String liczba) {
		this.liczba = liczba;
	}


	public Kolor(Color c, String s, String l) {
		this.color = c;
		this.napis = s;
		this.liczba = l;
	}
	@Override
	
	public String toString()
	{
		return napis+"         "+liczba;
	}
	
}

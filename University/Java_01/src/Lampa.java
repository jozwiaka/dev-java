import java.util.Random;
public class Lampa {

	private Zarowka zarowka1, zarowka2;
	public Lampa(Zarowka zarowka1, Zarowka zarowka2)
	{
		this.zarowka1=zarowka1;
		this.zarowka2=zarowka2;
	}
	
	public void wlacz()
	{
		zarowka1.wlacz();
		zarowka2.wlacz();
		System.out.println("Wlaczona Lampa");
	}
	public void wylacz()
	{
		zarowka1.wylacz();
		zarowka2.wylacz();
		System.out.println("Wylaczona Lampa");
	}
	public void obliczMoc()
	{
		int moc = zarowka1.getMoc()+zarowka2.getMoc();
		System.out.println("Moc lampy wynosi: " + moc +"W");
	}
	
	public void wlaczLosowaZarowke()
	{
		Random rand = new Random();
		int numer = rand.nextInt(2)+1;
		if(numer==1) 
			{
			zarowka1.wlacz();
			System.out.println("Losowo wlaczona Zarowka1");
			}
		if(numer==2) 
			{
			zarowka2.wlacz();
			System.out.println("Losowo wlaczona Zarowka2");
			}
	}
}

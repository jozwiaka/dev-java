import javax.swing.SwingUtilities;

public class Uruchom {

	public static void main(String[] args) {
		//Macierz
		double tab[][] = {{1,2},{3,4}};
		Macierz macierz = new Macierz(tab);
		macierz.ustawElement(1, 2, 5);
		System.out.println(macierz.dajElement(2, 1));
		System.out.println(macierz.dajWyznacznik());
		
		SwingUtilities.invokeLater(new Runnable()
				{ 
			@Override
			public void run()
					{
						//Okno2
						new Okno2();
					}
				}
		);
	}

}

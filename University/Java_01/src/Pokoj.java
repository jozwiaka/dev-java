
public class Pokoj {

	public static void main(String[] args) {

		Zarowka zarowka1 = new Zarowka(10);
		Zarowka zarowka2 = new Zarowka(20);
		Lampa lampa = new Lampa(zarowka1, zarowka2);
		
		zarowka1.wlacz();
		zarowka1.wylacz();
		
		lampa.wlacz();
		lampa.wylacz();
		lampa.wlaczLosowaZarowke();
		
		lampa.obliczMoc();
	}

}
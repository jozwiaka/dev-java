
public class Main {

	public static void main(String[] args) {
		System.out.println("Zadanie 1");
		System.out.println("\n***Rekurencja***");
		Rekurencja rekurencja = new Rekurencja(3); //konstruktor przyjmuje numer wiersza
		rekurencja.setZnak(false);
		System.out.println(rekurencja);
		
		System.out.println("\n***Dwumian Newtona***");
		DwumianNewtona dwumianNewtona = new DwumianNewtona(4); //konstruktor przyjmuje numer wiersza
		dwumianNewtona.setZnak(false);
		System.out.println(dwumianNewtona);
		
		
		System.out.println("\n\n\nZadanie 2");
		StatystykiLancuchaZnakow statystyki = new StatystykiLancuchaZnakow("");
		System.out.println("\n***getString***");
		System.out.println(statystyki.getString());
		System.out.println("\n***dajDlugoscLancucha***");
		System.out.println(statystyki.dajDlugoscLancucha());
		System.out.println("\n***dajIloscLiter***");
		System.out.println(statystyki.dajIloscLiter());
		System.out.println("\n***dajIloscWielkichLiter***");
		System.out.println(statystyki.dajIloscWielkichLiter());
		System.out.println("\n***dajIloscMalychLiter***");
		System.out.println(statystyki.dajIloscMalychLiter());
		System.out.println("\n***dajIloscSamoglosek***");
		System.out.println(statystyki.dajIloscSamoglosek());
		System.out.println("\n***dajIloscWyrazow***");
		System.out.println(statystyki.dajIloscWyrazow());
		System.out.println("\n***dajNajkrotszyWyraz***");
		System.out.println(statystyki.dajNajkrotszyWyraz());
		System.out.println("\n***dajNajdluzszyWyraz***");
		System.out.println(statystyki.dajNajdluzszyWyraz());
		System.out.println("\n***dajDlugoscNajkrotszegoWyrazu***");
		System.out.println(statystyki.dajDlugoscNajkrotszegoWyrazu());
		System.out.println("\n***dajDlugoscNajdluzszegoWyrazu***");
		System.out.println(statystyki.dajDlugoscNajdluzszegoWyrazu());
	}
}
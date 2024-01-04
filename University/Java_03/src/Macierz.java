
public class Macierz
{
	private double numbers[][];
	
	Macierz(double numbers[][])
	{
		this.numbers = numbers;
	}
	
	double dajElement(int wiersz, int kolumna)
	{
		return numbers[wiersz-1][kolumna-1];
	}
	
	void ustawElement(int wiersz, int kolumna, double wartosc)
	{
		numbers[wiersz-1][kolumna-1] = wartosc;
	}
	
	double dajWyznacznik()
	{
		return numbers[0][0]*numbers[1][1] - numbers[0][1]*numbers[1][0];
	}
}

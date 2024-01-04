
public class DwumianNewtona {
	private boolean znak = true;
	private int n;

	public boolean isZnak() {
		return znak;
	}

	public void setZnak(boolean znak) {
		this.znak = znak;
	}
	
	public DwumianNewtona() {n=0;}
	public DwumianNewtona(int n){this.n=n;}
	
	public int[] dajWspolczynniki(int n)
	{
		if (n<0)
		{
			int tab[] = {};
			return tab;
		}
		int tab[] = new int[n+1];
		for (int i = 0; i<n+1; i++)
		{
			tab[i] = silnia(n)/(silnia(n-i)*silnia(i));
		}
		return tab;
	}
	
	private int silnia(int n)
	{
		if (n<2) return 1;
		return silnia(n-1)*n;
	}
	@Override
	public String toString()
	{
		int[] tab = this.dajWspolczynniki(n);
		String wartosci = "[";
		for(int i = 0; i<tab.length; i++)
		{
			if (!this.isZnak())
			{
				if (i%2 != 0) 
				{
					tab[i] *= -1;
				}
			}
			wartosci += tab[i];
			if (i!=tab.length-1)
			{
				wartosci += ", ";
			}
		}
		wartosci += "]";
		return wartosci;
	}
}

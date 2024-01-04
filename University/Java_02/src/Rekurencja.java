
public class Rekurencja {
	private boolean znak = true;
	private int n;

	public boolean isZnak() {
		return znak;
	}

	public void setZnak(boolean znak) {
		this.znak = znak;
	}
	
	public Rekurencja() {n=0;}
	public Rekurencja(int n){this.n=n;}
	
	public int[] dajWspolczynniki(int n)
	{
		if (n<0)
		{
			int tab[] = {};
			return tab;
		}
		int tab[] = new int[n+1];
		for (int i = 0;i<n+1;i++)
		{
			if (i==0||i==n)
			{
				tab[i]=1;
			}
			else
			{
				tab[i] = dajWspolczynniki(n-1)[i-1]+dajWspolczynniki(n-1)[i];
			}
		}
		return tab;
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

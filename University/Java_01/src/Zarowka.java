
public class Zarowka {

	private boolean wlaczona = false;
	private int moc;
	
	public Zarowka(int moc)
	{
		this.moc=moc;
	}
	public void wlacz()
	{
		wlaczona=true;
		System.out.println("Wlaczona Zarowka");
	}
	public void wylacz()
	{
		wlaczona=false;
		System.out.println("Wylaczona Zarowka");
	}
	
	public boolean isWlaczona() {
		return wlaczona;
	}
	public void setWlaczona(boolean wlaczona) {
		this.wlaczona = wlaczona;
	}
	public int getMoc() {
		return moc;
	}
	public void setMoc(int moc) {
		this.moc = moc;
	}
}


public class StatystykiLancuchaZnakow {
	private String string;
	private String[] words;
	public StatystykiLancuchaZnakow()
	{
		string = "";
		words = new String[1];
		words[0] = string;
	}
	public StatystykiLancuchaZnakow(String string)
	{
		this.string  = string;
		words = string.split("\\W");
	}
	public String getString()
	{
		return string;
	}
	public int dajDlugoscLancucha()
	{
		return string.length();
	}
	public int dajIloscLiter()
	{
		int iloscLiter = 0;
		for (int i=0;i<string.length();i++)
		{
			if(Character.isLetter(string.charAt(i)))
			{
				iloscLiter++;
			}
		}
		return iloscLiter;
	}
	public int dajIloscWielkichLiter()
	{
		int iloscWielkichLiter = 0;
		for (int i=0;i<string.length();i++)
		{
			if(Character.isUpperCase(string.charAt(i)))
			{
				iloscWielkichLiter++;
			}
		}
		return iloscWielkichLiter;
	}
	public int dajIloscMalychLiter()
	{
		return dajIloscLiter()-dajIloscWielkichLiter();
	}
	
	public int dajIloscSamoglosek()
	{
		int iloscSamoglosek = 0;
		for (int i=0;i<string.length();i++)
		{
			char ch = string.charAt(i);
			if(ch =='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u')
			{
				iloscSamoglosek++;
			}
		}
		return iloscSamoglosek;
	}
	public int dajIloscWyrazow()
	{
		if(string=="")
		{
			return 0;
		}
		return words.length;
	}
	public String dajNajkrotszyWyraz()
	{
		String najkrotszyWyraz = words[0];
		int dlugoscNajkrotszegoWyrazu = words[0].length();
		for (int i = 0;i<words.length;i++)
		{
			if (words[i].length() < dlugoscNajkrotszegoWyrazu)
			{
				najkrotszyWyraz = words[i];
			}
		}
		return najkrotszyWyraz;
	}
	public String dajNajdluzszyWyraz()
	{
		String najdluzszyWyraz = words[0];
		int dlugoscNajdluzszegoWyrazu = words[0].length();
		for (int i = 0;i<words.length;i++)
		{
			if (words[i].length() > dlugoscNajdluzszegoWyrazu)
			{
				najdluzszyWyraz = words[i];
			}
		}
		return najdluzszyWyraz;
	}
	public int dajDlugoscNajkrotszegoWyrazu()
	{
		return dajNajdluzszyWyraz().length();
	}
	public int dajDlugoscNajdluzszegoWyrazu()
	{
		return dajNajkrotszyWyraz().length();
	}
}

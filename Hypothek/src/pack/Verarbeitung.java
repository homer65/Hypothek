package pack;
public class Verarbeitung 
{
	private ErgebnisMenu em = new ErgebnisMenu();
	public void start()
	{
		double rest_kapital = Parameter.rest_kapital;
		double monatliche_zahlung = Parameter.monatliche_zahlung;
		double zins_satz = Parameter.zins_satz;
		double jaehrliche_sonderzahlung = Parameter.jaehrliche_sonderzahlung;
		boolean abbruch = false;
		int lfdnr = 0;
		em.addSatz("<<<< " + f(zins_satz) + " " +f(monatliche_zahlung) + " " + f(rest_kapital) );
		while (!abbruch)
		{
			double zins = rest_kapital * zins_satz / 1200.0;
			double tilgung = monatliche_zahlung - zins;
			rest_kapital = rest_kapital - tilgung;
			if (rest_kapital <= 0.0) abbruch = true;
			em.addSatz(f(lfdnr) + " " + f(monatliche_zahlung) + " " + f(zins) + " " + f(tilgung) + " " + f(rest_kapital));
			double monat = lfdnr - ((lfdnr / 12) * 12) +1;
			if (monat == 12) 
			{
				rest_kapital = rest_kapital - jaehrliche_sonderzahlung;
				em.addSatz(">>>> " + f(jaehrliche_sonderzahlung) + " " + f(rest_kapital));
			}
			lfdnr++;
		}
		em.build();
		em.anzeigen();
	}
	public String f(double d)
	{
		return String.format("%.2f", d);
	}
	public String f(int i)
	{
		int jahre  = i / 12;
		int monate = i - (12 * jahre) + 1;
		String sj = "" + jahre;
		if (sj.length() == 1) sj = " " + sj;
		String sm = "" + monate;
		if (sm.length() == 1) sm = " " + sm;
		String erg = sj + "/" + sm;
		return erg;
	}
}

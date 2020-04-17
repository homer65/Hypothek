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
		double bisher_gezahlt = 0.0;
		boolean abbruch = false;
		int lfdnr = 0;
		em.addSatz("<<<< " + f(zins_satz) + " " +f(monatliche_zahlung) + " " + f(rest_kapital) );
		while (!abbruch)
		{
			double zins = rest_kapital * zins_satz / 1200.0;
			double tilgung = monatliche_zahlung - zins;
			rest_kapital = rest_kapital - tilgung;
			bisher_gezahlt += monatliche_zahlung;
			if (rest_kapital <= 0.0)
			{
				abbruch = true;
				monatliche_zahlung += rest_kapital;
				tilgung += rest_kapital;
				bisher_gezahlt += rest_kapital;
				rest_kapital = 0.0;
			}
			em.addSatz(f(lfdnr) + " " + f(monatliche_zahlung) + " " + f(zins) + " " + f(tilgung) + " " + f(rest_kapital) + " " + f(bisher_gezahlt));
			double monat = lfdnr - ((lfdnr / 12) * 12) +1;
			if (monat == 12) 
			{
				rest_kapital = rest_kapital - jaehrliche_sonderzahlung;
				bisher_gezahlt += jaehrliche_sonderzahlung;
				if (rest_kapital <= 0.0)
				{
					abbruch = true;
					jaehrliche_sonderzahlung += rest_kapital;
					bisher_gezahlt += rest_kapital;
					rest_kapital = 0.0;
				}
				em.addSatz(">>>> " + f(jaehrliche_sonderzahlung) + " " + f(rest_kapital) + " " + f(bisher_gezahlt));
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

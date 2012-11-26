
public class ApuaModuuli extends BottiModuuli{

	public ApuaModuuli(ErkkiBotti botti) {
		super(botti);
	}

	public void viesti(String kanava, String lahettaja, String login,
			String palvelinnimi, String viesti) {

		String[] sanataulukko = viesti.split(" ");
		for (int i = 0; i < sanataulukko.length; i++) {
			String sana = sanataulukko[i];
			if (sana.equalsIgnoreCase("erkki")) {
				for (int j = 0; j < sanataulukko.length; j++) {
					String sana2 = sanataulukko[j];
					if (sana2.equalsIgnoreCase("apua") || 
							sana2.equalsIgnoreCase("hilfe")) {
						botti.lahetaViesti(kanava, "Erkki ojentaa auttavan " +
								"k�tens� tilanteessa kuin tilanteessa:" +
								"Tarvetta lent�ville lauseille? Kirjoita 'mietelause'." + 
								"Kuva-arvoituksia halutessasi kirjoita 'kuvavisa'." + 
								"N�lk�isen� kirjoita 'mit� t�n��n sy�t�isiin?'" + 
								"ja per��n raaka-aine, niin saat linkin resepteihin.");
						break;
					}
				}
				break;
			}
		}
	}
}


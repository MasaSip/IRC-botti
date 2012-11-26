
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
								"kätensä tilanteessa kuin tilanteessa:" +
								"Tarvetta lentäville lauseille? Kirjoita 'mietelause'." + 
								"Kuva-arvoituksia halutessasi kirjoita 'kuvavisa'." + 
								"Nälkäisenä kirjoita 'mitä tänään syötäisiin?'" + 
								"ja perään raaka-aine, niin saat linkin resepteihin.");
						break;
					}
				}
				break;
			}
		}
	}
}


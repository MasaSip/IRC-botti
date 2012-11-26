import java.util.Random;


public class VastausModuuli extends BottiModuuli {

	private Random rand = new Random();

	public VastausModuuli(ErkkiBotti botti) {
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
					if (sana2.equalsIgnoreCase("moi") 
							|| sana2.equalsIgnoreCase("hei")
							|| sana2.equalsIgnoreCase("terve") 
							|| sana2.equalsIgnoreCase("moro")) {
						double arpa = rand.nextDouble();
						if (arpa < 0.5) {
							botti.lahetaViesti(kanava, 
									"Heissulivei " + lahettaja + "!");
						}
						else {
							botti.lahetaViesti(kanava, "Moi " + lahettaja + "!!!");
						}
						break;
					}
				}
				break;
			}

			if (sana.equalsIgnoreCase("motivaatiovalas")) {
				botti.lahetaViesti(kanava, "http://lannistajakuha.com/" + "...");
				break;
			}

			if (sana.equalsIgnoreCase("kuuluu") || sana.equalsIgnoreCase("menee")) {
				double arpa = rand.nextDouble(); 				
				for (int j = 0; j < sanataulukko.length; j++) {
					String sana2 = sanataulukko[j];
					if (sana2.equalsIgnoreCase("mitä") 
							|| sana2.equalsIgnoreCase("miten")) {
						if (arpa < 0.3) {						
							botti.lahetaViesti(kanava, 
									"Kiitos kysymästä! Vointini on mainio.");
						}
						else if (arpa < 0.4) {
							botti.lahetaViesti(kanava, "Well hello there!");
						}
						else if (arpa < 0.5) {
							botti.lahetaViesti(kanava, 
									"Vähän noi deadlinet huolettaa...");
						}
						else if (arpa < 0.6) {
							botti.lahetaViesti(kanava, 
									"Suattaapi olla että menee hyvin, suattaapi" 
											+ " olla että ei.");
						}
						else {
							botti.lahetaViesti(kanava, "iha ok.");
						}
						botti.lahetaViesti(kanava, "Mitäs kuuluu " + lahettaja + "?");
						break;
					}
				}

			}
			if (sana.equalsIgnoreCase("sää")) {
				for (int j = 0; j < sanataulukko.length; j++) {
					String sana2 = sanataulukko[j];
					if (sana2.equalsIgnoreCase("millainen") 
							|| sana2.equalsIgnoreCase("mikä")
							|| sana2.equalsIgnoreCase("onko")) { 
						double arpa = rand.nextDouble();
						if (arpa < 0.2) {
							botti.lahetaViesti(kanava, 
									"Lievää vihmasadetta Länsi-Uudellemaalle, " +
									"illalla saattaa pilvipeite rakoilla.");
						}
						else if (arpa < 0.3) {
							botti.lahetaViesti(kanava, "Ensi talven sää: sataa " +
									"lunta, ja kaikkia vituttaa.");
						}
						else if (arpa < 0.35) {
							botti.lahetaViesti(kanava, "Koko kevään syyssää: " +
									"sataa kuin esterin perseestä.");
						}
						else if (arpa < 0.50) {
							botti.lahetaViesti(kanava, "Puolipilvistä ja vaihtelevaa " +
									"säätä Etelä-Suomeen, Lapissa lumi on jo peittänyt maan.");
						}
						else if (arpa < 0.65) {
							botti.lahetaViesti(kanava, "Kylmät ilmamassat " +
									"valuvat Siperiasta Suomeen, ja kaikilla on kylmä.");
						}
						else if (arpa < 0.80) {
							botti.lahetaViesti(kanava, "Aurinko paistaa ja vettä " +
									"sataa, taitaa tulla kesä!");
						}
						else if (arpa < 0.95) {
							botti.lahetaViesti(kanava, "Varokaa heikkoja jäitä!");
						}
						else {
							botti.lahetaViesti(kanava, "Aurinko paistaa! " +
									"Hellettä luvassa huomennakin! :)");
						}
						break;
					}
				}
			}

			if (sana.equalsIgnoreCase("moi") || sana.equalsIgnoreCase("hei")
					|| sana.equalsIgnoreCase("terve") 
					|| sana.equalsIgnoreCase("moro")) {

				double arpa = rand.nextDouble();
				if (arpa < 0.2) {
					botti.lahetaViesti(kanava, "Morppa!");
				}
				else if (arpa < 0.25) {
					botti.lahetaViesti(kanava, "Terve, olla jokainen voi! Mä"
							+ " sanon terve, kun tahdon sanoa moi!");
				}
				else if (arpa < 0.5) {
					botti.lahetaViesti(kanava, "Hyvää päivää!");
				}
				else if (arpa < 0.55) {
					botti.lahetaViesti(kanava, "JAHUU!!!");
				}
				else if (arpa < 0.8) {
					botti.lahetaViesti(kanava, "Älä puhu mulle");
				}
				else {
					botti.lahetaViesti(kanava, "moro!");
				}
			}

		}
	}
}




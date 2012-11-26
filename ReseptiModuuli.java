
public class ReseptiModuuli extends BottiModuuli {



	public ReseptiModuuli(ErkkiBotti botti) {
		super(botti);

	}
	public void viesti(String kanava, String lahettaja, String login,
			String palvelinnimi, String viesti) {


		if (viesti.startsWith("mita tanaan syotaisiin?")) {
			String[] sanataulukko = viesti.split(" ");
			if (sanataulukko.length == 4) {
				String hakusana = sanataulukko[3];
				botti.lahetaViesti(kanava, lahettaja + "Resepteja loytyy osoitteesta " 
						+ "http://www.pirkka.fi/ruoka/reseptihaku?keys=" + 
						hakusana);
			}


		}
	}


}

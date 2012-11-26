
public class ReseptiModuuli extends BottiModuuli {
	private String kanava;


	public ReseptiModuuli(ErkkiBotti botti) {
		super(botti);

	}
	public void viesti(String kanava, String lahettaja, String login,
			String palvelinnimi, String viesti) {


		this.kanava = kanava;
		if (viesti.startsWith("mitä tänään syötäisiin?")) {
			String[] sanataulukko = viesti.split(" ");
			
			if (sanataulukko.length == 4) {
				String hakusana = sanataulukko[3];
				this.annaRuokaVinkki(sanataulukko[3]);
				/*botti.lahetaViesti(kanava, "Resepteja loytyy osoitteesta " 
						+ "http://www.pirkka.fi/ruoka/reseptihaku?keys=" + 
						hakusana);
			*/
			}


		}
		if (viesti.startsWith("ruoka")){
			String[] sanataulukko = viesti.split(" ");
			if (sanataulukko.length == 2) {
				this.annaRuokaVinkki(sanataulukko[1]);
				
			}
		}
	}
	
	public void annaRuokaVinkki(String hakusana){
		botti.lahetaViesti(this.kanava, "Resepteja loytyy osoitteesta " 
				+ "http://www.pirkka.fi/ruoka/reseptihaku?keys=" + 
				hakusana);
	}


}

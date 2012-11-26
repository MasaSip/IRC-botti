


public class Tarkistussaie implements Runnable{

	private Kuvavisa visailu;
	private Kuva kuva;

	
	public Tarkistussaie(Kuvavisa visailu, Kuva kuva){
		
		this.visailu = visailu;
		this.kuva = kuva;
	}
	
	public String annaViestinLahettaja(){
		
		return visailu.botti.viimeisinLahettaja;
	}
	
	public String annaViimeisinViesti(){
		
		return visailu.botti.viimeisinViesti;
	}
	
	public void printtaaKokoKuva(){
		
		for (int i = 0; i < kuva.annaRivienKoko(); i++){
			
			kuva.annaRivi(i).asetaNakyvyys(true);
			visailu.botti.lahetaViesti(visailu.annaKanava(), 
					kuva.annaRivi(i).printtaa());
		}
		
	}
	
	@Override
	public void run() {
		
		while (!kuva.oikeaVastaus(visailu.annaViimeisinViesti()) && kuva.annaNakymattomienKoko() >  1){

			
			int arpa = kuva.arvanArpominen();
			Rivi rivi = kuva.annaRivi(arpa);
			rivi.asetaNakyvyys(true);
			for (int i = 0; i < kuva.annaRivienKoko(); i++){
				

				for (int k = 0; k < 100; k++){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (kuva.oikeaVastaus(visailu.annaViimeisinViesti())){
						
						visailu.botti.lahetaViesti(visailu.annaKanava(), "Mahtavaa!!");
						visailu.botti.lahetaViesti(visailu.annaKanava(), "Onneksi olkoon " +
						annaViestinLahettaja() + "! Arvasit oikein. Vastaus oli " +
						kuva.annaNimi());
						printtaaKokoKuva();
						break;
					}
				}
				if (kuva.oikeaVastaus(visailu.annaViimeisinViesti())){
					
					break;
				}
				rivi = kuva.annaRivi(i);
				visailu.botti.lahetaViesti(visailu.annaKanava(),  rivi.printtaa());
			}
			if (kuva.oikeaVastaus(visailu.annaViimeisinViesti())){
				
				break;
			}
			visailu.botti.lahetaViesti(visailu.annaKanava(), "############################");
			visailu.botti.lahetaViesti(visailu.annaKanava(), "############################");
		}
		
		
	}

}

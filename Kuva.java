
import java.util.*;


public class Kuva  implements Runnable{

	private String nimi;
	private List<Rivi> riveja;
	private static Random rand = new Random();
	private Kuvavisa visailu;
	private String kanava;
	private int rivienMaara;


	public Kuva(Kuvavisa visailu, String nimi){

		riveja = new ArrayList<Rivi>();
		this.visailu = visailu;
		this.nimi = nimi;




	}

	public void asetaRivienNakyvyys(Boolean nakyvyys){

		for(Rivi rivi : riveja){

			rivi.asetaNakyvyys(nakyvyys);
		}
	}

	public int arvanArpominen(){

		int arpa = rand.nextInt(riveja.size()-1);
		if (riveja.get(arpa).onkoNakyvissa()){

			arvanArpominen();
		}
		return arpa;
	}
	
	public boolean oikeaVastaus(String viesti){
		
		if (viesti.startsWith(nimi)){
			
			return true;
		}
		return false;
	}

	public void run() {
        if (this.oikeaVastaus(this.visailu.annaViimeisinViesti())){
        	
        }
    }
	
	public void arvuutaKuva(){
		new Thread(new Vitsisaie(this.visailu, this));
		asetaRivienNakyvyys(false);

		while (!oikeaVastaus(visailu.annaViimeisinViesti())){
			
			// Nukkuu 10 sek
			int arpa = arvanArpominen();
			Rivi rivi = riveja.get(arpa);
			rivi.asetaNakyvyys(true);
			for (int i = 0; i < riveja.size(); i++){


				visailu.botti.lahetaViesti("!pahaolo",  rivi.printtaa());
			}
		}


	}

	public void lisaaRivi(int riviNumero, String rivi){

		riveja.add(riviNumero, new Rivi(riviNumero, rivi, this));

	}


}

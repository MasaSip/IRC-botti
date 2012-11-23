
import java.util.*;


public class Kuva  implements Runnable{

	private String nimi;
	private List<Rivi> riveja;
	private Random rand = new Random();
	private Kuvavisa visailu;
	private List<Integer> nakymattomatRivit;


	public Kuva(Kuvavisa visailu, String nimi){

		riveja = new ArrayList<Rivi>();
		this.visailu = visailu;
		this.nimi = nimi;
		nakymattomatRivit = new ArrayList<Integer>();




	}

	public void asetaRivienNakyvyys(Boolean nakyvyys){

		for(Rivi rivi : riveja){

			rivi.asetaNakyvyys(nakyvyys);
		}
	}

	public int arvanArpominen(){
		
		// TAA ON VAARIN
		//System.out.println(nakymattomatRivit.size());
		//int arpa = rand.nextInt(nakymattomatRivit.size());
	//	nakymattomatRivit.remove(arpa);
		int arpa = rand.nextInt(this.riveja.size());
		
		
		if (this.riveja.get(arpa).onkoNakyvissa() == true ){
			return this.arvanArpominen();
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

		while (!oikeaVastaus(visailu.annaViimeisinViesti()) && nakymattomatRivit.size() >  0){
			
			// Nukkuu 10 sek
			System.out.println(nakymattomatRivit.size());
			int arpa = arvanArpominen();
			Rivi rivi = riveja.get(arpa);
			visailu.botti.lahetaViesti(visailu.annaKanava(), Integer.toString(arpa)); // TESTIA VARTEN
			rivi.asetaNakyvyys(true);
			for (int i = 0; i < riveja.size(); i++){

				rivi = riveja.get(i);
				visailu.botti.lahetaViesti(visailu.annaKanava(),  rivi.printtaa());
			}
			visailu.botti.lahetaViesti(visailu.annaKanava(), "############################");
			visailu.botti.lahetaViesti(visailu.annaKanava(), "############################");

		}


	}

	public void lisaaRivi(int riviNumero, String rivi){

		riveja.add(riviNumero, new Rivi(riviNumero, rivi, this));
		nakymattomatRivit.add(riviNumero);

	}


}

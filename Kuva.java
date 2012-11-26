
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
	
	public String annaNimi(){
		
		return nimi;
	}
	
	public int annaRivienKoko(){
		return riveja.size();
	}
	
	public Rivi annaRivi(int riviNro){
		
		return riveja.get(riviNro);
	}

	public void asetaRivienNakyvyys(Boolean nakyvyys){

		for(Rivi rivi : riveja){

			rivi.asetaNakyvyys(nakyvyys);
		}
	}

	public int arvanArpominen(){

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


	}
	
	public int annaNakymattomienKoko(){
		
		return nakymattomatRivit.size();
	}

	public void arvuutaKuva(){
		
		Thread tarkistus = new Thread (new Tarkistussaie(this.visailu, this));
		tarkistus.start();

	}

	public void lisaaRivi(int riviNumero, String rivi){

		riveja.add(riviNumero, new Rivi(riviNumero, rivi, this));
		nakymattomatRivit.add(riviNumero);

	}






}

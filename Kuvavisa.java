import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.jibble.pircbot.*;
/**
 * 
 * @author Arto ja Mikko
 *
 */


/*
 * Testailin kuvavistaa pe 23.11. sen j�lkeen ku atro olit l�htenyt
 * freenode:n servulla tulosteita tuli yht� tiuhaan kun eclepsen alalaitaan.
 * ilmeisesti Pric rajoitaa bottia silloin. Koulun servulle tulosteita
 * tuli viel� hitaammi. freenodelle t�� botti tulosti BROFIST. Tulosti kuvan
 * nimen joka kerta uuelleen kun kuvasta paljastettiin enemm�n.
 * 
 * Parannus vois olla esim. ett� tulostaa osan kuvaa ja kertoo odottavansa
 * komentoa "lisaa" ennen kuin tulostaa lisaa. Kun komento annetaan, botti 
 * tulostaisi lopun kuvasta. Siin�p�h�n yritt�v�t arvata mahd. nopeasti samalla
 * ku kuva valuu hitaasti n�kyviin. N�in jotta saatais visa nopeatempoisemmaksi
 *
 *
 *
 *				t.Masa
 */



public class Kuvavisa extends BottiModuuli {

	//private List<String> kuvapankki;
	//private HashMap<Kayttaja, Integer> tilastot;
	private static Random rand = new Random();
	private String viimeisinViesti;
	private static String[] kuvapankki = {"brofist.txt", "lohikaarme.txt", "pikachu"};
	private String kanava;
	
	public Kuvavisa(ErkkiBotti Botti){
		super(Botti);
	}
	
	public void aloitaArvuuttelu(){
		
		int arpa = rand.nextInt(kuvapankki.length);
		//kint arpa = 0;
		System.out.println(arpa);
		String kuvanNimi = kuvapankki [arpa];
		
		Kuva kuva = lueKuva(kuvanNimi);
		kuva.run();
	}
	
	/*public void printtaaPisteet(String nimi){
		
		this.tilastot.get(nimi);
	}*/
	
	/*public Kayttaja nimestaKayttaja(String hermanni){
		
		Kayttaja[] nimet = tilastot.get(hermanni);
		
		
	}*/
	
	public void printtaaPisteet(String kanava){
		botti.lahetaViesti(kanava, "Sori, taa ei toimi viela.");
	}
	
	public String annaViimeisinViesti(){
		return this.viimeisinViesti;
	}
	
	public String annaKanava(){
		
		return this.kanava;
	}
	
	public void viesti(String kanava, String lahettaja,
            String login, String palvelinnimi, String viesti){
		
		this.viimeisinViesti = viesti;
		this.kanava = kanava;
		if (viesti.equalsIgnoreCase("kuvavisa")){
			System.out.println("aloitetaan arvuuttelu");
			aloitaArvuuttelu();
			
		}
		if (viesti.equalsIgnoreCase("pisteet")){
			printtaaPisteet(kanava);
		}
		
		
	}
	
	
	public Kuva lueKuva(String kuvanNimi){
		try{
			FileInputStream fis = new FileInputStream(kuvanNimi);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			String nakki = br.readLine();
			int riviNumero = 0;
			String nimi[] = kuvanNimi.split(".txt");
			Kuva kuva = new Kuva(this, nimi[0]);
			while (nakki != null){
				
				
				kuva.lisaaRivi(riviNumero, nakki);
				riviNumero++;
				nakki = br.readLine();
			}
			return kuva;
			
		}catch(IOException e){
			System.out.println("troll");
			return null;
		}
	}
	
	

	
}

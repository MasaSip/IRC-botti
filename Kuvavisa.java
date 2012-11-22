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
public class Kuvavisa extends BottiModuuli {

	private List<String> kuvapankki;
	private HashMap<Kayttaja, Integer> tilastot;
	private static Random rand = new Random();
	private String viimeisinViesti;

	public Kuvavisa(ErkkiBotti Botti){
		super(Botti);
	}
	
	public void aloitaArvuuttelu(){
		
		//if (kuvapankki != null){
			
		//}
		//int arpa = rand.nextInt(this.kuvapankki.size());
		int arpa = 0;
		String kuvanNimi = kuvapankki.get(arpa);
		Kuva kuva = lueKuva(kuvanNimi);
		kuva.arvuutaKuva();
	}
	
	/*public void printtaaPisteet(String nimi){
		
		this.tilastot.get(nimi);
	}*/
	
	/*public Kayttaja nimestaKayttaja(String hermanni){
		
		Kayttaja[] nimet = tilastot.get(hermanni);
		
		
	}*/
	
	public void printtaaPisteet(String kanava){
		botti.lahetaViesti(ErkkiBotti.kanava, "Sori, taa ei toimi viela.");
	}
	
	public String annaViimeisinViesti(){
		return this.viimeisinViesti;
	}
	
	public void viesti(String kanava, String lahettaja,
            String login, String palvelinnimi, String viesti){
		
		this.viimeisinViesti = viesti;
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
			String nakki;
			int riviNumero = 0;
			String nimi[] = kuvanNimi.split(".txt");
			Kuva kuva = new Kuva(this, nimi[0]);
			while ((nakki = br.readLine()) != null){
				
				kuva.lisaaRivi(riviNumero, nakki);
				riviNumero++;
			}
			return kuva;
			
		}catch(IOException e){
			System.out.println("troll");
			return null;
		}
	}
	
	

	
}

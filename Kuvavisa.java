import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 
 * @author Arto ja Mikko
 *
 */




public class Kuvavisa extends BottiModuuli implements Runnable {

	private static Random rand = new Random();
	private String viimeisinViesti;
	private static String[] kuvapankki = {"brofist.txt", "lohikaarme.txt", "pikachu.txt",
											"pommi.txt", "viski.txt", "tuoppi.txt", "kitara.txt"};
	private String kanava;
	private Thread kuvavisa;
	
	public Kuvavisa(ErkkiBotti Botti){
		super(Botti);
	}
	
	public void aloitaArvuuttelu(){
		
		int arpa = rand.nextInt(kuvapankki.length);
		System.out.println(arpa);
		String kuvanNimi = kuvapankki [arpa];
		
		Kuva kuva = lueKuva(kuvanNimi);
		kuva.arvuutaKuva();
	}
	
	public void printtaaPisteet(String kanava){
		botti.lahetaViesti(kanava, "Sori, taa ei toimi viela.");
	}
	
	public String annaViimeisinViesti(){
		return this.viimeisinViesti;
	}
	
	public String annaKanava(){
		
		return this.kanava;
	}
	
	public void paivitaViesti(){
		
		viimeisinViesti = botti.viimeisinViesti;
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
	
	public void run(){
		
		kuvavisa = new Thread();
		kuvavisa.start();
		aloitaArvuuttelu();
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

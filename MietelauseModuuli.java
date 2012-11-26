import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class MietelauseModuuli extends BottiModuuli {
	private static Random random = new Random();
	private ArrayList <String> mietelauseet;


	public MietelauseModuuli(ErkkiBotti botti){
		super(botti);
		this.mietelauseet = new ArrayList<String>();
		this.lueTiedostoMuistiin();
	}

	/**
	 * Lukee rivit tiedostosta ja tallentaa jokaisen listaan omaan alkioonsa.
	 */
	public void lueTiedostoMuistiin(){
		FileInputStream stream = null;
		BufferedReader reader = null;

		try{
			//stream = new FileInputStream("/Users/hkk/Documents/workspace/IRKKIBOTTI/bin/Erkkibotin_mietelauseet.txt");
			stream = new FileInputStream("Erkkibotin_mietelauseet.txt");

			reader = new BufferedReader(new InputStreamReader(stream));

			String rivi = reader.readLine();
			while(rivi != null){
				this.mietelauseet.add(rivi);
				rivi = reader.readLine();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Tiedostoa ei lšytynyt.");
		}
		catch(IOException e){
		}
		finally{
			try{
				reader.close();
				stream.close();
			}
			catch(IOException e){
			}
		}
	}

	public void viesti(String kanava, String lahettaja,
			String login, String palvelinnimi, String viesti) { 

		if(viesti.equals("mietelause")){
			int kohderivi = this.random.nextInt(this.mietelauseet.size());
			for(int i = 0; i < kohderivi; i++){ 
				System.out.println(kohderivi);
			}
			botti.lahetaViesti(kanava, lahettaja + mietelauseet.get(kohderivi));
		}

	}


	/*public static void main(String[] args){
		MietelauseModuuli mlm = new MietelauseModuuli(null);
		System.out.println(mietelauseet.get(100));
	}
	 */



}

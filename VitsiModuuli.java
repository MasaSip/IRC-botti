import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class VitsiModuuli extends BottiModuuli {
	private static Random random = new Random();
	private static ArrayList <String> vitsit;


	public VitsiModuuli(ErkkiBotti botti){
		super(botti);
		this.vitsit = new ArrayList<String>();
		this.lueTiedostoMuistiin();
	}

	/**
	 * Lukee rivit tiedostosta ja tallentaa jokaisen listaan omaan alkioonsa.
	 */
	public void lueTiedostoMuistiin(){
		FileInputStream stream = null;
		BufferedReader reader = null;

		try{
			//stream = new FileInputStream("/home/u4/jskinnun/desktop/Erkkibotin_vitsit.txt");
			stream = new FileInputStream("Erkkibotin_vitsit.txt");

			reader = new BufferedReader(new InputStreamReader(stream));

			String rivi = reader.readLine();
			while(rivi != null){
				this.vitsit.add(rivi);
				rivi = reader.readLine();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Tiedostoa ei loytynyt.");
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

		if(viesti.equals("vitsi")){
			int kohderivi = this.random.nextInt(this.vitsit.size());
			for(int i = 0; i < kohderivi; i++){ 
				System.out.println(kohderivi);
			}
			botti.lahetaViesti(kanava, mietelauseet.get(kohderivi));
		}
	}
	/*public static void main(String[] args){
		VitsiModuuli vm = new VitsiModuuli(null);
		System.out.println(vitsit.get(10));
	}
	 */
}

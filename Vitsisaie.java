
public class Vitsisaie implements Runnable{

	private Kuvavisa visailu;
	private Kuva kuva;



	public Vitsisaie(Kuvavisa visailu, Kuva kuva){
		this.kuva = kuva;
		this.visailu = visailu;
	}



	public void run (){
		String viesti = visailu.annaViimeisinViesti();
		while(!kuva.oikeaVastaus(viesti)){

			while (!Thread.interrupted()){
				viesti = visailu.annaViimeisinViesti();

				try{
					Thread.sleep(10);
				}catch(InterruptedException ie){
					System.out.println("Saie keskeytetty!");
					break;
				}
			}
		}
		System.out.println("JIPPIIIIIIII!!!!!");
	}
}
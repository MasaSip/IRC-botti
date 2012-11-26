
public class Vitsisaie implements Runnable{

	private Kuvavisa visailu;
	private Kuva kuva;
	private String viimeisinViesti;



	public Vitsisaie(Kuvavisa visailu, Kuva kuva){
		this.kuva = kuva;
		this.visailu = visailu;
	}



	public void run (){
		
		viimeisinViesti = visailu.annaViimeisinViesti();
		while(!kuva.oikeaVastaus(viimeisinViesti)){

			while (!Thread.interrupted()){
				
				visailu.paivitaViesti();
				viimeisinViesti = visailu.annaViimeisinViesti();
				//System.out.println(viimeisinViesti);

				try{
					Thread.sleep(100);
				}catch(InterruptedException ie){
					System.out.println("Saie keskeytetty!");
					break;
				}
			}
		}
		System.out.println("JIPPIIIIIIII!!!!!");
	}
	
	
}
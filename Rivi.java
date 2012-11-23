
public class Rivi {

	private boolean nakyvissa;
	private String merkit;
	/*private int riviNumero;
	private Kuva kuva;*/
	
	
	public Rivi(int riviNumero, String merkit, Kuva kuva){
		//this.riviNumero = riviNumero;
		this.merkit = merkit;
		this.nakyvissa = false;
		//this.kuva = kuva;
	}
	
	public Boolean onkoNakyvissa(){
		
		return nakyvissa;
	}
	
	public void asetaNakyvyys(Boolean nakyvyys){
		
		nakyvissa = nakyvyys;
	}



	public String printtaa(){
		if(nakyvissa){
			
			asetaNakyvyys(true);
			return merkit + "\n";
		}else{
			return ".\n";
		}
	}
}

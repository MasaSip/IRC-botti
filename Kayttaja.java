/**
 * 
 * @author Arto ja Mikko
 *
 */
@SuppressWarnings("rawtypes")
public class Kayttaja implements Comparable{

	private String nimi;
	private int pisteet;
	
	public Kayttaja(String nimi){
		this.nimi = nimi;
		this.pisteet = 0;
	}
	
	public String annaNimi(){
		return this.nimi;
	}
	
	public int annaPisteet(){
		return this.pisteet;
	}
	
	public void muutaPisteet(int muutos){
		this.pisteet = this.pisteet + muutos;
	}
	
	@Override
    public int compareTo(Object o) {
		Kayttaja p = (Kayttaja)o;
        return this.pisteet - p.annaPisteet() ;
		
	}

	
	
	
	
}

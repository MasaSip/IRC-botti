/**
 * Luokka MalliModuuli, esimerkki yksinkertaisesta ErkkiBotin moduulista.
 * @author OLO3
 */
public class MalliModuuli extends BottiModuuli {

	/**
	 * Moduulin konstruktorissa voidaan tehda mita vaan, pakollista on
	 * kutsua super(b);
	 * @param b
	 */
	MalliModuuli(ErkkiBotti botti) {
		super(botti);
	}

	/**
	 * 
	 */
	public void viesti(String kanava, String lahettaja, String login,
			String palvelinnimi, String viesti) {

		if (viesti.equalsIgnoreCase("time")) {
			String time = new java.util.Date().toString();
			
			botti.lahetaViesti(kanava, lahettaja + ": Aika on " + time);
		}
	}
} // end of MalliModuuli

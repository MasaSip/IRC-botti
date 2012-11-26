/**
 * ErkkiBotin moduulien abstraktio.
 * @author OLO3
 *
 */
public abstract class BottiModuuli {
	
	ErkkiBotti botti; // viittaus ErkkiBottiin
	
	BottiModuuli(ErkkiBotti botti) {
		this.botti = botti;
	}

	/**
	 * Toiminnallisuus, jonka moduuli toteuttaa viestia kohti.
	 */
    public abstract void viesti(String kanava, String lahettaja,
            String login, String palvelinnimi, String viesti);
	
}

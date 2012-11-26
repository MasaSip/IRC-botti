import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jibble.pircbot.*;

/**
 * Mikäli botin käynnistää eclipsestä, tekstitiedostojen tulee olla 
 * projektikansiossa. Komentoriviltä ajettaessa niiden tulee olla samassa 
 * kansiossa ErkkiMain.java kanssa
 * 
 * Rakkaan erkki-bottin toiminnallisuudet:
 * (lainaus merkeissä komennot, joihin reagoi)
 * 
 * MalliModuuli:
 * "time"
 * 
 * ReseptiModuuli:
 * "mitä tänään syötäisiin? tähänJokuRuoka"
 * "ruoka tähänJokuRuoka"
 * 
 * Kuvavisa:
 * "kuvavisa" Visailu keskeytyy, mikäli joku kirjoittaa irkkiin oikean 
 * vastauksen.
 * 
 * MietelauseModuuli:
 * "mietelause" 
 * 
 * VitsiModuuli:
 * "vitsi" 
 * 
 * VastausModuuli:
 * "moi", "moi erkki", "onko sää"
 * 
 * ApuaModuuli:
 * merkki jonot joissa esiintyy sanat: "erkki" ja "apua"
 * 
 * irc.cs.hut.fi serverillä erkkin kuvavisa saattaa reagoida viiveellä 
 * arvauksiin.
 * 
 * Mietelauseet tulostuvat hassuilla merkeillä vaikka tekstitiedostossa ei ole
 * ääkkösiä ollenkaan.
 * 
 * ErkkiBotti -luokan alussa valitaan attribuutteihin kanava, nickki ja servu 
 * 
 * @author OLO3
 *
 */




public class ErkkiBotti extends PircBot {
    //public static String server = "irc.freenode.net";
    public static String server = "irc.cs.hut.fi";
	public static String kanava = "!pahaolo";
    //public static String kanava = "#pahaolo";
	public static String login = "Erkki";
    public static String nick = "ErkkixD";
    public String viimeisinViesti;
    public String viimeisinLahettaja;
	Set<BottiModuuli> moduulit;
	
    public ErkkiBotti() {
    	this.setLogin(ErkkiBotti.login);
    	this.moduulit = new HashSet<BottiModuuli>();
        this.setName(ErkkiBotti.nick);
        
        this.moduulit.add(new MalliModuuli(this));
        this.moduulit.add(new ReseptiModuuli(this));
        this.moduulit.add(new Kuvavisa(this));
        this.moduulit.add(new MietelauseModuuli(this));
        this.moduulit.add(new VitsiModuuli(this));
        this.moduulit.add(new VastausModuuli(this));
        this.moduulit.add(new ApuaModuuli(this));
    }
    
    /**
     * Valittaa kaikki viestit ErkkiBotin moduuleille.
     * @param @see PircBot dokumentaatio.
     */
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message)
    {
    	this.viimeisinLahettaja = sender;
    	this.viimeisinViesti = message;
    	for (BottiModuuli mod : moduulit) {
    		mod.viesti(channel, sender, login, hostname, message);
    	}

    } // end of onMessage;
    
    /**
     * Valittaa viestien lahetykset ErkkiBotin moduuleilta PircBotille.
     * @param kanava
     * @param viesti
     */
    public void lahetaViesti(String kanava, String viesti) {
    	sendMessage(kanava, viesti);
    }
    
}
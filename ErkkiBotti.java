import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jibble.pircbot.*;

/**
 * Mik�li botin k�ynnist�� eclipsest�, tekstitiedostojen tulee olla 
 * projektikansiossa. Komentorivilt� ajettaessa niiden tulee olla samassa 
 * kansiossa ErkkiMain.java kanssa
 * 
 * Rakkaan erkki-bottin toiminnallisuudet:
 * (lainaus merkeiss� komennot, joihin reagoi)
 * 
 * MalliModuuli:
 * "time"
 * 
 * ReseptiModuuli:
 * "mit� t�n��n sy�t�isiin? t�h�nJokuRuoka"
 * "ruoka t�h�nJokuRuoka"
 * 
 * Kuvavisa:
 * "kuvavisa" Visailu keskeytyy, mik�li joku kirjoittaa irkkiin oikean 
 * vastauksen.
 * 
 * MietelauseModuuli:
 * "mietelause" 
 * 
 * VitsiModuuli:
 * "vitsi" 
 * 
 * VastausModuuli:
 * "moi", "moi erkki", "onko s��"
 * 
 * ApuaModuuli:
 * merkki jonot joissa esiintyy sanat: "erkki" ja "apua"
 * 
 * irc.cs.hut.fi serverill� erkkin kuvavisa saattaa reagoida viiveell� 
 * arvauksiin.
 * 
 * Mietelauseet tulostuvat hassuilla merkeill� vaikka tekstitiedostossa ei ole
 * ��kk�si� ollenkaan.
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
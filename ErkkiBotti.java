import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jibble.pircbot.*;

/**
 * Rakkaan erkki-bottin toiminnallisuudet:
 * 
 * 
 * 
 * 
 * 
 * @author OLO3
 *
 */




public class ErkkiBotti extends PircBot {
    public static String server = "irc.freenode.net";
    //public static String server = "irc.cs.hut.fi";
	//public static String kanava = "!pahaolo";
    public static String kanava = "#pahaolo";
	public static String login = "ErkkiHiippari43";
    public static String nick = "ErkkixD5";
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
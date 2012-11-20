import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jibble.pircbot.*;

/**
 * 
 * @author OLO3
 *
 */

public class ErkkiBotti extends PircBot {
    
	Set<BottiModuuli> moduulit;
	
    public ErkkiBotti() {
    	
    	this.moduulit = new HashSet<BottiModuuli>();
        this.setName("Erkki");
        
        this.moduulit.add(new MalliModuuli(this));
        this.moduulit.add(new ReseptiModuuli(this));
    }
    
    /**
     * Valittaa kaikki viestit ErkkiBotin moduuleille.
     * @param @see PircBot dokumentaatio.
     */
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message)
    {
    	
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
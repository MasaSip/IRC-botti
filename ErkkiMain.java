import org.jibble.pircbot.*;

public class ErkkiMain {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        ErkkiBotti bot = new ErkkiBotti();
        
        // Enable debugging output.
        bot.setVerbose(true);
      
        // Connect to the IRC server.
        bot.connect("irc.cs.hut.fi");

        // Join the #pircbot channel.
        bot.joinChannel("!pahaolo");
    }
    
}
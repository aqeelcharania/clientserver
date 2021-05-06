package GUI;

import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtendedServer extends AbstractServer
{
    final public static int DEFAULT_PORT = 5555;
    
    public ExtendedServer(int port) 
    {
        super(port);
    }
    
    public void handleMessageFromClient (Object msg, ConnectionToClient client)
    {
        String msgStr = msg.toString();
        System.out.println("Message received: " + msgStr + " from " + client);
      
        // Messages starting with ! are commands
        if (msgStr.charAt(0) == '!')
        {
            if (msgStr.startsWith("!nick"))
            {
                //String oldNick = client.getInfo("name").toString();
                String newNick = msgStr.replaceAll("!nick", "");
                client.setInfo("name", newNick);
               
            }
        }
        else
        {
            this.sendToAllClients("<i>" + nickOrInet(client) + ":</i> " + msgStr);
        }
    }
    
    public String nickOrInet(ConnectionToClient client)
    {
        String nick = client.getInetAddress().toString();
        if (client.getInfo("name") != null)
        {
            nick = client.getInfo("name").toString();
            System.out.println("Message recieved from " + nick);
        }
        return nick;
    }
    
    public void sendServerTestMessage()
    {
        //String msg = "<h2>Server Test Message</h2>";
        String msg = "<div><span style=\"color:#ff0000;\">Text was recieved by the client></div>";
        this.sendToAllClients(msg);
    }
    
    protected void serverStarted()
    {
      System.out.println("Server listening for connections on port " + getPort());
    }
    
    protected void serverStopped()
    {
      System.out.println("Server has stopped listening for connections.");
    }
    
    @Override
    protected void clientConnected(ConnectionToClient client)
    {
        
        String msg = String.format("<h3>%s has joined the Server!</h3>", nickOrInet(client));
        this.sendToAllClients(msg);
    }
}

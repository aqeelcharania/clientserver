// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package GUI;

import com.lloseng.ocsf.client.*;
import common.*;
import java.io.*;


public class ExtendedClient extends AbstractClient
{

    String nickname;
    ChatIF clientUI; 
  
  public ExtendedClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    this.nickname = "unknown";
    openConnection();
  }
  
  public ExtendedClient(String host, int port, String nickname, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    this.nickname = nickname;
    openConnection();
  }

  @Override
  public void handleMessageFromServer(Object msg) 
  {
    clientUI.display(msg.toString());
  }

  public void handleMessageFromClientUI(String message)
  {
    try
    {
      sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
  
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
  
  protected void connectionEstablished()
  {
      System.out.println("Established Connection");
      String message = "!nick " + this.nickname;
      try
    {
      sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
}

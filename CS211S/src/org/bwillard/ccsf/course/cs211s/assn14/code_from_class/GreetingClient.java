package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;

import java.net.*;
import java.io.*;

public class GreetingClient {
	
   public static void main(String [] args)   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      String name = args[2];
 
      
      System.out.println("Connecting to " + serverName + " on port " + port);
      
      try ( Socket client = new Socket(serverName, port) ) {
         System.out.println("Just connected to "  + client.getRemoteSocketAddress());
    

         DataOutputStream out = new DataOutputStream(client.getOutputStream());
         out.writeUTF("Hello from " + name + " at " + client.getLocalSocketAddress());
         
         DataInputStream in = new DataInputStream(client.getInputStream());
         System.out.println("Server says " + in.readUTF());
      }catch(IOException e)     {
         e.printStackTrace();
      }
   }
}
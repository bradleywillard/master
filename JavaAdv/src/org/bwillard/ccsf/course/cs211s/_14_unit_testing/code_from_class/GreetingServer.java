package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
	
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException    {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run()    {
	   System.out.println("Waiting for client on port " +  serverSocket.getLocalPort() + "...");
	   boolean timedOut = false;
      while(!timedOut)       {
         try  (Socket server = serverSocket.accept() ){          

            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            
            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
         }catch(SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            timedOut = true;
         }catch(IOException e) {
            e.printStackTrace();
            timedOut = true;
         }
      }
   }
   public static void main(String [] args)   {
      int port = Integer.parseInt(args[0]);
      try {
         Thread t = new GreetingServer(port);
         t.start();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}
package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;

import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://hills.ccsf.edu/~jlmaster/");
        //URL url = new URL("http://hillllls.ccsf.edu/~jlmaster/");
        //URL url = new URL("http://hills.ccsf.edu/~jlmaster/doesnotexist.html");
        BufferedReader reader = new BufferedReader(
        new InputStreamReader(url.openStream()));

        String inputLine;
        
       
        while ((inputLine = reader.readLine()) != null) {
            System.out.println(inputLine);
        }
        reader.close();
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class URIConnection {
     public static void main(String[] args) throws MalformedURLException {
    	   
//    	        	URL  u = new URL(args[0]);
//    	        	System.out.println("URL is"+ u);
//    	        	System.out.println("The protocol part is"+ u.getProtocol());
//    	        	System.out.println("The host part is"+ u.getHost());
//    	        System.out.println("The file part is"+ u.getFile());
    	       URI uri = new URI(args[0]);
    	       URIConnection connection = uri.toURL().openConnection();
    	       Map headers = connection.getHeaderFields();
    	       for (Object key : headers.keySet()) {
    	    	      System.out.println(key + ": "+ headers.get(key));
    	       }
    	       BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"JISAutoDetect"));
    	       
    	        
    	        	
    	       
    	 
    	 
     }
}

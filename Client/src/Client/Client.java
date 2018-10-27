package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public void Client(){

        //Create new socket
        try {
            Socket soc = new Socket("localhost",1997);

            //Writing the data from soc
            PrintStream  ps = new PrintStream(soc.getOutputStream());
            ps.println("Message from client");

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}

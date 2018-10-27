package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void Server(){
        System.out.println("Server is ready");
        //Create ServerSocket and accept the soc
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1997);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Socket soc = serverSocket.accept();

            BufferedReader buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String data = buff.readLine();

            if(data != null){
                System.out.println("Server have a message : "+ data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String args[]){
        Server server = new Server();
        server.Server();
    }
}

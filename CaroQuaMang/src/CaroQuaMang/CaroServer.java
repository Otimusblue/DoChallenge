package CaroQuaMang;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CaroServer {

    public static void main(String[] args) {
        new CaroServer();
    }
    int n=15;
    List<Point> dd = new ArrayList<>();
    Xuly P1=null,P2=null;
    public CaroServer(){
        try{
            ServerSocket server = new ServerSocket(2000);
            Socket Player1 = server.accept();
            System.out.println("Player 1 connected");
            P1 = new Xuly(this, Player1);
            P1.start();

            Socket Player2 = server.accept();
            System.out.println("Player 2 connected");
            P2 = new Xuly(this, Player2);
            P2.start();


        }catch(Exception e){
        }
    }
    public void sendCoor(int x, int y) {
        try{
            DataOutputStream dos1 = new DataOutputStream(P1.soc.getOutputStream());
            dos1.writeUTF(x+"");
            dos1.writeUTF(y+"");
            DataOutputStream dos2 = new DataOutputStream(P2.soc.getOutputStream());
            dos2.writeUTF(x+"");
            dos2.writeUTF(y+"");
        }catch(Exception e){

        }

    }
}

class Xuly extends Thread{
    CaroServer server;
    Socket soc;
    public Xuly(CaroServer server, Socket soc){
        this.server = server;
        this.soc = soc;
    }

    public void run(){
        while(true){
            try{

                DataInputStream dis = new DataInputStream(soc.getInputStream());
                int x = Integer.parseInt(dis.readUTF());
                int y = Integer.parseInt(dis.readUTF());
                if (server.P1==null || server.P2==null) continue;
                if (server.dd.size()%2==0 && this==server.P2) continue;
                if (server.dd.size()%2==1 && this==server.P1) continue;
                if (x<0 || x>=server.n) continue;
                if (y<0 || y>=server.n) continue;
                boolean trung = false;
                for (Point d : server.dd) {
                    if (d.x==x && d.y == y){
                        trung = true;
                        break;
                    }
                }
                if (trung) continue;
                server.dd.add(new Point(x, y));
                server.sendCoor(x,y);
            }catch(Exception e){

            }

        }
    }

}



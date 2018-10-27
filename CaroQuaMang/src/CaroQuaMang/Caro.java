package CaroQuaMang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Caro extends JFrame implements MouseListener,Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(new Caro());
        t.start();

    }

    int n = 15, s = 30, l = 50;
    List<Point> dd = new ArrayList<>();
    Socket soc;

    public Caro() {
        this.setTitle("Game Caro");
        this.setSize(n * s + l * 2, n * s + l * 2);
        this.setDefaultCloseOperation(3);

        try {
            soc = new Socket("localhost", 2000);
        } catch (Exception e) {

        }

        this.setVisible(true);
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        for (int i = 0; i <= n; i++) {
            g.drawLine(l, l + i * s, l + n * s, l + i * s);
            g.drawLine(l + i * s, l, l + i * s, l + n * s);
        }
        g.setFont(new Font("arial", Font.BOLD, s));
        for (int i = 0; i < dd.size(); i++) {
            String st = "o";
            Color c = Color.BLUE;
            if (i % 2 == 1) {
                st = "x";
                c = Color.RED;
            }
            int x = dd.get(i).x * s + l + s / 2 - s / 4;
            int y = dd.get(i).y * s + l + s / 2 + s / 4;
            g.setColor(c);
            g.drawString(st, x, y);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX() - l;
        int y = e.getY() - l;
        if (x < 0 || x >= n * s)
            return;
        if (y < 0 || y >= n * s)
            return;
        x /= s;
        y /= s;
        for (int i = 0; i < dd.size(); i++)
            if (x == dd.get(i).x && y == dd.get(i).y)
                return;
        try {
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            dos.writeUTF(x + "");
            dos.writeUTF(y + "");
        } catch (Exception e1) {

        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void run() {
        while(true){
            try{
                DataInputStream dis = new DataInputStream(soc.getInputStream());
                int x = Integer.parseInt(dis.readUTF());
                int y = Integer.parseInt(dis.readUTF());
                dd.add(new Point(x, y));
                this.repaint();
            }catch(Exception e){

            }
        }

    }
}

package ThreadChat;

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver extends Thread {
    Socket socket;
    DataInputStream in;
    public Receiver(Socket socket){
        this.socket = socket;

        try{
            in = new DataInputStream(this.socket.getInputStream());
        }catch(Exception e){
            System.out.println("예외:"+e);
        }
    }

    @Override
    public void run(){

        while(in!=null){
            try{
                System.out.println(in.readUTF());

            }catch(Exception e){
                System.out.println("예외:"+e);
            }
        }
    }
}

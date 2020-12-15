package ThreadChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
    Socket socket;
    DataOutputStream out;
    String name;

    public Sender(Socket socket, String name){
        this.socket = socket;
        try{
            out = new
                    DataOutputStream(this.socket.getOutputStream());
            this.name = name;
        }catch(Exception e){
            System.out.println("예외:"+e);
        }
    }

    @Override
    public void run(){

        Scanner s = new Scanner(System.in);
        try {
            //접속자명을 서버로 출력
            out.writeUTF(name);
        } catch (IOException e) {
            System.out.println("예외:"+e);
        }

        while(out!=null){
            try {
                out.writeUTF("["+name+"] "+s.next());

            } catch (IOException e) {
                System.out.println("예외:"+e);
            }
        }
    }
}

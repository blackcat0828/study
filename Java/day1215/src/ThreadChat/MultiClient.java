package ThreadChat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiClient {
    public static void main(String[] args) throws
            UnknownHostException, IOException {

        System.out.println("이름을 입력해 주세요.");
        Scanner s = new Scanner(System.in);
        String s_name = s.next();

        try{
            String ServerIP = "192.168.1.6";
            Socket socket = new Socket(ServerIP, 9999);
            System.out.println("서버와 연결이 되었습니다......");
            Thread sender = new Sender(socket, s_name);

            Thread receiver = new Receiver(socket);
            System.out.println("채팅방에 입장하였습니다.");

            sender.start();
            receiver.start();

        }catch(Exception e){
            System.out.println("예외[MultiClient class]:"+e);
        }
    }
}

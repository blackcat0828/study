package ThreadChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

//멀티채팅 프로그램 서버 프로그램
public class MultiServer {
    //클라이언트의 출력스트림을 저장할 HashMap 생성
    HashMap clientMap;
    //서버에 관련되는 소켓을 관리하는 클래스
    ServerSocket serverSocket = null;
    
    //Socket(소켓)?
    //네트워크 상에서 동작하는 프로그램 간 통신의 종착점
    //Endpoint라고 한다.
    //즉, 프로그램이 네트워크에서 데이터 통신할 수 있도록 연결해주는 연결부 라고 할 수 있다.
    Socket socket = null;

    //생성자
    public MultiServer(){
        clientMap = new HashMap();
        //HashMap 동기화 설정
        //synchronizedMap?
        //Map Collection이 멀티 스레드에 안정되게 하기 위한 메서드
        //하나의 스레드를 처리시 Collection의 모든 자료를 잠금처리하여 다른 스레드의 인터럽트를 방지
        Collections.synchronizedMap(clientMap);
    }
    
    //초기화 작업을 하는 메서드 지정
    public void init(){
        try {
            //TCP 소켓통신을 위한 ServerSocket 객체를 생성하고 클라이언트의 소켓 접속을 기다림
            serverSocket = new ServerSocket(9999);
            System.out.println("서버가 시작되었습니다.");
            while(true){
                //클라이언트의 접속을 기다리다가 접속이 되면 소켓 객체를 생성
                socket = serverSocket.accept();
                //접속하려는 클라이언트의 IP주소, Port번호 출력
                System.out.println(socket.getInetAddress()+":"+socket.getPort());
                //채팅을 위한 스레드를 생성
                Thread msr = new MultiServerRec(socket);
                msr.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendAllMsg(String msg){
        //출력스트림을 순차적으로 가져와서 해당 메시지를 출력한다.
        //keyset() -> Map형태에서 Key값을 순차적으로 가져와서 배열형태로 리턴하고 iterator()에 의해
        //하나씩 순차적으로 처리
        Iterator it = clientMap.keySet().iterator();
        while(it.hasNext()){
            try{
                DataOutputStream it_out = (DataOutputStream) clientMap.get(it.next());
                it_out.writeUTF(msg);
            }catch (Exception e){
                System.out.println("예외:"+e);
            }
        }
    }
    public static void main(String[] args) {
        MultiServer ms = new MultiServer();
        ms.init();
    }


    class MultiServerRec extends Thread {
        Socket socket;
        //DataInputStream ?
        //자바에서 제공하는 기본 자료형(8개)의 값을 바이트 단위로 입력처리

        //DataOutputStream?
        //기본자료형(8개)의 값을 바이트 단위로 출력
        DataInputStream in;
        DataOutputStream out;

        //생성자
        public MultiServerRec(Socket socket){
            this.socket = socket;
            try{
                //채팅을 위한 인스턴스 생성
                //DataInputStream, DataOutputStream?
                //보조스트림이라고 함
                //보조스트림은 단독으로 사용할 수 없고 기반스트림과 함께 사용해야 함.
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            }catch(Exception e){
                System.out.println("예외 : "+e);
            }
        }

        @Override
        public void run(){
            String name = "";
            try{
                //문자열 입력값을 읽어옴
                name = in.readUTF();
                sendAllMsg(name + "님이 입장하셨습니다.");

                clientMap.put(name, out);
                System.out.println("현재 접속자 수는 "+clientMap.size()+"명 입니다.");
                while(in!=null){
                    sendAllMsg(in.readUTF());
                }
            }catch (Exception e){
                System.out.println(e + "-----> ");
            }finally {
                //HashMap에서 해당하는 데이터 삭제처리
                clientMap.remove(name);
                sendAllMsg(name + "님이 퇴장하셨습니다.");
                System.out.println("현재 접속자 수는" +clientMap.size()+"명 입니다.");
            }
        }
    }
}

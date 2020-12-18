package ObjectStreamTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class MemberTest {
    public static void main(String[] args) {
        //Member 클래스를 직렬화
        byte[] serializeMember = new byte[100];
        
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
                //ObjectOutputStream?
                //객체를 직렬화
                try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
                Member m1 = new Member("이순신","test@naver.com",25);
                    //객체를 직렬화해서 출력 스트림으로 보냄
                    oos.writeObject(m1);
                    serializeMember = baos.toByteArray();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Base64.getEncoder().encodeToString(serializeMember));
        //Base 64(64진법)인코딩 방식?
        //Binary 데이터를 Text로 변경하는 인코딩 방식
        //문자열->ASCII binary -> 6비트씩 짜름 -> base64인코딩
        //Base64 사용 이유?
        //Binary 데이터를 시스템에 따라 독립적으로 전송되고 저장 되는 것을 보장하기 위해 사용
    }
}

package ObjectStreamTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class MemberTest2 {
    public static void main(String[] args) throws IOException {
        String base64Member = "rO0ABXNyABdPYmplY3RTdHJlYW1UZXN0Lk1lbWJlcsyosEV1pJ4UAgACSQADYWdlTAAEbmFtZXQAEkxqYXZhL2xhbmcvU3RyaW5nO3hwAAAAGXQACeydtOyInOyLoA==";
        //디코딩 처리
        //base64Member -> 문자열에서 64진법으로 디코딩되어 바이트 배열에 대입
        byte[] serializedMember = Base64.getDecoder().decode(base64Member);

        try(ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)){
            try(ObjectInputStream ois = new ObjectInputStream(bais)){
                Object objectMember = ois.readObject();
                Member member = (Member) objectMember;
                System.out.println(member);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

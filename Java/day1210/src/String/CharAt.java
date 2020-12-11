package String;

public class CharAt {
    public static void main(String[] args) {
        String ssn = "010624-3230123";
        char sex = ssn.charAt(7);
        switch(sex){
            case '1' :
            case '3' :
                System.out.println("남자 입니다.");
                break;
        }

        if(sex == '3'||sex == '1'){
            System.out.println("IF문 남자");
        }

        String result = (sex == '3' ||sex == '1') ? "삼항 남자" : "삼항 여자";
        System.out.println(result);
    }
}

package exceptionExam;

public class LoginMain {
    public static void main(String[] args) {
        String id = null;
        LoginCheck lc = new LoginCheck();

        try {
            lc.setId(id);
        }catch (IDFormatException e){
            System.out.println(e.getMessage());
        }
    }
}

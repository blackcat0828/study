package exceptionExam;

public class LoginCheck {
    private String id;

    public String getId() {
        return id;
    }

    //throws -> 나를 호출한곳에서 처리 (지연 처리)
    //throw -> 강제적 예외를 발생생
   public void setId(String id) throws IDFormatException {
        if(id == null) {
            throw new IDFormatException("아이디는 반드시 입력!");
        }else if(id.length()<8 || id.length()>20){
            throw new IDFormatException("아이디는 8자 이상 20자 이내로 입력");
        }else{
            this.id = id;
        }
    }


}

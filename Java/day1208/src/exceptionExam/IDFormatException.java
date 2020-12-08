package exceptionExam;

//예외처리를 용도에 맞게 코딩
public class IDFormatException extends Exception {

    public IDFormatException(String error){
        super(error);
    }
}

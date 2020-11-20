package prac;

public class finalTest {
    final String name = "김동민";
    final String ssn;
    String nation;

    public finalTest(String ssn, String nation){
        this.ssn = ssn;
        this.nation = nation;
    }

    public static void main(String[] args) {
        finalTest test = new finalTest("ssn","kor");

        test.nation = "ENg";

        System.out.println(test);




    }
}

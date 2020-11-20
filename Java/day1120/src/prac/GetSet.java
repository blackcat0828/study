package prac;



class Parents{
    String motherName;
    String fatherName;
    String grandMa;

    public Parents(String motherName, String fatherName, String grandMa) {
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.grandMa = grandMa;
    }

    public void yelling(){
        System.out.println("나가");
    }
}






public class GetSet extends Parents {
    private String name;
    private String nation;

    public GetSet(String motherName, String fatherName, String grandMa) {
        super(motherName, fatherName, grandMa);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public void yelling() {
        System.out.println("나가라고!");
    }

    public static void main(String[] args) {
        GetSet gs = new GetSet("영주","노파더", "바이");

        gs.yelling();


    }
}

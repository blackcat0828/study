package study;

public class Board {
    String title;
    String content;
    String writer;
    String date;
    int hitcount;



    public Board(String title, String content) {
        this(title,content,"이순신","2020-11-27",100);
    }

    public Board(String title, String content, String writer) {
        this(title,content,writer,"2020-11-27",100);
    }

    public Board(String title, String content, String writer, String date) {
        this(title,content,writer,date,100);
    }

    public Board(String title, String content, String writer, String date, int hitcount) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
        this.hitcount = hitcount;
    }

    public void boardInfo(){
        System.out.println("제목 : "+title);
        System.out.println("내용 : "+content);
        System.out.println("작성자 : "+writer);
        System.out.println("작성일자 : "+date);
        System.out.println("조회수 : "+hitcount);
    }
}

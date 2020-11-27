package study;

public class BoardExample {
    public static void main(String[] args) {
        Board board1 = new Board("주문배송 문의", "빠른 배송 요청");
        Board board2 = new Board("주문배송 문의", "빠른 배송 요청", "이순신");
        Board board3 = new Board("주문배송 문의", "빠른 배송 요청", "이순신", "2020-11-27");
        Board board4 = new Board("주문배송 문의", "빠른 배송 요청", "이순신", "2020-11-27", 100);

        System.out.println("-----board1------");
        board1.boardInfo();

        System.out.println("-----board2------");
        board2.boardInfo();

        System.out.println("-----board3------");
        board3.boardInfo();

        System.out.println("-----board4------");
        board4.boardInfo();
    }
}

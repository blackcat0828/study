package DateClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {

        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1); //Fri Dec 11 14:13:34 KST 2020 영문 현재 시간

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분 ss초");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2); //2020년 12월 11일 금요일 02시 13분 34초
    }
}

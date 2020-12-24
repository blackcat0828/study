CREATE OR REPLACE PROCEDURE selectAllScore
(
    presult out SYS_REFCURSOR
)
IS
BEGIN
        /* 
            커서(Cursor)?
            SELECT문을 통해 결과값들이 나올때 이 결과들을 메모리에
            저장하게 되는데 이때 이 메모리 공간을 커서라고 한다.
            즉, 커서란 쿼리문에 의해 반환되는 결과값들을 저장하는
            메모리 공간이다.
        */
        /*
            오라클 순위 결정 메서드 2가지
            학생번호  이름    총점   순위
            100      이순신   300   
            110      홍길동   400
            120      강감찬   250
            130      허준     400
            
            1.rank()
                공동순위가 나왔을때 1등 두명 표기 세번째는 3등
            2.dense_rank()
                공동순위가 나왔을때 1등 두명 표기 세번째는 2등
        */
        OPEN presult for 
            select sno,sname,kor,math,eng,kor+eng+math as tot, round((kor+math+eng)/3,0) as avg,
                   rank() over(order by (kor+math+eng) desc) as rnk


END selectAllScore;
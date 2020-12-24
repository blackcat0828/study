CREATE OR REPLACE PROCEDURE selectAllScore
(
    presult out SYS_REFCURSOR
)
IS
BEGIN
        /* 
            Ŀ��(Cursor)?
            SELECT���� ���� ��������� ���ö� �� ������� �޸𸮿�
            �����ϰ� �Ǵµ� �̶� �� �޸� ������ Ŀ����� �Ѵ�.
            ��, Ŀ���� �������� ���� ��ȯ�Ǵ� ��������� �����ϴ�
            �޸� �����̴�.
        */
        /*
            ����Ŭ ���� ���� �޼��� 2����
            �л���ȣ  �̸�    ����   ����
            100      �̼���   300   
            110      ȫ�浿   400
            120      ������   250
            130      ����     400
            
            1.rank()
                ���������� �������� 1�� �θ� ǥ�� ����°�� 3��
            2.dense_rank()
                ���������� �������� 1�� �θ� ǥ�� ����°�� 2��
        */
        OPEN presult for 
            select sno,sname,kor,math,eng,kor+eng+math as tot, round((kor+math+eng)/3,0) as avg,
                   rank() over(order by (kor+math+eng) desc) as rnk


END selectAllScore;
CREATE OR REPLACE PROCEDURE updateScore 
(
	pstuNo IN varchar2,
	pkor IN NUMBER,
	peng IN NUMBER,
	pmath IN NUMBER,
	rtncode OUT number
)
IS 

v_count NUMBER;
no_student EXCEPTION;

BEGIN
	SELECT count(sno) -- count(*)은 null 값 포함 count 수 리턴, count(컬럼명) - null 값 배제하고 count 수 리턴
	INTO v_count
	FROM score
	WHERE sno = pstuNo;

	IF v_count = 0 THEN
		raise no_student;
	ELSE
		update score set kor=pkor, math=pmath, eng=peng where sno=pstuNo;
		COMMIT;
	
		rtncode := 0;
	END IF;

	EXCEPTION
	WHEN no_student THEN
	ROLLBACK;
	rtncode := -1;
END updatescore;
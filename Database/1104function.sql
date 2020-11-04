select 10+1 from dual; -- dual은 함수를 확인하기위한 가상 테이블 MYSQL에서는 from dual을 안써도 자동으로 할당

select sysdate(); -- 시스템 날짜 출력;
select user(); -- 현재 사용자 출력

select -10, abs(-10); -- abs는 절대값 absolute

select 34.5678, floor(34.5678); -- floor 소수점이하 버림
select 34.5793, round(34.5793); -- 반올림
select 34.5678, round(34.5678, 2); -- 소수점 2째자리 기준으로 반올림
select 34.5678, round(34.5678, -1); -- 1의자리에서 반올림alter
select mod(27,2), mod(27,5), mod(27,7); -- mod 연산 나머지
select * from usertbl where mod(height, 2) = 1;

select "Welcome To MySQL", upper("Welcome To Mysql");
select substr("Welcome To MySQL", 4, 3); -- 문자 추출 ("", 몇번째글자부터 (-를 붙이면 뒤에서부터 순서를샘), 몇개를 추출) 날짜에서 연도, 월만 추출할때

select instr("Weclome to MySQL", "C"); -- 해당 문장에서 "C"가 몇번째에 나오냐
select "(                   MySQL)", ltrim("                  MYSQL"); -- ltrim 문자열 왼쪽 공백제거  rtrim 문자열 오른쪽 제거
select trim("a" from "aaaaaaaaaaaaMySQLaaaaaaaa"); -- 문자에서 "a" 제거

select sysdate()+interval 1 day, sysdate();
select userid, name, timestampdiff(year, mdate, now()) from usertbl; -- 날짜 차이 구함 year, month, day 등등 가능

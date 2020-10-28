/* userTbl에서 전체 사용자의 아이디와 이름만 출력하세요 */
select userID, name from usertbl;
/* userTbl에서 이름이 이승기인 사용자의 정보를 출력하세요 */
select * from usertbl where name="이승기";
-- userTbl에서 2013년 이전에 가입한 사람들을 출력하세요
select * from usertbl where mdate < "2013-01-01";
-- usertbl에서 키가 182이면서 2008년 이전에 가입한 사람을 출력하세요
select * from usertbl where height = 182 and mdate < "2008-01-01";
-- userTbl에서 키가 182이면서 2008년에 가입한 사람을 출력하세요
select * from usertbl where height = 182 and mdate between "2008-01-01" and "2008-12-31";
-- userTbl에서 1970년대생을 출력하세요
select * from usertbl where birthyear between 1970 and 1979;
-- userTbl에서 휴대폰이 없는 사람을 출력하세요
select * from usertbl where mobile1 is null; 
-- userTbl에서 휴대폰이 있는 사람을 출력하세요
select * from usertbl where mobile1 is not null;
-- userTbl에서 거주지가 서울이 아닌 사람을 출력하세요
select * from usertbl where addr != "서울";
-- userTbl에서 조관우와 같은 지역에 사는 사람을 출력하세요
select * from usertbl where addr = (select addr from usertbl where name = "조관우");
-- userTbl에서 전화번호가 016, 018, 019인 사람을 출력하세요
select * from usertbl where mobile1 in (016, 018, 019);
-- userTbl에서 1970년대생을 제외하고 출력하세요
select * from usertbl where birthyear not between 1970 and 1979;
use sqldb;
select * from usertbl where name='김경호'; 
select * from usertbl where birthyear > 1970 and height >= 182;
select * from usertbl where height >= (select height from usertbl where name = '김경호');

select * from usertbl where addr='경남';

select * from usertbl where height >= ANY(select height from usertbl where addr='경남');

select * from usertbl order by height;
select count(distinct addr) from usertbl;    -- distinct 중복값 제거
select addr from usertbl;

select * from buytbl;  
select userid, SUM(amount) from buytbl group by userid;  

select prodname, sum(amount) from buytbl group by prodname having sum(amount)>7;
select userid, sum(price*amount) from buytbl group by userid;

select userid, avg(amount) from buytbl group by userid;

select sum(amount)/count(distinct userid) as totalAVG from buytbl;

select userid, avg(amount) from buytbl group by userid; -- 각 고객별 평균 구매개수

select count(userID) from usertbl where mobile1 is not null;

select * from usertbl where height = min(height);

select name from usertbl where height = (select min(height) from usertbl) or height = (select max(height) from usertbl);

select * from buytbl;

select userid, sum(price*amount) from buytbl group by userid having sum(price*amount)>1000; 

create table buytbl2(select * from buytbl);
select * from buytbl2;

create table buytbl3(select userid from buytbl);
select * from buytbl3;

select * from buytbl;
select * from buytbl2;

update buytbl2 set price = 250 where prodname = '모니터';
update buytbl2 set price = price+50;

delete from buytbl2 where userid = 'BBK';
select * from buytbl2;





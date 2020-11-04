select * from buytbl, usertbl -- 크로스조인 데이터 뻥튀기할때 좋음
select * from buytbl, usertbl where buytbl.userid = usertbl.userid; -- inner 조인  
select buytbl.*, usertbl.name, usertbl.addr from buytbl, usertbl where buytbl.userid=usertbl.userid;
select b.*, u.name, u.addr from buytbl b, usertbl u where b.userid=u.userid;

select b.*, u.name, u.addr from buytbl b right join usertbl u on b.userid= u.userid;
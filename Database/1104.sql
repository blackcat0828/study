drop database if exists fintech;
create database fintech;
use fintech; 

drop table if exists dept;
create table dept(
deptno int(2) primary key,  /*부서번호*/
dname varchar(20) not null, /*부서이름*/
loc varchar(20)				/*지역*/
);

drop table if exists emp;
create table emp(
empno int(4) primary key,  /*사원번호*/
ename varchar(10) not null,  /*사원이름*/
job varchar(20) not null,   /*직급*/
mgr int(4),                 /*매니저*/
hiredate date,              /*입사일*/
sal int(8),                 /*연봉*/ 
comm int(8),                /*커미션*/
deptno int(2),              /*부서번호*/
grade int,
foreign key(deptno) references dept(deptno));

drop table if exists grade;


insert into dept values (10, 'ACCOUNTING', 'NEW YORK'),
						(20, 'RESEARCH', 'DALLAS'),
						(30, 'SALES', 'CHICAGO'),
						(40, 'OPERATING', 'BOSTON');

insert into emp values (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20, 1),
					   (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30, 3),
                       (7521, 'WARD', 'SALESMAN', 7609, '1981-02-22', 1250, 500, 30, 2),
                       (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20, 4),
                       (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30, 2),
                       (7698, 'BLACK', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30, 4),
                       (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10, 4),
                       (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19', 3000, NULL, 20, 4),
                       (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10, 5),
                       (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30, 3),
                       (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100, NULL, 20, 1),
                       (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30, 1),
                       (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20, 4),
                       (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10, 2);
                       

select * from dept;
use fintech;
select * from dept;
select * from emp;
-- 급여가 1500 이하인 사원의 사원번호, 사원명, 급여를 출력
select empno, ename, sal from emp where sal <= 1500;
-- SCOTT 사원의 사원번호, 사원명, 급여 출력
select empno, ename, sal from emp where ename = 'SCOTT';
-- 10번 부서 소속 사원들 중 직급이 MANAGER인 사원의 사원명, 부서번호, 직급 출력
select ename, deptno, job from emp where deptno=10 and job = 'MANAGER';
-- 10번 부서 소속이 아닌 사원의 사원명, 부서번호, 직급
select ename, deptno, job from emp where not deptno=10;
-- 급여가 2000에서 3000 사이의 사원의 사원명, 부서번호, 연봉 출력
select ename, deptno, sal from emp where sal between 2000 and 3000;
-- 커미션이 300이거나 500이거나 1400인 사원의 사원명, 사원번호, 커미션, 급여 출력
select ename, empno, comm, sal from emp where comm in (300,500,1400);
-- 1987년도에 입사한 사원의 사원번호, 사원명, 급여, 입사일
select empno, ename, sal, hiredate from emp where hiredate between '1987-01-01' and '1987-12-31'; -- between이 LIKE, substr보다 성능이 가장좋음
-- 이름중에 A가 들어가는 사원의 사원번호, 사원명 출력
select empno, ename from emp where ename like "%A%";
-- 이름에서 3번째 글자가 R인 사원의 사원번호, 사원명 출력
select empno, ename from emp where ename like "__R%";
-- 커미션이 null인 사원의 사원번호, 사원명, 커미션
select empno, ename, comm from emp where comm is null;

-- 급여를 오름차순으로 정렬하여 사원번호, 사원명, 급여 출력
select empno, ename, sal from emp order by sal;
-- 입사일이 오래된 사원부터 사원번호, 사원명, 입사일 출력
select empno, ename, hiredate from emp order by hiredate;
-- SCOTT과 같은 부서에 근무하는 사원의 이름과 부서번호 출력
select ename, deptno from emp where deptno = (select deptno from emp where ename = 'SCOTT');
-- SCOTT이 소속된 부서이름 출력
select dname from dept where deptno = (select deptno from emp where ename = 'SCOTT');
-- DALLAS에서 근무하는 사원의 이름, 부서 번호 출력
select ename, deptno from emp where deptno = (select deptno from dept where loc="DALLAS");
-- 자신의 매니저가 KING인 사원의 이름과 급여 출력
select ename, sal from emp where mgr = (select empno from emp where ename = 'KING');
-- 급여가 3000이상인 사원이 소속된 부서에 속한 사원들의 부서번호, 사원명, 급여 출력
select deptno, ename, sal from emp where deptno = any(select deptno from emp where sal >= 3000); -- =any대신 in도 사용가능
-- 직급이 MANAGER인 사원이 속한 부서의 부서번호, 부서명, 지역 출력
select deptno, dname, loc from dept where deptno in(select deptno from emp where job = 'MANAGER');
-- 30번 부서 사원들 중 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여 출력
select ename, sal from emp where sal > (select max(sal) from emp where deptno = 30);
-- 직급이 SALESMAN인 사원이 받는 급여들의 최소 급여보다 더 많이 받는 사원들의 이름과 급여를 출력하되, RESEARCH 부서의 사원은 제외
select ename, sal from emp where deptno != (select deptno from dept where dname = 'RESEARCH') and sal > (select MIN(sal) from emp where job = 'SALESMAN');
-- 부서별 평균급여가 2000이상인 부서의 부서번호, 부서별 평균급여를 출력
select deptno, avg(sal) from emp group by deptno having avg(sal) >= 2000;
-- 부서별로 가장 급여가 많은 사원을 사원번호, 사원명, 급여, 부서번호로 출력
select empno, ename, sal, deptno from emp where (deptno, sal) in (select deptno, max(sal) from emp group by deptno); -- where sal in (select max(sal) from emp group by deptno);
-- 사원번호, 사원명, 매니저번호, 매니저명으로 출력
select e.empno, e.ename, e.mgr, e2.ename from emp e left join emp e2 on e.mgr = e2.empno; 
-- 
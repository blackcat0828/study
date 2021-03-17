package board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//Bean등록
@Component
//해당 클래스가 Aspect기능을 수행한다는 선언
@Aspect
public class LoggerAspect {
	
	//LogBack 이용
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//대상 메서드(JointPoint) 호출 전후,예외발생시 모든 시점에 적용시킬수 있는
	//공통기능을 선언
	//첫번째 execution ?
	//접근제한자,리턴타입은 상관없고 board 패키지를 포함한 하위패키지 중에서
	//패키지명이 controller 이면서 클래스의 명이 Controller로 끝나는 자바
	//프로그램이면서 모든 메서드에 적용시키고 매개변수는 0개 이상에 공통기능을 적용
	//두번째 execution ?
	//접근제한자,리턴타입은 상관없고 board 패키지를 포함한 하위패키지 중에서
	//패키지명이 service 이면서 클래스의 명이 Impl로 끝나는 자바
	//프로그램이면서 모든 메서드에 적용시키고 매개변수는 0개 이상에 공통기능을 적용
	//세번째 execution ?
	//접근제한자,리턴타입은 상관없고 board 패키지를 포함한 하위패키지 중에서
	//패키지명이 dao 이면서 클래스의 명이 Mapper로 끝나는 자바
	//프로그램이면서 모든 메서드에 적용시키고 매개변수는 0개 이상에 공통기능을 적용	
	@Around("execution(* board..controller.*Controller.*(..)) or  "
			+ "execution(* board..service.*Impl.*(..)) or "
			+ "execution(* board..mapper.*Mapper.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable{
		
		 String type = "";
		 //getSignature() ?
		 //호출되는 메서드 이름
		 //getDeclaringTypeName() ?
		 //joinPoint 가 만약에 메서드 이면 해당 메서드를 포함하는 클래스 명을 가져옴
		 String name = joinPoint.getSignature().getDeclaringTypeName();
		 
		 //joinPoint가 적용된 클래스의 이름
		 if(name.indexOf("Controller") > -1) {
			 type = "Controller \t: ";
		 }else if(name.indexOf("Service") > -1) {
			 type = "ServiceImpl \t: ";
		 }else if(name.indexOf("Mapper") > -1) {
			 type = "Mapper \t: ";
		 }
		 
		 log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
		 
		 //joinPoint 실행
		 return joinPoint.proceed();
	}
	
	

}







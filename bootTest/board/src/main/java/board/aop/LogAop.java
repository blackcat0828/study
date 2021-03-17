package board.aop;

import java.text.SimpleDateFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	//현재일시
	SimpleDateFormat sf = 
		new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

	@Pointcut("within(board.aop.*)")
	private void pointCutMethod() {
		System.out.println("pointCutMethod()");
	}
	
	@Around("pointCutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) 
			   throws Throwable {
		
		//공통기능이 적용되는 메서드 명을 가져온다.
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " 시작");
		
		System.out.println("핵심 기능전에 실행할 공통 기능입니다." +
		         sf.format(System.currentTimeMillis()));

		//proceed() 를 기준으로 이전은 @Before가 수행되고
		//@After가 수행된다.
		try {
				Object obj = joinpoint.proceed();
				return obj;
		}finally {
			System.out.println("핵심 기능후에 실행할 공통 기능입니다." + 
				sf.format(System.currentTimeMillis()));
			System.out.println(signatureStr + "종료");
		}
	
	}
	
	@Before("within(board.aop.*)")
	public void beforeMethod() {
		System.out.println("beforeMethod() 실행");
	}
	
	@After("within(board.aop.*)")
	public void afterMethod() {
		System.out.println("afterMethod() 실행");
	}
	
	
}





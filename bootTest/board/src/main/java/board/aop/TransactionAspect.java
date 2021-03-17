package board.aop;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

//어노테이션 기반의 환경구성을 하는 것으로 클래스가 하나 이상의 @Bean 메서드를 
//제공하고 스프링 컨테이너가 Bean 정의를 생성하고 런타임(RumTime)시 그 Bean들이
//요청들을 처리할 수 있도록 도와주는 어노테이션이다.
@Configuration
public class TransactionAspect {

	//Transaction 처리를 적용할 메서드 지정
	private static final String AOP_TRANSACTION_METHOD_NAME = "*";
	private static final String AOP_TRANSACTION_EXPRESSION 
	      = "execution(* board..service.*Impl.*(..))";
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	//선언적 트랜잭션 관리를 제공하는 AOP 메서드 인터셉터
	@Bean
	public TransactionInterceptor transactionAdvice() {
		
		MatchAlwaysTransactionAttributeSource source = 
			new MatchAlwaysTransactionAttributeSource();
		
		//특정 예외가 Rollback 규칙을 적용하여 트랜잭션 Rollback을
		//발생시키는지 여부를 확인하는 TransactionAttribute를 구현함.
		RuleBasedTransactionAttribute transactionAttribute =
			new RuleBasedTransactionAttribute();
		
		transactionAttribute.setName(AOP_TRANSACTION_METHOD_NAME);
		//Collections.singletonList ?
		//1개의 element(요소)로 구성된 객체로 immutable(불변) 리스트를 반환한다.
		//예외처리가 발생하면 무조건 Rollback 처리한다.
		transactionAttribute.setRollbackRules(
			Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		
		source.setTransactionAttribute(transactionAttribute);
		
		return new TransactionInterceptor(transactionManager,source);
		
	}
	
	@Bean
	public Advisor transactionAdviceAdvisor() {
		
		//PointCut 설정하는 클래스로
		//aspectjrt.jar와 aspectjweaver.jar 파일이 반드시 필요하다.
		AspectJExpressionPointcut pointcut =  
				new AspectJExpressionPointcut();

		//공통기능을 적용할 joinPoint(메서드)를 aspectJ 문법을 이용해
		//선언한다.
		pointcut.setExpression(AOP_TRANSACTION_EXPRESSION);
		
		return new DefaultPointcutAdvisor(pointcut,transactionAdvice());
		
	}

}
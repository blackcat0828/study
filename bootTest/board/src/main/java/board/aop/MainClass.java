package board.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {

		AbstractApplicationContext ctx = 
		new GenericXmlApplicationContext("classpath:applicationCtx.xml");
		
		Cats myCat = ctx.getBean("myCat",Cats.class);
		myCat.getCatsInfo();
		
		ctx.close();
		

	}

}

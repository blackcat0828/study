package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration + @ComponentScan + @Configuration
//@EnableAutoConfiguration ?
//Spring.Factories 안의 많은 설정들이 적용되고 Bean등록을 자동으로 해준다.
//@ComponentScan ?
//여러 클래스에 있는 어노테이션 검색기능을 활성화하여 자동으로 컴포넌트를 검색하고
//빈등록을 해준다.(@Controller,@RestController,@Service등등)
//@Configuration?
//해당 클래스가 자바기반 설정 파일임을 선언
@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
